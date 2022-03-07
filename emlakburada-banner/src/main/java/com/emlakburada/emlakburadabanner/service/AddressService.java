package com.emlakburada.emlakburadabanner.service;

import com.emlakburada.emlakburadabanner.core.DataResult;
import com.emlakburada.emlakburadabanner.core.Result;
import com.emlakburada.emlakburadabanner.dto.request.AddressRequest;
import com.emlakburada.emlakburadabanner.model.Address;

import java.util.List;

public interface AddressService {
    DataResult<List<Address>> getAll();
    Result add(AddressRequest addressRequest);
    Result update(AddressRequest addressRequest);
    Result delete(AddressRequest addressRequest);
}