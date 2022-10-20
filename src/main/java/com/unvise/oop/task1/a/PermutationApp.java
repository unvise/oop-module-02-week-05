package com.unvise.oop.task1.a;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.unvise.oop.task1.util.ListUtils.getNumsFromString;

public class PermutationApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String rawLine = scanner.nextLine();
            List<Integer> nums = getNumsFromString(rawLine, ", ", Map.of("[", "", "]", ""));
            System.out.println(perms(nums));
        } catch (NumberFormatException e) {
            System.out.println("Неправильный формат ввода");
        }
    }

    public static List<List<Integer>> perms(List<Integer> nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.size() == 0) {
            return results;
        }
        List<Integer> result = new ArrayList<>();
        deepFirstSearch(nums, results, result);
        return results;
    }

    private static void deepFirstSearch(List<Integer> nums, List<List<Integer>> results, List<Integer> result) {
        if (nums.size() == result.size()) {
            List<Integer> temp = new ArrayList<>(result);
            results.add(temp);
        }
        for (int i = 0; i < nums.size(); i++) {
            if (!result.contains(nums.get(i))) {
                result.add(nums.get(i));
                deepFirstSearch(nums, results, result);
                result.remove(result.size() - 1);
            }
        }
    }
}
