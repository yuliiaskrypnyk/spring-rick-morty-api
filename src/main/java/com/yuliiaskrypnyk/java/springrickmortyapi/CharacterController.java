package com.yuliiaskrypnyk.java.springrickmortyapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public List<Character> getAllCharacters() {
        return characterService.findAllCharacters();
    }

    @GetMapping("/{id}")
    public Character getCharacterById (@PathVariable String id) {
        return characterService.findCharacterById(id);
    }

    @GetMapping("/status")
    public List<Character> getCharactersByStatus(@RequestParam String status) {
        return characterService.findCharactersByStatus(status);
    }

    @GetMapping("/species-statistic")
    public int getLivingSpeciesCount(@RequestParam String species) {
        return characterService.getLivingSpeciesCount(species);
    }
}
