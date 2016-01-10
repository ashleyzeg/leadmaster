package com.fourdi.leadmaster.models.services;

import com.fourdi.leadmaster.models.domain.DedupeResolution;
import com.fourdi.leadmaster.models.domain.DedupeResult;
import com.fourdi.leadmaster.models.domain.LeadIndex;
import com.fourdi.leadmaster.models.domain.ValidatedLead;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class DedupeService {
    public Stream<DedupeResult> dedupe(final LeadIndex leadIndex, Stream<ValidatedLead> leads) {
        Stream.Builder<DedupeResult> results = Stream.builder();

        return results.build();
    }

    public Stream<DedupeResolution> autoresolve(final LeadIndex leadIndex, Stream<DedupeResult> dupes) {
        Stream.Builder<DedupeResolution> results = Stream.builder();

        return results.build();
    }

}
