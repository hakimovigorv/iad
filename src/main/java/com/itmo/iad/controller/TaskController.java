package com.itmo.iad.controller;

import com.itmo.iad.exeption.AuthException;
import com.itmo.iad.model.Answer;
import com.itmo.iad.model.Task;
import com.itmo.iad.payload.JwtAuthentication;
import com.itmo.iad.payload.request.AnswerRequest;
import com.itmo.iad.payload.response.MessageResponse;
import com.itmo.iad.service.AnswerService;
import com.itmo.iad.service.AuthService;
import com.itmo.iad.service.TaskService;
import com.itmo.iad.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/task")
@RequiredArgsConstructor
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private AnswerService answerService;
    @Autowired
    private UserService userService;
    @Autowired
    private AuthService authService;

    //@PreAuthorize("hasAuthority('USER')")
    @GetMapping("all")
    public List<Task> getTasks() {
        return taskService.findAll().stream()
                .collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("answer")
    public ResponseEntity<?> login(@RequestBody AnswerRequest answerRequest) {
        final JwtAuthentication authInfo = authService.getAuthInfo();

        answerService.save(Answer.builder()
                        .userId(userService.getByLogin(answerRequest.getUser()).get().getId())
                        .value(answerRequest.getValue())
                .build());
        return ResponseEntity.ok(new MessageResponse("Answer accepted"));
    }
}
