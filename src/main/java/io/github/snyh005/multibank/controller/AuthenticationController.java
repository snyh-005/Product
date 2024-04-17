package io.github.snyh005.multibank.controller;

import io.github.snyh005.multibank.model.UserAuthentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final UserAuthentication userAuthentication;

    public AuthenticationController(UserAuthentication userAuthentication) {
        this.userAuthentication = userAuthentication;
    }

    @PostMapping
    public String getToken(@RequestParam String username,
                           @RequestParam String password) throws Exception {
        return userAuthentication.getToken(username, password);
    }
}
