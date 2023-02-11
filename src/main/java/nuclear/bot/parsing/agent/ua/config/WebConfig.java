package nuclear.bot.parsing.agent.ua.config;

import nuclear.bot.parsing.agent.ua.service.DeviceAgentMessageMapper;
import nuclear.bot.parsing.agent.ua.service.DeviceAgentMessageMapperImpl;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class WebConfig {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public DeviceAgentMessageMapper deviceAgentMessageMapper() {
        return new DeviceAgentMessageMapperImpl();
    }
}
