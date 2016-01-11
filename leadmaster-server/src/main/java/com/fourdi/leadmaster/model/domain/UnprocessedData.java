package com.fourdi.leadmaster.model.domain;


public class UnprocessedData {
    private final ValidatedData validatedData;
    private final Lead          lead;
    private final Company       company;

    public UnprocessedData(ValidatedData validatedData) {
        this.validatedData = validatedData;
        this.lead          = null;
        this.company       = null;
    }

    public UnprocessedData(ValidatedData validatedData, Lead lead, Company company) {
        this.validatedData = validatedData;
        this.lead          = lead;
        this.company       = company;
    }

    public ValidatedData getValidatedData() {
        return validatedData;
    }

    public Lead getLead() {
        return lead;
    }
}
