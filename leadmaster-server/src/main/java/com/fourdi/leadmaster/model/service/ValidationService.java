package com.fourdi.leadmaster.model.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fourdi.leadmaster.model.domain.RawData;
import com.fourdi.leadmaster.model.domain.ValidatedData;
import com.fourdi.leadmaster.model.domain.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ValidationService {
    @Autowired private ObjectMapper jacksonObjectMapper;

    private ValidationError checkHasEmailOrPhone(final RawData rawData) {
        if (rawData.getPhone1() == null &&
                rawData.getPhone2() == null &&
                rawData.getPhone3() == null &&
                rawData.getEmail() == null) {
            return new ValidationError("rawData", ValidationError.Level.hard, "Lead has no phone number or email");
        }
        else {
            return null;
        }
    }

    private ValidationError checkValidFirstName(final RawData rawData) {
        return null;
    }

    private ValidationError checkValidLastName(final RawData rawData) {
        return null;
    }

    public ValidatedData validateLead(final RawData rawData) {
        ValidationError error;
        Stream.Builder<ValidationError> builder = Stream.builder();
        if((error = checkHasEmailOrPhone(rawData)) != null) { builder.add(error); }
        if((error = checkValidFirstName(rawData))  != null) { builder.add(error); }
        if((error = checkValidLastName(rawData))   != null) { builder.add(error); }

        Stream<ValidationError> errors = builder.build();
        String errorString;
        try {
            errorString = jacksonObjectMapper.writeValueAsString(errors.collect(Collectors.toList()));
        }
        catch (JsonProcessingException e) {
            errorString = "Unknown Errors";
        }

        return new ValidatedData(rawData, errors, errorString);
    }

    public Stream<ValidatedData> validateLeads(final Stream<RawData> leads) {
        return leads.parallel().map(rawlead -> validateLead(rawlead));
    }
}
