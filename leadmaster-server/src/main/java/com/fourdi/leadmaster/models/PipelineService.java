package com.fourdi.leadmaster.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Reader;
import java.util.List;
import java.util.stream.Stream;

@Service
public class PipelineService {
    private final RawleadService    rawleadService;
    private final ValidationService validationService;

    @Autowired
    public PipelineService(final RawleadService    rawleadService,
                           final ValidationService validationService) {
        this.rawleadService    = rawleadService;
        this.validationService = validationService;
    }

    public void processLeadFile(Reader reader) {
        Stream<Rawlead>       xformedLeads   = rawleadService.mapAndXform(reader);
        Stream<ValidatedLead> validatedLeads = validationService.validateLeads(xformedLeads);
    }
}
