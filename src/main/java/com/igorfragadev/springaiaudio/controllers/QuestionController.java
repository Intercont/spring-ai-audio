package com.igorfragadev.springaiaudio.controllers;

import com.igorfragadev.springaiaudio.model.Question;
import com.igorfragadev.springaiaudio.services.OpenAIService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class QuestionController {

    private final OpenAIService openAIService;

    @PostMapping(value = "/audio", produces = "audio/mpeg")
    public byte[] getAudioSpeech(@RequestBody Question question) {
        return openAIService.getAudioSpeech(question);
    }



}
