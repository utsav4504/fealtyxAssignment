package com.fealtyx.fealtyx.service;

import com.fealtyx.fealtyx.model.Student;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.Map;

@Service
public class OllamaService {
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String OLLAMA_URL = "http://localhost:11434/api/generate";

    public String getSummary(Student student) {
        String prompt = String.format("""
You are a helpful assistant that writes detailed, friendly summaries for student profiles.

Here is the student information:
- Name: %s
- Age: %d
- Email: %s

Write a brief paragraph that includes personality traits, academic qualities, and how the student might be seen by peers or professors.
""", student.getName(), student.getAge(), student.getEmail());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> body = Map.of(
                "model", "gemma:2b",
                "prompt", prompt,
                "stream", false
        );
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        try {
            Map response = restTemplate.postForObject(OLLAMA_URL, request, Map.class);
            return response != null ? response.get("response").toString() : "No response from Ollama";
        } catch (Exception e) {
            return "Ollama Error: " + e.getMessage();
        }
    }
}
