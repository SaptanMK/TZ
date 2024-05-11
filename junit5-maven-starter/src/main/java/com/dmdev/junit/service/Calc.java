package com.dmdev.junit.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calc {

    public static int _min(int[] numbers) {
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }

    public static int _max(int[] numbers) {
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    public static int _sum(int[] numbers) {
        int sum = 0;
        try {
            for (int number : numbers) {
                sum = Math.addExact(sum, number);
            }
        } catch (ArithmeticException e){
            System.out.println("Сложение невозможно из-за ограничений Java. Вывод 0.");
            return 0;
        }
        return sum;
    }

    public static int _mult(int[] numbers) {
        int mult = 1;
        try {
            for (int number : numbers) {
                mult = Math.multiplyExact(mult, number);
            }
        } catch (ArithmeticException e) {
            System.out.println("Умножение невозможно из-за ограничений Java. Вывод 0.");
            return 0;
        }
        return mult;
    }

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(".idea/numbers.txt"));
            String line = reader.readLine();
            String[] parts = line.split(" ");
            int[] numbers = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                numbers[i] = Integer.parseInt(parts[i]);
            }

            int min = _min(numbers);
            int max = _max(numbers);
            int sum = _sum(numbers);
            int mult = _mult(numbers);

            System.out.println("Минимальное: " + min);
            System.out.println("Максимальное: " + max);
            System.out.println("Сумма: " + sum);
            System.out.println("Произведение: " + mult);

            reader.close();
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла");
        }
    }
}
