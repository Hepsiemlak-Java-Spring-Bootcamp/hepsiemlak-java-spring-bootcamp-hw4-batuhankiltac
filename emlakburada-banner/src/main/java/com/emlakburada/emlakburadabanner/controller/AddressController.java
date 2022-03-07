package com.emlakburada.emlakburadabanner.controller;

import com.emlakburada.emlakburadabanner.dto.request.AddressRequest;
import com.emlakburada.emlakburadabanner.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping(value = "/addresses")
    public ResponseEntity<?> addAddress(@RequestBody AddressRequest addressRequest) {
        return ResponseEntity.ok(addressService.add(addressRequest));
    }

    @GetMapping(value = "/addresses")
    public ResponseEntity<?> getAllAddresses() {
        return ResponseEntity.ok(addressService.getAll());
    }

    @PutMapping(value = "/addresses")
    public ResponseEntity<?> updateAddress(@RequestBody AddressRequest addressRequest) {
        return ResponseEntity.ok(addressService.update(addressRequest));
    }

    @DeleteMapping(value = "/addresses")
    public ResponseEntity<?> deleteAddress(@RequestBody AddressRequest addressRequest) {
        return ResponseEntity.ok(addressService.delete(addressRequest));
    }
}