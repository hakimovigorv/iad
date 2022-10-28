package com.itmo.iad.payload.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AnswerRequest {
    String value;
    private String user;
}
