package com.example.UzCard.controller;

import com.example.UzCard.dto.ProfileDTO;
import com.example.UzCard.enums.ProfileStatus;
import com.example.UzCard.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<ProfileDTO> create(@RequestBody ProfileDTO dto) {
        return ResponseEntity.ok(profileService.create(dto));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/update/{id}")
    public ResponseEntity<ProfileDTO> update(@PathVariable String id, @RequestBody ProfileDTO dto) {
        return ResponseEntity.ok(profileService.update(id, dto));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/change_status/{id}/{status}")
    public ResponseEntity<Boolean> changeStatus(@PathVariable String id, @PathVariable ProfileStatus status) {
        return ResponseEntity.ok(profileService.changeStatus(id, status));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/pagination")
    public ResponseEntity<PageImpl> pagination(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                               @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return ResponseEntity.ok(profileService.pagination(page, size));
    }
}
