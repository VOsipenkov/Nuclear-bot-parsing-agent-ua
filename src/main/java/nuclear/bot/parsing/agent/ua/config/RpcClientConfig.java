package nuclear.bot.parsing.agent.ua.config;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.net.URL;

@Configuration
public class RpcClientConfig {

    @Value("${parsingprocessor.url}")
    private String url;

    @Bean
    public JsonRpcHttpClient jsonRpcHttpClient() throws MalformedURLException {
        return new JsonRpcHttpClient(new URL(url));
    }
}
