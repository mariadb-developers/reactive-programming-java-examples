package com.example;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class WordService {

    private final WordRepository wordRepository;

    @RequestMapping("/words")
    public List<Word> findWords(@RequestParam int limit) {
        return wordRepository.findWords(limit).stream()
                .map(this::fillData)
                .collect(Collectors.toList());
    }

    private Word fillData(Word word) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encoded = encoder.encode(word.getText());
        word.setData(encoded);
        return word;
    }

}
