package com.dj.spring.boot.ollama.local.exception;

public class AnswerNotRelevantException extends RuntimeException{
    public AnswerNotRelevantException(String question, String answer) {
        super(String.format("The answer '%s' is not relevant to the question '%s'.",answer,question));
    }
}
