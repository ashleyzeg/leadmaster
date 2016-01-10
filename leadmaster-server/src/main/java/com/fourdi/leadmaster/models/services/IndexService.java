package com.fourdi.leadmaster.models.services;

import com.fourdi.leadmaster.models.domain.LeadIndex;
import com.fourdi.leadmaster.models.domain.ValidatedLead;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class IndexService {
    public LeadIndex newIndex() {
        return new LeadIndex();
    }

    public LeadIndex updateIndex(final LeadIndex index, Stream<ValidatedLead> leads) {
        return index;
    }
}

