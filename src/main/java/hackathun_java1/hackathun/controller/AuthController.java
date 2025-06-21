package hackathun_java1.hackathun.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        return "Token JWT ou sessão iniciada";
    }

    public static class LoginRequest {
        public String username;
        public String password;
    }
}