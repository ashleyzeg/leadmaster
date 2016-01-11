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

    @Autowired
    public PersistenceService(LeadMapper leadMapper) {
        this.leadMapper = leadMapper;
    }

    private Company addCompany(ValidatedData validatedData) {
        Company company = new Company(validatedData);
        leadMapper.insertCompany(company);
        return company;
    }

    private Lead addLead(ValidatedData validatedData) {
        Lead lead = new Lead(validatedData);
        leadMapper.insertLead(lead);
        return lead;
    }

    private Employment addEmployment(Lead lead, Company company, String title) {
        Employment emp = new Employment(lead.getId(), company.getId(), null, title);
        leadMapper.insertEmployment(emp);
        return emp;
    }

    public UnprocessedData writeData(ValidatedData validatedData) {
        logger.debug("Writing lead {} {}", validatedData.getFirstname(), validatedData.getLastname());
        if(validatedData.hasHardErrors()) {
            return new UnprocessedData(validatedData);
        }
        else {
            Lead    lead    = addLead(validatedData);
            Company company = null;

            if (validatedData.getCompanyname() != null) {
                company = addCompany(validatedData);
                addEmployment(lead, company, validatedData.getTitle());
            }
            return new UnprocessedData(validatedData, lead, company);
        }
    }

    public Stream<UnprocessedData> writeNewLeads(Stream<ValidatedData> leads) {
        return leads.parallel().map(this::writeData);
    }

    public Stream<DedupeResolution> updatedMergedLeads(Stream<DedupeResolution> resolutions) {
        return resolutions;
    }
}

