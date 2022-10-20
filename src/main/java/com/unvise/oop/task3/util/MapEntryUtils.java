package com.unvise.oop.task3.util;

import java.util.Map;
import java.util.Set;

import static java.util.Objects.isNull;

public class MapEntryUtils {
    public static Map.Entry<Integer, Set<String>> findMaxKeyEntry(Map<Integer, Set<String>> map) {
        Map.Entry<Integer, Set<String>> maxEntry = null;
        for (var entry : map.entrySet()) {
            if (isNull(maxEntry) || entry.getKey().compareTo(maxEntry.getKey()) > 0) {
                maxEntry = entry;
            }
        }
        return maxEntry;
    }

    public static Map.Entry<Integer, Set<String>> findMinKeyEntry(Map<Integer, Set<String>> map) {
        Map.Entry<Integer, Set<String>> maxEntry = null;
        for (var entry : map.entrySet()) {
            if (isNull(maxEntry) || entry.getKey().compareTo(maxEntry.getKey()) < 0) {
                maxEntry = entry;
            }
        }
        return maxEntry;
    }
}
