package org.example;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GetDiff {
    public static void main(String[] args) {
        List<String> array1 = readFileFromResources("fields1.txt");
        List<String> array2 = readFileFromResources("fields2.txt");

        // Далее, выполните пересечение и вывод, как указано в предыдущем коде.

        List<String> intersection = findIntersection(array1, array2);

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

    public static List<String> readFileFromResources(String filename) {
        List<String> lines = new ArrayList<>();
        try {
            InputStream inputStream = GetDiff.class.getClassLoader().getResourceAsStream(filename);
            if (inputStream != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
                reader.close();
            } else {
                System.err.println("Файл " + filename + " не найден в папке resources.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }
}
