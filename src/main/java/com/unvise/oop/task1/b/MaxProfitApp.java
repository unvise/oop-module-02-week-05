package com.unvise.oop.task1.b;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static com.unvise.oop.task1.util.ListUtils.getNumsFromString;

public class MaxProfitApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String rawLine = scanner.nextLine();
            List<Integer> nums = getNumsFromString(rawLine, ",", Collections.emptyMap());
            System.out.println(maxProfit(nums));
        } catch (NumberFormatException e) {
            System.out.println("Неправильный формат ввода");
        }
    }

    public static int maxProfit(List<Integer> nums) {
        int result = 0;
        Integer min = Collections.min(nums);
        int minIndex = nums.indexOf(min);
        List<Integer> subList = nums.subList(minIndex, nums.size() - 1);
        if (subList.size() > 0) {
            Integer max = Collections.max(subList);
            result = Math.max(max - min, 0);
        }
        return result;
    }
}
