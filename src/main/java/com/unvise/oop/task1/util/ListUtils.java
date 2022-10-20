package com.unvise.oop.task1.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListUtils {
    public static List<Integer> getNumsFromString(String line,
                                                  String split,
                                                  Map<String, String> replace) throws NumberFormatException {
        for (var toReplace : replace.entrySet()) {
            line = line.replace(toReplace.getKey(), toReplace.getValue());
        }
        List<Integer> nums = new ArrayList<>();
        for (String num : line.split(split)) {
            nums.add(Integer.parseInt(num.trim()));
        }
        return nums;
    }
}
