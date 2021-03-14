package com.katti.tokens.load.service;

import com.katti.tokens.load.dto.LoadDto;
import com.katti.tokens.load.dto.LoadResponseDto;
import com.katti.tokens.load.entity.Token;
import com.katti.tokens.load.repository.TokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TokenService {

    @Autowired
    TokenRepo tokenRepo;

    public LoadResponseDto loadTokens(LoadDto loadDto) {
        Set<String> tokens = generateTokens(loadDto);
        System.out.println("Tokens : " + tokens);
        List<Token> tokenList = prepareEntityList(loadDto,tokens);
        tokenRepo.saveAll(tokenList);
        LoadResponseDto loadResponseDto = new LoadResponseDto();
        loadResponseDto.setStatus("PASS");
        loadResponseDto.setMessage("Tokens Generated");
        return loadResponseDto;
    }

    private List<Token> prepareEntityList(LoadDto loadDto, Set<String> tokens) {
        List<Token> list = new ArrayList<>();
        for (String tokentx : tokens){
            Token token = new Token();
            token.setTokenFormat("PAN");
            token.setToken(tokentx);
            token.setAppDomain("TEST");
            list.add(token);
        }
        return list;
    }

    private Set<String> generateTokens(LoadDto loadDto) {

        SecureRandom secureRandom = new SecureRandom();
        long randomNumberOrigin = (long) (Math.pow(10, 15 - 1) * 1);
        long randomNumberBound = (long) (Math.pow(10, 15) * 1) - 1;
        Set<String> tokenset = new HashSet<>();
        for (int i = 0; i < loadDto.getTokenQueueSize(); i++) {
            String token = secureRandom.longs(1, randomNumberOrigin, randomNumberBound).boxed().map(String::valueOf)
                    .collect(Collectors.toList()).get(0);
            if (token.length() == 15) {
                tokenset.add(token);
            }
        }
        return tokenset;
    }
}
