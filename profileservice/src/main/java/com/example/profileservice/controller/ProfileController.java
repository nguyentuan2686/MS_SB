package com.example.profileservice.controller;

import com.example.profileservice.model.ProfileDTO;
import com.example.profileservice.service.ProfileService;
import com.example.profileservice.utils.Constant;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.InputStream;

@RestController
@RequestMapping("/api/v1/profiles")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;
//    Gson gson = new Gson();
//    @GetMapping
//    public ResponseEntity<Flux<ProfileDTO>> getAllProfile(){
//        return ResponseEntity.ok(profileService.getAllProfile());
//    }
//    @GetMapping(value = "/checkDuplicate/{email}")
//    public ResponseEntity<Mono<Boolean>> checkDuplicate(@PathVariable String email){
//        return ResponseEntity.ok(profileService.checkDuplicate(email));
//    }
    @PostMapping
    public ResponseEntity<Mono<ProfileDTO>> createNewProfile(@RequestBody ProfileDTO profileDTO){

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(profileService.createNewProfile(profileDTO));
    }
}
