package com.igorfragadev.springaiaudio.services;

import com.igorfragadev.springaiaudio.model.Question;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.openai.OpenAiAudioSpeechModel;
import org.springframework.ai.openai.OpenAiAudioSpeechOptions;
import org.springframework.ai.openai.api.OpenAiAudioApi;
import org.springframework.ai.openai.audio.speech.SpeechPrompt;
import org.springframework.ai.openai.audio.speech.SpeechResponse;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OpenAIServiceImpl implements OpenAIService {

    private final OpenAiAudioSpeechModel speechModel;

    @Override
    public byte[] getAudioSpeech(Question question) {
        log.info("Generating audio speech for question: {}", question.question());

        OpenAiAudioSpeechOptions speechOptions = OpenAiAudioSpeechOptions.builder()
                .voice(OpenAiAudioApi.SpeechRequest.Voice.ALLOY)
                .speed(1.0f)
                .responseFormat(OpenAiAudioApi.SpeechRequest.AudioResponseFormat.MP3)
                .model(OpenAiAudioApi.TtsModel.TTS_1.value)
                .build();

        SpeechPrompt speechPrompt = new SpeechPrompt(question.question(), speechOptions);
        SpeechResponse speechResponse = speechModel.call(speechPrompt);

        var response = speechResponse.getResult().getOutput();
        log.info("Audio speech generated, size: {} bytes", response.length);

        return response;
    }
}