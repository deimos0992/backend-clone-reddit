package com.reddclone.demo.controller;

import com.reddclone.demo.dto.RegistrerRequest;
import com.reddclone.demo.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody RegistrerRequest registrerRequest){
        authService.signup(registrerRequest);
        return new ResponseEntity<>("User Registration Sucessful", HttpStatus.OK);
    }
}
