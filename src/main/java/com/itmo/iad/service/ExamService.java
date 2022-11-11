package com.itmo.iad.service;

import com.itmo.iad.model.Task;
import com.itmo.iad.model.exam.ExamTask;
import com.itmo.iad.repository.ExamTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExamService {
    @Autowired
    private ExamTaskRepository examTaskRepository;

    public List<ExamTask> findAll() {
        return examTaskRepository.findAll();
    }

    public boolean acceptAnswer(Map<Long,Integer> answers){
        List<ExamTask> examTasks = examTaskRepository.findAll();
        Map<Long,Integer> rightAnswers = examTasks.stream().collect(Collectors.toMap(ExamTask::getId, ExamTask::getAnswer));

        Integer score = 0;
        for(Map.Entry<Long, Integer> entry : answers.entrySet())
        {
            if(rightAnswers.get(entry.getKey()).equals(entry.getValue()))
                score++;
        }

        return !((double) score / (double) rightAnswers.size() < 0.8);
    }
}
