package com.unvise.oop.task3.c;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidParenthesesApp {
    private static final Pattern PATTERN = Pattern.compile("[{}\\[\\]()]*");

    public static void main(String[] args) {
        try (Scanner parenthesesScanner = new Scanner(System.in)) {
            String parentheses = parenthesesScanner.nextLine();
            if (!PATTERN.matcher(parentheses).matches()) {
                System.out.println("Входная строка не соответствует шаблону");
                System.exit(1);
            }
            System.out.println(isValid(parentheses));
        }
    }

    public static boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(') {
                deque.addFirst(ch);
            } else {
                if (!deque.isEmpty()
                        && ((deque.peekFirst() == '{' && ch == '}')
                        || (deque.peekFirst() == '[' && ch == ']')
                        || (deque.peekFirst() == '(' && ch == ')'))) {
                    deque.removeFirst();
                } else {
                    return false;
                }
            }
        }
        return deque.isEmpty();
    }
}
