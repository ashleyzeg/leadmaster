package com.fourdi.leadmaster.model.service;

import com.fourdi.leadmaster.model.domain.LeadIndex;
import com.fourdi.leadmaster.model.domain.UnprocessedData;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class IndexService {
    public LeadIndex newIndex() {
        return new LeadIndex();
    }

    public LeadIndex updateIndex(final LeadIndex index, Stream<UnprocessedData> leads) {
        return index;
    }
}

