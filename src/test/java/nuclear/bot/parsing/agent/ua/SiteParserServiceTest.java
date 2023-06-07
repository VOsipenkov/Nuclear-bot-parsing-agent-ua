package nuclear.bot.parsing.agent.ua;

import nuclear.bot.parsing.agent.ua.service.SiteParserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SiteParserServiceTest {

    @Autowired
    private SiteParserService siteParserService;

    @MockBean
    private RestTemplate restTemplate;

    @Test
    void test() {
        when(restTemplate.getForObject(any(), any(), any(Object[].class)))
                .thenReturn("hello");

        siteParserService.parseSite();

        System.out.println("ok");
    }
}
