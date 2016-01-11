package com.fourdi.leadmaster.model.domain;


public class Lead {
    private final Integer id;
    private final String  leadref;
    private final String  firstname;
    private final String  lastname;
    private final String  postalcode;
    private final String  city;
    private final String  state;
    private final String  country;
    private final String  status;
    private final Integer merged_to;
    private final String  validation_errors;

    public Lead(ValidatedData validatedData) {
        this.id = null;
        this.leadref = validatedData.getLeadref();
        this.firstname = validatedData.getFirstname();
        this.lastname = validatedData.getLastname();
        this.postalcode = validatedData.getPostalcode();
        this.city = validatedData.getCity();
        this.state = validatedData.getState();
        this.country = validatedData.getCountry();
        this.status = "UNPROCESSED";
        this.merged_to = null;
        this.validation_errors = validatedData.getErrorString();
    }

    public Integer getId() {
        return id;
    }

    public String getLeadref() {
        return leadref;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
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
