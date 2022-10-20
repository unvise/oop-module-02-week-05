package com.unvise.oop.task3.c;

import org.junit.jupiter.api.Test;

import static com.unvise.oop.task3.c.ValidParenthesesApp.isValid;
import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesAppTest {

    @Test
    void isValidTest() {
        // given
        String exp1 = "{[]()()}";
        String exp2 = "{(){}})";
        String exp3 = "(){}{}[[]]";
        // then
        assertAll(
                () -> assertTrue(isValid(exp1)),
                () -> assertFalse(isValid(exp2)),
                () -> assertTrue(isValid(exp3))
        );
    }
}