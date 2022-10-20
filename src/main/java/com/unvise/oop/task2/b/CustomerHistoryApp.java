package com.unvise.oop.task2.b;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CustomerHistoryApp {
    public static void main(String[] args) {
        try (Scanner stringScanner = new Scanner(System.in)) {
            System.out.print("Абслолютный путь до файла: ");
            List<String> lines = Files.readAllLines(Path.of(stringScanner.nextLine()));
            System.out.println(createCustomerHistory(convertInputString(lines)).read("%s:", "%s %d"));
        } catch (IllegalArgumentException | IOException e) {
            System.out.println("Ошибка чтения файла");
            System.exit(1);
        }
    }

    public static CustomerHistory createCustomerHistory(List<List<String>> lines) throws IllegalArgumentException {
        CustomerHistory customerHistory = new CustomerHistory();
        lines.forEach(line -> {
            if (line.size() != 3) {
                throw new IllegalArgumentException();
            }
            customerHistory.save(line.get(0), line.get(1), Integer.parseInt(line.get(2)));
        });
        return customerHistory;
    }

    public static List<List<String>> convertInputString(List<String> lines) {
        List<List<String>> res = new ArrayList<>();
        lines.forEach(line -> res.add(Arrays.asList(line.split(" "))));
        return res;
    }

}
