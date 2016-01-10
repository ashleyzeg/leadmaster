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

    public void processLeadFile(Reader reader) {
        LeadIndex leadIndex = indexService.newIndex();

        Stream<Rawlead>          xformedLeads   = rawleadService.mapAndXform(reader);
        Stream<ValidatedLead>    validatedLeads = validationService.validateLeads(xformedLeads);
        Stream<ValidatedLead>    persistedLeads = persistenceService.writeNewLeads(validatedLeads);
                                 leadIndex      = indexService.updateIndex(leadIndex, persistedLeads);
        Stream<DedupeResult>     dedupeResults  = dedupeService.dedupe(leadIndex, persistedLeads);
        Stream<DedupeResolution> resolutions    = dedupeService.autoresolve(leadIndex, dedupeResults);
        Stream<DedupeResolution> finalResults   = persistenceService.updatedMergedLeads(resolutions);
    }
}
