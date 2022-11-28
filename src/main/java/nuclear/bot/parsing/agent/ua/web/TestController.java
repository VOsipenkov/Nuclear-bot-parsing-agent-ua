package nuclear.bot.parsing.agent.ua.web;

import lombok.RequiredArgsConstructor;
import nuclear.bot.parsing.agent.ua.service.SiteParserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final SiteParserService siteParserService;

    @GetMapping(value = "/send/{id}")
    public ResponseEntity<String> sendMessage(@PathVariable(name = "id") String id) {
        siteParserService.parseSite();
        return ResponseEntity.ok("ok");
    }
}
