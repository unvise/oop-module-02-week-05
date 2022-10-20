package com.unvise.oop.task2.c;

import java.util.List;

import static com.unvise.oop.task2.c.Benchmarks.iterAvgNanoTime;

public class FibonacciApp {
    public static void main(String[] args) {
        List<Long> fibonacciTimes = iterAvgNanoTime((x) -> {
            Fibonacci fibonacci = new Fibonacci();
            fibonacci.fibonacci(x);
        }, List.of(3, 30, 3), 500);
        System.out.println("Время (нс) выполнения классической (рекурсивной) реализации Фибоначчи: " + fibonacciTimes);

        List<Long> fibonacciCachedTimes = iterAvgNanoTime((x) -> {
            // каждый раз создается новый экземпляр класса, чтобы
            // очистить мапу с кешированными значениями
            Fibonacci fibonacci = new Fibonacci();
            fibonacci.fibonacciCached(x);
        }, List.of(3, 30, 3), 500);
        System.out.println("Время (нс) выполнения кеширующей (рекурсивной) реализации Фибоначчи: " + fibonacciCachedTimes);
    }
}
