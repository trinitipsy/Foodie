package com.foodie.controller;

import com.foodie.constants.Cors;
import com.foodie.model.UserMessage;
import com.foodie.service.UserMessageService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/send-message")
@CrossOrigin(origins = Cors.origins)
public class UserMessageController {
    private final UserMessageService userMessageService;

    @PostMapping
    public ResponseEntity<UserMessage> add(@RequestBody final UserMessage userMessage) {
        return ResponseEntity.ok(userMessageService.add(userMessage));
    }
}
