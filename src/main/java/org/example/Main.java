package org.example;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Загрузка JSON-файла из папки resources
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("data.json");

        if (inputStream != null) {
            try {
                InputStreamReader reader = new InputStreamReader(inputStream);

                // Используем библиотеку Gson для разбора JSON
                JsonParser parser = new JsonParser();
                JsonObject jsonObject = parser.parse(reader).getAsJsonObject();

                // Получаем массив "tabs"
                JsonArray tabsArray = jsonObject.getAsJsonArray("tabs");

                // Создаем список для хранения значений "name"
                List<String> namesList = new ArrayList<>();

                for (int i = 0; i < tabsArray.size(); i++) {
                    JsonObject tabObject = tabsArray.get(i).getAsJsonObject();

                    if (tabObject.has("widgets")) {
                        JsonArray widgetsArray = tabObject.getAsJsonArray("widgets");

                        for (int j = 0; j < widgetsArray.size(); j++) {
                            JsonObject widgetObject = widgetsArray.get(j).getAsJsonObject();
                            String name = widgetObject.get("name").getAsString();
                            namesList.add(name);
                        }
                    }
                }

                // Выводим список имен на экран
                for (String name : namesList) {
                    System.out.println(name);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Файл data.json не найден в папке resources.");
        }
    }
}
