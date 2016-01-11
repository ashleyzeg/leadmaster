package com.fourdi.leadmaster.model;

import com.fourdi.leadmaster.LeadmasterServer;
import com.fourdi.leadmaster.model.domain.RawData;
import com.fourdi.leadmaster.model.domain.ValidatedData;
import com.fourdi.leadmaster.model.service.ValidationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(LeadmasterServer.class)
public class ValidationServiceTest {
    Logger logger = LoggerFactory.getLogger(ValidationServiceTest.class);

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    ValidationService validationService;

    @Test
    public void checkHasEmailOrPhoneTest() {
        RawData rl = new RawData(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
        ValidatedData vl = validationService.validateLead(rl);
        Assert.notNull(vl);
    }

}
