package com.fourdi.leadmaster.model.service;

import com.fourdi.leadmaster.model.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Reader;
import java.util.stream.Stream;

@Service
public class PipelineService {
    private final RawleadService     rawleadService;
    private final ValidationService  validationService;
    private final PersistenceService persistenceService;
    private final IndexService       indexService;
    private final DedupeService      dedupeService;

    @Autowired
    public PipelineService(final RawleadService     rawleadService,
                           final ValidationService  validationService,
                           final PersistenceService persistenceService,
                           final IndexService       indexService,
                           final DedupeService      dedupeService) {
        this.rawleadService     = rawleadService;
        this.validationService  = validationService;
        this.persistenceService = persistenceService;
        this.indexService       = indexService;
        this.dedupeService      = dedupeService;
    }

    /**
     * Process a file of leads.  The upload descriptor should have already been written to the
     * database prior to being passed to processLeadFile.
     *
     * @param reader            A reader initialized to point to the data to be uploaded.
     * @param uploadDescriptor  The descriptor for the upload.
     */
    public void processLeadFile(Reader reader, Upload uploadDescriptor) {
        if (uploadDescriptor.getId() == null) {
            return;
        }

        LeadIndex leadIndex = indexService.newIndex();

        Stream<RawData>          xformedLeads   = rawleadService.mapAndXform(reader);
        Stream<ValidatedData>    validatedLeads = validationService.validateLeads(xformedLeads);
        Stream<UnprocessedData>  persistedLeads = persistenceService.writeNewLeads(validatedLeads);
                                 leadIndex      = indexService.updateIndex(leadIndex, persistedLeads);
        Stream<DedupeResult>     dedupeResults  = dedupeService.dedupe(leadIndex, persistedLeads);
        Stream<DedupeResolution> resolutions    = dedupeService.autoresolve(leadIndex, dedupeResults);
        Stream<DedupeResolution> finalResults   = persistenceService.updatedMergedLeads(resolutions);
    }
}
