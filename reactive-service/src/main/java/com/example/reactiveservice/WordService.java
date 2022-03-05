package com.example.reactiveservice;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class WordService {

    private final WordRepository wordRepository;

    @RequestMapping(value = "/words", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Word> findWords(@RequestParam int limit) {
        return wordRepository.findWords(limit)
                .map(this::fillData);
    }

    private Word fillData(Word word) {
        String encoded = new BCryptPasswordEncoder().encode(word.getText());
        word.setComputedData(encoded);
        return word;
    }

}
