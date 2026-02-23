package com.uneg.galeria.controllers;

import com.uneg.galeria.models.SecurityQuestion;
import com.uneg.galeria.models.UserAnswers;
import com.uneg.galeria.repositories.SecurityQuestionRepository;
import com.uneg.galeria.repositories.UserAnswersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/security")
@CrossOrigin(origins = "http://localhost:3000")
public class SecurityController {

    @Autowired private SecurityQuestionRepository questionRepository;
    @Autowired private UserAnswersRepository answersRepository;

    // Obtener las preguntas para el formulario de registro
    @GetMapping("/questions")
    public List<SecurityQuestion> getAllQuestions() {
        return questionRepository.findAll();
    }

    // Guardar las respuestas del usuario (se llama justo después del registro)
    @PostMapping("/answers")
    public void saveAnswers(@RequestBody List<UserAnswers> answers) {
        answersRepository.saveAll(answers);
    }
}