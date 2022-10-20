package com.unvise.oop.task2.b;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CustomerHistoryTest {

    @Test
    void saveTest() {
        // given
        CustomerHistory customerHistory = new CustomerHistory();
        var exp1 = Map.of(
                "workbook", 2,
                "pens", 1
        );
        var exp2 = Map.of(
                "workbook", 3,
                "pens", 5,
                "envelope", 2
        );
        // when
        customerHistory.save("Ivanov", "workbook", 2);
        customerHistory.save("Ivanov", "pens", 1);
        customerHistory.save("Petrov", "workbook", 3);
        customerHistory.save("Petrov", "pens", 5);
        customerHistory.save("Petrov", "envelope", 2);
        // then
        assertAll(
                () -> assertEquals(exp1, customerHistory.getHistory().get("Ivanov")),
                () -> assertEquals(exp2, customerHistory.getHistory().get("Petrov"))
        );
    }
}