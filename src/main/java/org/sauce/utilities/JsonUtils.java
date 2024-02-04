package org.sauce.utilities;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class JsonUtils {

    public static JsonObject getFileAsObject(String jsonFilePath) {
        JsonObject jsonObject = null;
        try {
            Path filePath = Paths.get(jsonFilePath);
            Reader reader = Files.newBufferedReader(filePath);
            JsonElement fileAsElement = JsonParser.parseReader(reader);
            jsonObject = fileAsElement.getAsJsonObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static JsonArray getFileAsArray(String jsonFilePath) {
        JsonArray jsonObject = null;
        try {
            Path filePath = Paths.get(jsonFilePath);
            Reader reader = Files.newBufferedReader(filePath);
            JsonElement fileAsElement = JsonParser.parseReader(reader);
            jsonObject = fileAsElement.getAsJsonArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

}
