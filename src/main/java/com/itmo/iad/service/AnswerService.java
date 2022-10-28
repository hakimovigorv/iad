package com.itmo.iad.service;

import com.itmo.iad.model.Answer;
import com.itmo.iad.model.Task;
import com.itmo.iad.repository.AnswerRepository;
import com.itmo.iad.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    public void save(Answer answer) {
        answerRepository.save(answer);
    }

}
