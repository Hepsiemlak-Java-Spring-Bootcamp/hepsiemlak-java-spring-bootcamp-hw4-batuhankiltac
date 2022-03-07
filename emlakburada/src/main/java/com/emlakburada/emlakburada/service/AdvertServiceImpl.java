package com.emlakburada.emlakburada.service;

import com.emlakburada.emlakburada.queue.QueueService;
import com.emlakburada.emlakburada.client.BannerClient;
import com.emlakburada.emlakburada.client.request.BannerRequest;
import com.emlakburada.emlakburada.core.DataResult;
import com.emlakburada.emlakburada.core.Result;
import com.emlakburada.emlakburada.core.SuccessDataResult;
import com.emlakburada.emlakburada.core.SuccessResult;
import com.emlakburada.emlakburada.dto.request.AdvertRequest;
import com.emlakburada.emlakburada.model.Advert;
import com.emlakburada.emlakburada.model.User;
import com.emlakburada.emlakburada.repository.AdvertRepository;
import com.emlakburada.emlakburada.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdvertServiceImpl implements AdvertService {
    private final AdvertRepository advertRepository;
    private final UserRepository userRepository;
    private final BannerClient bannerClient;
    private final QueueService queueService;

    public AdvertServiceImpl(AdvertRepository advertRepository, UserRepository userRepository, BannerClient bannerClient, QueueService queueService) {
        this.advertRepository = advertRepository;
        this.userRepository = userRepository;
        this.bannerClient = bannerClient;
        this.queueService = queueService;
    }

    private static final BannerRequest bannerRequest = new BannerRequest();

    @Override
    public DataResult<List<Advert>> getAll() {
        return new SuccessDataResult<>("Listed all adverts.", advertRepository.findAll());
    }

    @Override
    public Result add(AdvertRequest advertRequest) {
        AdvertBaseService advertBaseService = new AdvertBaseService();
        Optional<User> found = userRepository.findById(advertRequest.getUserId());
        Advert advert = advertBaseService.convertToAdvert(advertRequest, found);
        String email = "batuhan@gmail.com" + advertRequest.getUserId();
        queueService.sendMessage(email);
        bannerClient.saveBanner(bannerRequest);
        advertRepository.save(advert);
        return new SuccessResult("Advert has been added to Database.");
    }

    @Override
    public Result update(AdvertRequest advertRequest) {
        Advert advert = new Advert();
        advert.setId(advertRequest.getId());
        advert.setAdvertNo(advertRequest.getAdvertNo());
        advert.setTitle(advertRequest.getTitle());
        advert.setPrice(advertRequest.getPrice());
        advert.setDuration(advertRequest.getDuration());
        advertRepository.save(advert);
        return new SuccessResult("Advert has been updated.");
    }

    @Override
    public Result delete(AdvertRequest advertRequest) {
        Advert advert = new Advert();
        advert.setId(advertRequest.getId());
        advertRepository.delete(advert);
        return new SuccessResult("Advert has been deleted.");
    }
}