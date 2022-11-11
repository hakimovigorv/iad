package com.itmo.iad.payload.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TaskAnswerPair {
    Long taskId;
    Integer answer;
}
