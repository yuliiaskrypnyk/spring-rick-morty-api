package com.yuliiaskrypnyk.java.springrickmortyapi;

import java.util.List;

public record CharacterResponse(
        List<Character> results
) {
}
