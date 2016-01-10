package com.fourdi.leadmaster.model.service;

import com.fourdi.leadmaster.model.domain.DedupeResolution;
import com.fourdi.leadmaster.model.domain.DedupeResult;
import com.fourdi.leadmaster.model.domain.LeadIndex;
import com.fourdi.leadmaster.model.domain.ValidatedLead;
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
