package com.emlakburada.emlakburadabanner.controller;

import com.emlakburada.emlakburadabanner.dto.request.BannerRequest;
import com.emlakburada.emlakburadabanner.service.BannerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BannerController {
    private final BannerService bannerService;

    public BannerController(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    @PostMapping(value = "/banners")
    public ResponseEntity<?> addBanner(@RequestBody BannerRequest bannerRequest) {
        return ResponseEntity.ok(bannerService.add(bannerRequest));
    }

    @GetMapping(value = "/banners")
    public ResponseEntity<?> getAllBanners() {
        return ResponseEntity.ok(bannerService.getAll());
    }

    @PutMapping(value = "/banners")
    public ResponseEntity<?> updateBanner(@RequestBody BannerRequest bannerRequest) {
        return ResponseEntity.ok(bannerService.update(bannerRequest));
    }

    @DeleteMapping(value = "/banners")
    public ResponseEntity<?> deleteAdvert(@RequestBody BannerRequest bannerRequest) {
        return ResponseEntity.ok(bannerService.delete(bannerRequest));
    }
}