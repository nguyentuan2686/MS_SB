package com.example.profileservice.service;

import com.example.profileservice.model.ProfileDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProfileService {
    Flux<ProfileDTO> getAllProfile();
    Mono<ProfileDTO> createNewProfile(ProfileDTO profileDTO);
}
