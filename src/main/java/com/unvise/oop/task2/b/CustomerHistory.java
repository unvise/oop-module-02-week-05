package com.unvise.oop.task2.b;

import java.util.Map;
import java.util.TreeMap;

public class CustomerHistory {
    private final Map<String, Map<String, Integer>> history = new TreeMap<>();

    public void save(String customerName, String productName, Integer productCount) {
        if (!history.containsKey(customerName)) {
            Map<String, Integer> productMap = new TreeMap<>();
            productMap.put(productName, productCount);
            history.put(customerName, productMap);
        }
        history.get(customerName).put(productName, productCount);
    }

    public String read(String customerFormat, String productFormat) {
        StringBuilder stringBuilder = new StringBuilder();
        for (var customer : history.entrySet()) {
            stringBuilder
                    .append(String.format(customerFormat, customer.getKey()))
                    .append("\n");

            for (var product : customer.getValue().entrySet()) {
                stringBuilder
                        .append(String.format(productFormat, product.getKey(), product.getValue()))
                        .append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public Map<String, Map<String, Integer>> getHistory() {
        return history;
    }
}
