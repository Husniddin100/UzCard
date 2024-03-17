package com.example.UzCard.controller;

import com.example.UzCard.dto.CardDTO;
import com.example.UzCard.enums.CardStatus;
import com.example.UzCard.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    private CardService cardService;

    @PostMapping("/create")
    public ResponseEntity<CardDTO> createCard(@RequestBody CardDTO dto) {
        return ResponseEntity.ok(cardService.createCard(dto));
    }

    @PutMapping("/change_status/{id}/{status}")
    public ResponseEntity<Boolean> changeStatus(@PathVariable String id, @PathVariable CardStatus status) {
        return ResponseEntity.ok(cardService.changeStatus(id, status));
    }

    @PutMapping("/assignPhone/{id}/{phone}")
    public ResponseEntity<Boolean> assignPhone(@PathVariable String id, @PathVariable String phone) {
        return ResponseEntity.ok(cardService.assignPhone(id, phone));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<CardDTO> getCardById(@PathVariable String id) {
        return ResponseEntity.ok(cardService.getCardById(id));
    }
   /* @GetMapping("/getCardListByClientId")
    public ResponseEntity<CardDTO>getCardListByClientId(){
    }*/
}
