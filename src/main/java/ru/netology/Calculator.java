package ru.netology;

import java.util.function.*;

public class Calculator {
    static Supplier<Calculator> instance = Calculator::new;
    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator<Integer> devide = (x, y) -> x / y;  // Для решения проблемы с делением на ноль
    // эту строку меняем на BinaryOperator<Integer> devide = (x, y) -> y != 0 ? x / y : 0;
    // по-правильному нужно выдавать сообщение "Разделить на ноль нельзя", но это String и в это лямбда выражение
    // не подходит по типу поскольку devide типа Integer
    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;
    Predicate<Integer> isPositive = x -> x > 0;
    Consumer<Integer> println = System.out::println;

    public Calculator() {
    }
}