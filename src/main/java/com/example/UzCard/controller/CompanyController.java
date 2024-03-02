package com.example.UzCard.controller;

import com.example.UzCard.dto.CompanyDTO;
import com.example.UzCard.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<CompanyDTO> createCompany(@RequestBody CompanyDTO dto) {
        return ResponseEntity.ok(companyService.create(dto));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/update/{id}")
    public ResponseEntity<CompanyDTO> update(@PathVariable String id, @RequestBody CompanyDTO dto) {
        return ResponseEntity.ok(companyService.update(id, dto));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/delete/{id}")
   public ResponseEntity<Boolean>delete(@PathVariable String id){
        return ResponseEntity.ok(companyService.delete(id));
    }

}