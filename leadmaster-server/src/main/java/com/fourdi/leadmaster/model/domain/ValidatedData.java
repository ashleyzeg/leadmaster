package com.fourdi.leadmaster.model.domain;

import java.util.stream.Stream;

public class ValidatedData {
    private final RawDatas rawData;
    private final Stream<ValidationError> errors;
    private final String errorString;

    public ValidatedData(RawDatas rawData, Stream<ValidationError> errors, String errorString) {
        this.rawData = rawData;
        this.errors = errors;
        this.errorString = errorString;
    }

    public RawDatas getRawData() {
        return rawData;
    }

    public Stream<ValidationError> getErrors() {
        return errors;
    }

    public String getErrorString() {
        return errorString;
    }

    public String getFirstname() {
        return rawData.getFirstname();
    }

    public String getLastname() {
        return rawData.getLastname();
    }

    public String getPostalcode() {
        return rawData.getPostalcode();
    }

    public String getCity() {
        return rawData.getCity();
    }

    public String getState() {
        return rawData.getState();
    }

    public String getCountry() {
        return rawData.getCountry();
    }

    public String getEmail() {
        return rawData.getEmail();
    }

    public String getCompanyname() {
        return rawData.getCompanyname();
    }

    public String getPhone1() {
        return rawData.getPhone1();
    }

    public String getPhone2() {
        return rawData.getPhone2();
    }

    public String getPhone3() {
        return rawData.getPhone3();
    }

    public String getLeadref() {
        return rawData.getLeadref();
    }

    public String getTitle() {
        return rawData.getTitle();
    }

    public String getCompanyref() {
        return rawData.getCompanyref();
    }

    public String getActivity() {
        return rawData.getActivity();
    }

    public String getActivity_date() {
        return rawData.getActivity_date();
    }

    public String getActivity_result() {
        return rawData.getActivity_result();
    }

    public boolean hasHardErrors() {
        return errors.anyMatch(ve -> ve.getErrorLevel() == ValidationError.Level.hard);
    }
}
