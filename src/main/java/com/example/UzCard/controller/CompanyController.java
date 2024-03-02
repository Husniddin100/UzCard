package com.example.UzCard.controller;

import com.example.UzCard.dto.CompanyDTO;
import com.example.UzCard.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    public ResponseEntity<CompanyDTO>createCompany(@RequestBody CompanyDTO dto){
        return ResponseEntity.ok(companyService.create(dto));
    }
}