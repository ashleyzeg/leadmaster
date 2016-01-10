package com.fourdi.leadmaster.model.service;

import com.fourdi.leadmaster.model.domain.Rawlead;
import com.fourdi.leadmaster.model.domain.ValidatedLead;
import com.fourdi.leadmaster.model.domain.ValidationError;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class ValidationService {

    private ValidationError checkHasEmailOrPhone(final Rawlead rawlead) {
        if (rawlead.getPhone1() == null &&
                rawlead.getPhone2() == null &&
                rawlead.getPhone3() == null &&
                rawlead.getEmail() == null) {
            return new ValidationError("email:phone1:phone2:phone3", ValidationError.Level.hard, "Lead has no phone number or email");
        }
        else {
            return null;
        }
    }

    private ValidationError checkValidFirstName(final Rawlead rawlead) {
        return null;
    }

    private ValidationError checkValidLastName(final Rawlead rawlead) {
        return null;
    }

    private ValidatedLead validateLead(final Rawlead rawlead) {
        ValidationError error;
        Stream.Builder<ValidationError> errors = Stream.builder();
        if((error = checkHasEmailOrPhone(rawlead)) == null) { errors.add(error); }
        if((error = checkValidFirstName(rawlead))  == null) { errors.add(error); }
        if((error = checkValidLastName(rawlead))   == null) { errors.add(error); }

        return new ValidatedLead(rawlead, errors.build());
    }

    public Stream<ValidatedLead> validateLeads(final Stream<Rawlead> leads) {
        return leads.parallel().map(rawlead -> validateLead(rawlead));
    }
}
