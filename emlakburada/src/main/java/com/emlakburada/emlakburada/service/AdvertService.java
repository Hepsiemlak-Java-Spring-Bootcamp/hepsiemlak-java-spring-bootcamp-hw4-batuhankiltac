package com.emlakburada.emlakburada.service;

import com.emlakburada.emlakburada.core.DataResult;
import com.emlakburada.emlakburada.core.Result;
import com.emlakburada.emlakburada.dto.request.AdvertRequest;
import com.emlakburada.emlakburada.model.Advert;

import java.util.List;

public interface AdvertService {
    DataResult<List<Advert>> getAll();
    Result add(AdvertRequest advertRequest);
    Result update(AdvertRequest advertRequest);
    Result delete(AdvertRequest advertRequest);
}