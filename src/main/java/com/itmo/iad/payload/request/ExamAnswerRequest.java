package com.itmo.iad.payload.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class ExamAnswerRequest {
    private String user;

    private Set<TaskAnswerPair> answers;
}
