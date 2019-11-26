package com.foodie.service.impl;

import com.foodie.model.UserMessage;
import com.foodie.repository.UserMessageRepository;
import com.foodie.service.UserMessageService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@Service
@RequiredArgsConstructor
public class UserMessageServiceImpl implements UserMessageService {
    private final UserMessageRepository userMessageRepository;

    @Override
    public UserMessage add(UserMessage userMessage) {
        return userMessageRepository.save(userMessage);
    }
}
