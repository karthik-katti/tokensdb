package com.katti.tokens.load.dto;

import lombok.Data;

@Data
public class LoadDto {

    private String appDomain;
    private int tokenQueueSize;
    private String tokenFormat;
}
