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
        CharacterResponse response = restClient.get()
                .uri("/character")
                .retrieve()
                .body(CharacterResponse.class);

        return response.results();
    }

    public List<Character> findCharactersByStatus(String status) {
        CharacterResponse response = restClient.get()
                .uri("/character?status=" + status)
                .retrieve()
                .body(CharacterResponse.class);

        return response.results();
    }

    public Character findCharacterById(String id) {
        return restClient.get()
                .uri("/character/" + id)
                .retrieve()
                .body(Character.class);
    }

    public int getLivingSpeciesCount(String species) {
        CharacterResponse response = restClient.get()
                .uri("/character/?species=" + species)
                .retrieve()
                .body(CharacterResponse.class);

        return response.info().count();
    }
}
