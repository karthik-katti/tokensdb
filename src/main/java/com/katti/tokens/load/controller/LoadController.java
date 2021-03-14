package com.katti.tokens.load.controller;

import com.katti.tokens.load.dto.LoadDto;
import com.katti.tokens.load.dto.LoadResponseDto;
import com.katti.tokens.load.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoadController {

    @Autowired
    TokenService tokenService;

    @PostMapping("/tokens/v1/load")
    public ResponseEntity<LoadResponseDto> loadTokens(@RequestBody LoadDto loadDto){
        LoadResponseDto loadResponseDto = tokenService.loadTokens(loadDto);
        return new ResponseEntity<>(loadResponseDto, HttpStatus.OK);
    }
}
