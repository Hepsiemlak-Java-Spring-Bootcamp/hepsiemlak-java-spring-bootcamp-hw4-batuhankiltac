package com.emlakburada.emlakburadabanner.service;

import com.emlakburada.emlakburadabanner.core.DataResult;
import com.emlakburada.emlakburadabanner.core.Result;
import com.emlakburada.emlakburadabanner.core.SuccessDataResult;
import com.emlakburada.emlakburadabanner.core.SuccessResult;
import com.emlakburada.emlakburadabanner.dto.request.AddressRequest;
import com.emlakburada.emlakburadabanner.model.Address;
import com.emlakburada.emlakburadabanner.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public DataResult<List<Address>> getAll() {
        return new SuccessDataResult<>("Listed all addresses.", addressRepository.findAll());
    }

    @Override
    public Result add(AddressRequest addressRequest) {
        AddressBaseService addressBaseService = new AddressBaseService();
        Address address = addressBaseService.convertToUserAddress(addressRequest);
        addressRepository.save(address);
        return new SuccessResult("Address has been added to Database.");
    }

    @Override
    public Result update(AddressRequest addressRequest) {
        Address address = new Address();
        address.setId(addressRequest.getId());
        address.setProvince(addressRequest.getProvince());
        address.setDistrict(addressRequest.getDistrict());
        address.setDetails(addressRequest.getDetails());
        addressRepository.save(address);
        return new SuccessResult("Address has been updated.");
    }

    @Override
    public Result delete(AddressRequest addressRequest) {
        Address address = new Address();
        address.setId(addressRequest.getId());
        addressRepository.delete(address);
        return new SuccessResult("Address has been deleted.");
    }
}