package spring.security.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MainController {

    @GetMapping("/user")
    public String userPage() {
        return "user page";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin page";
    }

}
