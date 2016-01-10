package com.fourdi.leadmaster.models.services;

import com.fourdi.leadmaster.models.domain.LeadIndex;
import com.fourdi.leadmaster.models.domain.Rawlead;
import com.fourdi.leadmaster.models.domain.ValidatedLead;
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

    @Autowired
    public PipelineService(final RawleadService     rawleadService,
                           final ValidationService  validationService,
                           final PersistenceService persistenceService,
                           final IndexService       indexService) {
        this.rawleadService     = rawleadService;
        this.validationService  = validationService;
        this.persistenceService = persistenceService;
        this.indexService       = indexService;
    }

    public void processLeadFile(Reader reader) {
        LeadIndex leadIndex = indexService.newIndex();

        Stream<Rawlead>       xformedLeads   = rawleadService.mapAndXform(reader);
        Stream<ValidatedLead> validatedLeads = validationService.validateLeads(xformedLeads);
        Stream<ValidatedLead> persistedLeads = persistenceService.writeLeadsToDB(validatedLeads);
                              leadIndex      = indexService.updateIndex(leadIndex, persistedLeads);
    }
}
