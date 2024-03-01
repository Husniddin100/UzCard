package com.example.UzCard.controller;

import com.example.UzCard.dto.AuthDTO;
import com.example.UzCard.dto.ProfileDTO;
import com.example.UzCard.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/login")
    public ResponseEntity<ProfileDTO> login(@RequestBody AuthDTO dto){
        return ResponseEntity.ok(authService.login(dto));
    }
}
