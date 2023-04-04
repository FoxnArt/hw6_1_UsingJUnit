package ru.netology;

public class Main {
    public static void main(String[] args) {

        Calculator calc = Calculator.instance.get();

        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1,1);
        int c = calc.devide.apply(a, b); //В этой строке происходит деление на ноль, поэтому java
        // выбрасывает ArithmeticException

        calc.println.accept(a);

    }
}