package com.yuliiaskrypnyk.java.springrickmortyapi;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class CharacterService {
    private RestClient restClient = RestClient.builder()
            .baseUrl("https://rickandmortyapi.com/api")
            .build();

    public List<Character> findAllCharacters() {
        CharacterResponse body = restClient.get()
                .uri("/character")
                .retrieve()
                .body(CharacterResponse.class);

        return body.results();
    }
}
