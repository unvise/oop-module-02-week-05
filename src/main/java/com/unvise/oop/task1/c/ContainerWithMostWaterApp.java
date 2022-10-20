package com.unvise.oop.task1.c;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static com.unvise.oop.task1.util.ListUtils.getNumsFromString;

public class ContainerWithMostWaterApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String rawLine = scanner.nextLine();
            List<Integer> nums = getNumsFromString(rawLine, ",", Collections.emptyMap());
            System.out.println(find(nums));
        } catch (NumberFormatException e) {
            System.out.println("Неправильный формат ввода");
        }
    }

    public static Integer find(List<Integer> nums) {
        if (nums.size() < 2) {
            return 0;
        }
        int max = 0, left = 0, right = nums.size() - 1;
        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(nums.get(left), nums.get(right)));
            if (nums.get(left) < nums.get(right)) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
