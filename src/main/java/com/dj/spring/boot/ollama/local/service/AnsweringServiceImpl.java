package com.dj.spring.boot.ollama.local.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.stereotype.Service;

@Service
public class AnsweringServiceImpl implements AnsweringService{
    private final ChatClient chatClient;

    public AnsweringServiceImpl(ChatClient.Builder chatClientBuilder) {
        ChatOptions chatOptions = ChatOptions.builder()
                .model("gemma3:latest")
                .build();
        this.chatClient = chatClientBuilder
                .defaultOptions(chatOptions)
                .build();

    }
    @Override
    public Answer askQuestion(Question question) {
        String answerText = chatClient.prompt()
                .user(question.question()) // #3
                .call()
                .content();
        return new Answer(answerText);
    }
}
