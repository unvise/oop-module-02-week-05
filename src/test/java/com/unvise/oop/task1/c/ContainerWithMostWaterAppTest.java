package com.unvise.oop.task1.c;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.unvise.oop.task1.c.ContainerWithMostWaterApp.find;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ContainerWithMostWaterAppTest {

    @Test
    void findTest() {
        // given
        List<Integer> nums1 = List.of(1, 8, 6, 2, 5, 4, 8, 3, 7);
        List<Integer> nums2 = List.of(1, 1);
        List<Integer> nums3 = List.of(4, 3, 2, 1, 4);
        List<Integer> nums4 = List.of(1, 2, 1);
        // then
        assertAll(
                () -> assertEquals(49, find(nums1)),
                () -> assertEquals(1, find(nums2)),
                () -> assertEquals(16, find(nums3)),
                () -> assertEquals(2, find(nums4))
        );
    }
}