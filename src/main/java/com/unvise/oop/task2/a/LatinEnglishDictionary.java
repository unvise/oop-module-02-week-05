package com.unvise.oop.task2.a;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LatinEnglishDictionary {
    private final Map<String, List<String>> latinDictionary = new TreeMap<>();

    public void saveTranslation(List<String> latins, String english) {
        for (String latin : latins) {
            if (!latinDictionary.containsKey(latin)) {
                latinDictionary.put(latin, new ArrayList<>());
            }
            if (!latinDictionary.get(latin).contains(english)) {
                latinDictionary.get(latin).add(english);
            }
        }
    }

    public String read(String format) {
        StringBuilder stringBuilder = new StringBuilder();
        for (var entry : latinDictionary.entrySet()) {
            String values = entry.getValue().toString().replaceAll("[\\[\\]]", "");
            stringBuilder
                    .append(String.format(format, entry.getKey(), values))
                    .append("\n");
        }
        return stringBuilder.toString();
    }

    public Map<String, List<String>> getLatinDictionary() {
        return latinDictionary;
    }
}
