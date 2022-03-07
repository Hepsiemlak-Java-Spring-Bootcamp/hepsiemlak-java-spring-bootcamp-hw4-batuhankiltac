package com.emlakburada.emlakburadabanner.service;

import com.emlakburada.emlakburadabanner.core.DataResult;
import com.emlakburada.emlakburadabanner.core.Result;
import com.emlakburada.emlakburadabanner.dto.request.BannerRequest;
import com.emlakburada.emlakburadabanner.model.Banner;

import java.util.List;

public interface BannerService {
    DataResult<List<Banner>> getAll();
    Result add(BannerRequest bannerRequest);
    Result update(BannerRequest bannerRequest);
    Result delete(BannerRequest bannerRequest);
}