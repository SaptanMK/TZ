//package com.dmdev.junit.service;
//
//import org.junit.jupiter.api.Test;
//
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Random;
//
//public class TimeTest {
//
//    private void createInputFile(int size) {
//        try {
//            FileWriter writer = new FileWriter("numbers.txt");
//            for (int i = 1; i <= size; i++) {
//                Random r = new Random();
//                int x = r.nextInt(6) + 1;
//                writer.write(x + " ");
//            }
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void testPerformance() {
//        for (int i = 1000; i <= 10000; i += 100) {
//            createInputFile(i);
//            long startTime = System.currentTimeMillis();
//            Calc.main(null);
//            long endTime = System.currentTimeMillis();
//            System.out.println("Количество чисел в файле: " + i + " Время выполнения: " + (endTime - startTime) + " мс");
//        }
//    }
//}
