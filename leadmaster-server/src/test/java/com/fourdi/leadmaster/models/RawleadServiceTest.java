package com.fourdi.leadmaster.models;

import com.fourdi.leadmaster.LeadmasterServer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.Reader;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(LeadmasterServer.class)
public class RawleadServiceTest {

    @Autowired RawleadService rawleadService;

    @Test
    public void mapAndXformTest() {
        Reader r = null;
        Assert.assertNull(rawleadService.mapAndXform(r));
    }
}
