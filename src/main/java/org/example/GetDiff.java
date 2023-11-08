package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetDiff {
    public static void main(String[] args) {
        // Создаем два массива
        List<String> array1 = new ArrayList<>();
        List<String> array2 = new ArrayList<>();

        // Читаем данные из файла fields1.txt и заполняем array1
        try {
            BufferedReader reader = new BufferedReader(new FileReader("fields1.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                array1.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Читаем данные из файла fields2.txt и заполняем array2
        try {
            BufferedReader reader = new BufferedReader(new FileReader("fields2.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                array2.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Вызываем метод, чтобы найти пересечение
        List<String> intersection = findIntersection(array1, array2);

        // Выводим результат
        for (String item : intersection) {
            System.out.println(item);
        }
    }

    public static List<String> findIntersection(List<String> array1, List<String> array2) {
        List<String> result = new ArrayList<>();

        for (String item : array1) {
            if (array2.contains(item)) {
                result.add(item);
            }
        }

        return result;
    }
}
