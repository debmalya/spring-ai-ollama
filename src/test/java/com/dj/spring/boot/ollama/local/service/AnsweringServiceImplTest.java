package com.dj.spring.boot.ollama.local.service;



import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.evaluation.FactCheckingEvaluator;
import org.springframework.ai.chat.evaluation.RelevancyEvaluator;
import org.springframework.ai.evaluation.EvaluationRequest;
import org.springframework.ai.evaluation.EvaluationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AnsweringServiceImplTest {

  @Autowired AnsweringServiceImpl answeringService;

  @Autowired private ChatClient.Builder chatClientBuilder;

  private RelevancyEvaluator relevancyEvaluator;
  private FactCheckingEvaluator factCheckingEvaluator;

  @BeforeEach
  public void setup() {
    this.relevancyEvaluator = new RelevancyEvaluator(chatClientBuilder);
    this.factCheckingEvaluator = new FactCheckingEvaluator(chatClientBuilder);
  }

  @Test
  void askQuestion() {
    String userText = "Why is the sky blue?";
    Question question = new Question(userText);
    Answer answer = answeringService.askQuestion(question);
    String referenceAnswer =
        "The sky is blue because of that was the paint color that was on sale.";
    EvaluationRequest evaluationRequest = new EvaluationRequest(userText, answer.answer());
    EvaluationResponse response = relevancyEvaluator.evaluate(evaluationRequest);
    Assertions.assertThat(response.isPass())
        .withFailMessage(
"""
========================================
The answer "%s"
is not considered relevant to the question
"%s".
========================================
""",
            answer.answer(), userText)
        .isTrue();
  }
}
