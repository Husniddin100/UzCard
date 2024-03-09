package com.example.UzCard.controller;

import com.example.UzCard.dto.ClientDTO;
import com.example.UzCard.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/create")
    public ResponseEntity<ClientDTO> create(@RequestBody ClientDTO dto) {
        return ResponseEntity.ok(clientService.create(dto));
    }

    @PreAuthorize("hasRole('BANK')")
    @PostMapping("/update/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable String id, @RequestBody ClientDTO dto) {
        return ResponseEntity.ok(clientService.update(id, dto));
    }
    //filter pagination {}

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getById/{id}")
    public ResponseEntity<ClientDTO> getById(@PathVariable String id) {
        return ResponseEntity.ok(clientService.getById(id));
    }
    //get by profile id (bank only own users)
}
