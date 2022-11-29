package com.grupp2.webservices.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserErrorResponse {

    private int status;
    private String message;
    private long timeStamp;

}
