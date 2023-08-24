package com.example.profileservice.service.impl;

import com.example.profileservice.model.ProfileDTO;
import com.example.profileservice.service.ProfileService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Override
    public Flux<ProfileDTO> getAllProfile() {
        return null;
    }

    @Override
    public Mono<ProfileDTO> createNewProfile(ProfileDTO profileDTO) {
        return null;
    }
}
