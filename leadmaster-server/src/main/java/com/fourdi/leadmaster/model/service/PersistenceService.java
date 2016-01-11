package com.fourdi.leadmaster.model.service;

import com.fourdi.leadmaster.model.domain.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class PersistenceService {
    Logger logger = org.slf4j.LoggerFactory.getLogger(PersistenceService.class);

    private final LeadMapper leadMapper;
    private final CompanyMapper companyMapper;

    @Autowired
    public PersistenceService(LeadMapper leadMapper, CompanyMapper companyMapper) {
        this.leadMapper = leadMapper;
        this.companyMapper = companyMapper;
    }

    private Company addCompany(ValidatedData validatedData) {
        Company company = new Company(validatedData);
        companyMapper.insertCompany(company);
        return company;
    }

    private Lead addLead(ValidatedData validatedData) {
        Lead lead = new Lead(validatedData);
        leadMapper.insertLead(lead);
        return lead;
    }

    public UnprocessedData writeData(ValidatedData validatedData) {
        logger.debug("Writing lead {} {}", validatedData.getFirstname(), validatedData.getLastname());
        if(validatedData.hasHardErrors()) {
            return new UnprocessedData(validatedData);
        }
        else {
            Lead lead = addLead(validatedData);
            Company company = (validatedData.getCompanyname() != null) ? addCompany(validatedData) : null;
            return new UnprocessedData(validatedData, lead, company);
        }
    }

    public Stream<UnprocessedData> writeNewLeads(Stream<ValidatedData> leads) {
        return leads.parallel().map(lead -> writeData(lead));
    }

    public Stream<DedupeResolution> updatedMergedLeads(Stream<DedupeResolution> resolutions) {
        return resolutions;
    }
}

