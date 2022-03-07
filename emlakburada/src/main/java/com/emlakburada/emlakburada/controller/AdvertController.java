package com.emlakburada.emlakburada.controller;

import com.emlakburada.emlakburada.dto.request.AdvertRequest;
import com.emlakburada.emlakburada.service.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdvertController {
    private final AdvertService advertService;

    @Autowired
    public AdvertController(AdvertService advertService) {
        this.advertService = advertService;
    }

    @PostMapping(value = "/adverts")
    public ResponseEntity<?> addAdvert(@RequestBody AdvertRequest advertRequest) {
        return ResponseEntity.ok(advertService.add(advertRequest));
    }

    @GetMapping(value = "/adverts")
    public ResponseEntity<?> getAllAdverts() {
        return ResponseEntity.ok(advertService.getAll());
    }

    @PutMapping(value = "/adverts")
    public ResponseEntity<?> updateAdvert(@RequestBody AdvertRequest advertRequest) {
        return ResponseEntity.ok(advertService.update(advertRequest));
    }

    @DeleteMapping(value = "/adverts")
    public ResponseEntity<?> deleteAdvert(@RequestBody AdvertRequest advertRequest) {
        return ResponseEntity.ok(advertService.delete(advertRequest));
    }
}