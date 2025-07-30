package com.dj.spring.boot.ollama.local.controller;

import com.dj.spring.boot.ollama.local.service.Answer;
import com.dj.spring.boot.ollama.local.service.AnsweringServiceImpl;
import com.dj.spring.boot.ollama.local.service.Question;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class AnswerController {
    private final AnsweringServiceImpl answeringService;
    
    private static final Logger logger = Logger.getLogger(AnswerController.class.getName());

    public AnswerController(AnsweringServiceImpl answeringService) {
        this.answeringService = answeringService;
    }

    @PostMapping(path="/ask", produces="application/json")
    public Answer ask(@RequestBody Question question) {
    logger.log(Level.INFO,String.format("Received question : %s",question.question()));
        return answeringService.askQuestion(question); // #2
    }
}
