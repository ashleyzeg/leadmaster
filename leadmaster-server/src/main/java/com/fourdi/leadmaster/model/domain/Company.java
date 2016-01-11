package com.fourdi.leadmaster.model.domain;

public class Company {
    private final Integer id;
    private final String  companyref;
    private final String  companyname;
    private final String  status;
    private final Integer merged_to;
    private final String  validation_errors;

    public Company(ValidatedData validatedData) {
        this.id = null;
        this.companyref = validatedData.getCompanyref();
        this.companyname = validatedData.getCompanyname();
        this.status = "UNPROCESSED";
        this.merged_to = null;
        this.validation_errors = validatedData.getErrorString();
    }

    public Integer getId() {
        return id;
    }

    public String getCompanyref() {
        return companyref;
    }

    public String getCompanyname() {
        return companyname;
    }

    public String getStatus() {
        return status;
    }

    public Integer getMerged_to() {
        return merged_to;
    }

    public String getValidation_errors() {
        return validation_errors;
    }
}