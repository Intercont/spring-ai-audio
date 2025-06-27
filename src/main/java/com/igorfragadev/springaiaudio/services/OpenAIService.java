package com.igorfragadev.springaiaudio.services;


import com.igorfragadev.springaiaudio.model.Question;

public interface OpenAIService {

    byte[] getAudioSpeech(Question question);
}
