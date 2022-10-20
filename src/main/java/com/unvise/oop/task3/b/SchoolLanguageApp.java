package com.unvise.oop.task3.b;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static com.unvise.oop.task3.util.MapEntryUtils.findMaxKeyEntry;
import static com.unvise.oop.task3.util.MapEntryUtils.findMinKeyEntry;

public class SchoolLanguageApp {
    public static void main(String[] args) {
        try (Scanner stringScanner = new Scanner(System.in)) {
            System.out.print("Абслолютный путь до файла: ");
            List<String> lines = Files.readAllLines(Path.of(stringScanner.nextLine()));
            for (var element : find(convertInput(lines))) {
                System.out.println(element.getKey());
                element.getValue().forEach(System.out::println);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла");
            System.exit(1);
        }
    }

    public static List<Map.Entry<Integer, Set<String>>> find(Map<Integer, Set<String>> lines) {
        List<Map.Entry<Integer, Set<String>>> languages = new ArrayList<>();
        var maxEntry = findMaxKeyEntry(lines);
        var minEntry = findMinKeyEntry(lines);

        languages.add(maxEntry);
        languages.add(minEntry);
        return languages;
    }

    private static Map<Integer, Set<String>> convertInput(List<String> lines) {
        lines = lines.subList(1, lines.size());

        Map<Integer, Set<String>> res = new HashMap<>();
        int lastCounter = 0;
        for (String line : lines) {
            if (isInteger(line)) {
                lastCounter = Integer.parseInt(line);
                res.put(lastCounter, new TreeSet<>());
                continue;
            }
            res.get(lastCounter).add(line);
        }
        return res;
    }

    private static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
