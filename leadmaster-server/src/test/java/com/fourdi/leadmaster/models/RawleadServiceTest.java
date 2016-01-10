package com.fourdi.leadmaster.models;

import com.fourdi.leadmaster.LeadmasterServer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;
import java.util.stream.Stream;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(LeadmasterServer.class)
public class RawleadServiceTest {

    @Autowired RawleadService rawleadService;

    @Test
    public void mapAndXformTest() throws FileNotFoundException{
        Reader r = new FileReader(new File("src/test/10leadtest.csv"));
        Stream<Rawlead> results = rawleadService.mapAndXform(r);
        Assert.assertNotNull(results);
        Assert.assertEquals(17, results.count());
    }
}
