package com.fourdi.leadmaster.model;

import com.fourdi.leadmaster.LeadmasterServer;
import com.fourdi.leadmaster.model.domain.RawDatas;
import com.fourdi.leadmaster.model.domain.ValidatedData;
import com.fourdi.leadmaster.model.service.PersistenceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.stream.Stream;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(LeadmasterServer.class)
@PropertySource(value= {"classpath:*.properties"})
public class PersistenceServiceTest {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    PersistenceService persistenceService;

    @Test
    public void writeValidatedLeadTest() {
        RawDatas rl = new RawDatas("Mike", "Burroughs", null, null, null, null, null, "Some Company", null, null, null, null, null, null, null, null, null);
        ValidatedData vl = new ValidatedData(rl, Stream.empty(), "");
        persistenceService.writeData(vl);
    }
}
