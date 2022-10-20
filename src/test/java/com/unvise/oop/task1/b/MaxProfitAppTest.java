package com.unvise.oop.task1.b;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.unvise.oop.task1.b.MaxProfitApp.maxProfit;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxProfitAppTest {

    @Test
    void maxProfitTest() {
        // given
        List<Integer> nums1 = List.of(7, 1, 5, 3, 6, 4);
        List<Integer> nums2 = List.of(7, 6, 4, 3, 1);
        // then
        assertAll(
                () -> assertEquals(5, maxProfit(nums1)),
                () -> assertEquals(0, maxProfit(nums2))
        );
    }
}