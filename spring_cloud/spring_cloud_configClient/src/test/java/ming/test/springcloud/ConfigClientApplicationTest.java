package ming.test.springcloud;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        classes = ConfigClientApplication.class)
class ConfigClientApplicationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void main() {
        ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:8801/hello", String.class);
        String body = entity.getBody();
        System.out.println(body);
    }
}