package com.fourdi.leadmaster.model.domain;

public class ValidationError {
    public enum Level {hard, soft};

    private final String field;
    private final Level  errorLevel;
    private final String description;

    public ValidationError(String field, Level errorLevel, String description) {
        this.field       = field;
        this.errorLevel  = errorLevel;
        this.description = description;
    }

    public String getField() {
        return field;
    }

    public Level getErrorLevel() {
        return errorLevel;
    }

    public String getDescription() {
        return description;
    }
}
