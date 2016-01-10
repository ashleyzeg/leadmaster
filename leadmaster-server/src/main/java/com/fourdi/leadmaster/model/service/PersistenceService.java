package com.fourdi.leadmaster.model.service;

import com.fourdi.leadmaster.model.domain.DedupeResolution;
import com.fourdi.leadmaster.model.domain.ValidatedLead;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class PersistenceService {
    public Stream<ValidatedLead> writeNewLeads(Stream<ValidatedLead> leads) {
        return leads;
    }

    public Stream<DedupeResolution> updatedMergedLeads(Stream<DedupeResolution> resolutions) {
        return resolutions;
    }
}

