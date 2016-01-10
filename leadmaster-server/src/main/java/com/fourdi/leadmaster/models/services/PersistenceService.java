package com.fourdi.leadmaster.models.services;

import com.fourdi.leadmaster.models.domain.ValidatedLead;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class PersistenceService {
    public Stream<ValidatedLead> writeLeadsToDB(Stream<ValidatedLead> leads) {
        return leads;
    }
}
