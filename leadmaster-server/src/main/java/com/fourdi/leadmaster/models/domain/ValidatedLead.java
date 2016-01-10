package com.fourdi.leadmaster.models.domain;


import java.util.stream.Stream;

public class ValidatedLead {
    private final Rawlead rawlead;
    private final Stream<ValidationError> errors;

    public ValidatedLead(Rawlead rawlead, Stream<ValidationError> errors) {
        this.rawlead = rawlead;
        this.errors  = errors;
    }

    public Rawlead getRawlead() {
        return rawlead;
    }

    public Stream<ValidationError> getErrors() {
        return errors;
    }
}
