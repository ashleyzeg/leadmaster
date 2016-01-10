package com.fourdi.leadmaster.models.services;

import com.fourdi.leadmaster.models.domain.DedupeResolution;
import com.fourdi.leadmaster.models.domain.ValidatedLead;
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

