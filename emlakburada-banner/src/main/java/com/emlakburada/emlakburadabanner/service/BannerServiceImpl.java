package com.emlakburada.emlakburadabanner.service;

import com.emlakburada.emlakburadabanner.core.DataResult;
import com.emlakburada.emlakburadabanner.core.Result;
import com.emlakburada.emlakburadabanner.core.SuccessDataResult;
import com.emlakburada.emlakburadabanner.core.SuccessResult;
import com.emlakburada.emlakburadabanner.dto.request.BannerRequest;
import com.emlakburada.emlakburadabanner.model.Address;
import com.emlakburada.emlakburadabanner.model.Banner;
import com.emlakburada.emlakburadabanner.repository.AddressRepository;
import com.emlakburada.emlakburadabanner.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BannerServiceImpl implements BannerService {
    private final BannerRepository bannerRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public BannerServiceImpl(BannerRepository bannerRepository, AddressRepository addressRepository) {
        this.bannerRepository = bannerRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public DataResult<List<Banner>> getAll() {
        return new SuccessDataResult<>("Listed all banners.", bannerRepository.findAll());
    }

    @Override
    public Result add(BannerRequest bannerRequest) {
        BannerBaseService bannerBaseService = new BannerBaseService();
        Optional<Address> found = addressRepository.findById(bannerRequest.getId());
        Banner banner = bannerBaseService.convertToBanner(bannerRequest, found);
        bannerRepository.save(banner);
        return new SuccessResult("Banner has been added to Database.");
    }

    @Override
    public Result update(BannerRequest bannerRequest) {
        Banner banner = new Banner();
        banner.setId(bannerRequest.getId());
        banner.setAdvertNo(bannerRequest.getAdvertNo());
        banner.setPhone(bannerRequest.getPhone());
        banner.setQuantity(bannerRequest.getQuantity());
        bannerRepository.save(banner);
        return new SuccessResult("Banner has been updated.");
    }

    @Override
    public Result delete(BannerRequest bannerRequest) {
        Banner banner = new Banner();
        banner.setId(bannerRequest.getId());
        bannerRepository.delete(banner);
        return new SuccessResult("Banner has been deleted.");
    }
}