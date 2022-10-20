package com.unvise.oop.task2.a;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LatinEnglishDictionaryTest {

    @Test
    void saveTranslationTest() {
        // given
        LatinEnglishDictionary latinEnglishDictionary = new LatinEnglishDictionary();
        // when
        latinEnglishDictionary.saveTranslation(Collections.singletonList("malum"), "apple");
        latinEnglishDictionary.saveTranslation(Collections.singletonList("malum"), "punishment");
        latinEnglishDictionary.saveTranslation(Collections.singletonList("schola"), "school");
        // then
        assertAll(
                () -> assertEquals(List.of("apple", "punishment"), latinEnglishDictionary.getLatinDictionary().get("malum")),
                () -> assertEquals(List.of("school"), latinEnglishDictionary.getLatinDictionary().get("schola"))
        );
    }
}