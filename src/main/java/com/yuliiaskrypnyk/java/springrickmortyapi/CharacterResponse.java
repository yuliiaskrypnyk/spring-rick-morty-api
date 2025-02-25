package com.yuliiaskrypnyk.java.springrickmortyapi;

import java.util.List;

public record CharacterResponse(
        Info info,
        List<Character> results
) {
}
