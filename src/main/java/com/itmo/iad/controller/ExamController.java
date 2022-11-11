package com.itmo.iad.controller;

import com.itmo.iad.model.Answer;
import com.itmo.iad.model.Task;
import com.itmo.iad.model.exam.ExamTask;
import com.itmo.iad.payload.JwtAuthentication;
import com.itmo.iad.payload.request.AnswerRequest;
import com.itmo.iad.payload.request.ExamAnswerRequest;
import com.itmo.iad.payload.request.TaskAnswerPair;
import com.itmo.iad.payload.response.MessageResponse;
import com.itmo.iad.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/exam")
@RequiredArgsConstructor
public class ExamController {
    @Autowired
    private ExamService examService;
    @Autowired
    private UserService userService;
    @Autowired
    private AuthService authService;

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("all")
    public List<ExamTask> getTasks() {
        return examService.findAll().stream()
                .collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("answer")
    public boolean acceptAnswer(@RequestBody ExamAnswerRequest examAnswerRequest) {
        final JwtAuthentication authInfo = authService.getAuthInfo();

        if(examService.acceptAnswer(examAnswerRequest.getAnswers().stream()
                        .collect(Collectors.toMap(TaskAnswerPair::getTaskId, TaskAnswerPair::getAnswer))))
        {
            userService.setCertified(examAnswerRequest.getUser());
            return true;
        }
        return false;
    }
}
