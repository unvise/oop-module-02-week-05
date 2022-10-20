package com.unvise.oop.task3.a;

import java.util.*;

import static com.unvise.oop.task1.util.ListUtils.getNumsFromString;

public class UniqueSequenceApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<Integer> nums = getNumsFromString(scanner.nextLine(), ",", Map.of());
            Set<Integer> uniqueNums = new HashSet<>(nums);
            System.out.println("Изначальный массив: " + nums);
            System.out.println("Получившийся массив: " + uniqueNums);
        } catch (NumberFormatException e) {
            System.out.println("Входная строка не соответствует шаблону");
            System.exit(1);
        }
    }
}
