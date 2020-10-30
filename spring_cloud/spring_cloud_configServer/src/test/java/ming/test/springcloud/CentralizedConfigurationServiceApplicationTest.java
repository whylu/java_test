package ming.test.springcloud;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
                classes = CentralizedConfigurationServiceApplication.class)
public class CentralizedConfigurationServiceApplicationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() throws Exception {
        ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:8888/a-bootiful-client/prod", String.class);
        String body = entity.getBody();

        System.out.println(body);
        assertThat(body).contains("XXX_prod");
        assertThat(body).contains("YYY_prod");
    }

}