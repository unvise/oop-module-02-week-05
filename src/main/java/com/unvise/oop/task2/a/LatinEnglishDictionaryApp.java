package com.unvise.oop.task2.a;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LatinEnglishDictionaryApp {
    public static void main(String[] args) {
        try (Scanner stringScanner = new Scanner(System.in)) {
            System.out.print("Абслолютный путь до файла: ");
            List<String> lines = Files.readAllLines(Path.of(stringScanner.nextLine()));

            LatinEnglishDictionary latinEnglishDictionary = new LatinEnglishDictionary();
            saveTranslationsToDictionary(lines, latinEnglishDictionary);

            System.out.println(latinEnglishDictionary.getLatinDictionary().size());
            System.out.println(latinEnglishDictionary.read("%s - %s"));
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла");
            System.exit(1);
        }
    }

    public static Map.Entry<String, List<String>> convertInputString(String line) {
        String[] split = line.trim().replace(" -", ",").split(", ");
        List<String> words = Arrays.asList(split);
        return Map.entry(words.get(0), words.subList(1, words.size()));
    }

    public static void saveTranslationsToDictionary(List<String> lines, LatinEnglishDictionary latinEnglishDictionary) {
        for (String line : lines) {
            var convert = convertInputString(line);
            latinEnglishDictionary.saveTranslation(convert.getValue(), convert.getKey());
        }
    }
}
