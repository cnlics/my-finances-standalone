package com.rootls;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by luowei on 2014/7/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MyApplication.class)
@WebAppConfiguration
//@IntegrationTest("server.port:0")
@IntegrationTest()
@DirtiesContext
public class WebTest {

    @Value("8080")
    private int port;

    @Test
    public void testJspWithEl() throws Exception {
        ResponseEntity<String> entity = new TestRestTemplate().getForEntity(
                "http://localhost:" + port, String.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
//        assertTrue("Wrong body:\n" + entity.getBody(),
//                entity.getBody().contains("/resources/text.txt"));
    }

}
