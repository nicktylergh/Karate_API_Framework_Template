package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonFileUtils {

    /**
     * Converts a JSON file to String.
     */
    public static String jsonToStrConvertion(String fileName) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(fileName));
        return new String(encoded, StandardCharsets.UTF_8);
    }

    /**
     * Modifies test data inside a JSON file.
     *
     * @param map      key/value pairs to update
     * @param fileName JSON file path
     * @param region   region inside the JSON
     * @param index    which object in the array to update
     */
    public static void modifyTestData(Map<String, Object> map, String fileName, String region, int index)
            throws JSONException, IOException {

        String jsonToString = jsonToStrConvertion(fileName);

        JSONObject obj = new JSONObject(jsonToString);
        JSONArray regionArr = obj.getJSONArray(region);
        JSONObject regionData = regionArr.getJSONObject(index);

        // Update values
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            regionData.put(entry.getKey(), entry.getValue());
        }

        // Write changes back to file
        try (FileWriter file = new FileWriter(fileName, false)) {
            file.write(obj.toString(4)); // pretty print with indentation
        }
    }

    /**
     * Converts JSON object for a given region into a Map.
     */
    public static Map<String, Object> jsonToMap(String filePath, String region)
            throws IOException, JSONException {

        Map<String, Object> regionDataMap = new LinkedHashMap<>();

        String jsonToString = jsonToStrConvertion(filePath);
        JSONObject obj = new JSONObject(jsonToString);
        JSONObject envMap = obj.getJSONObject(region);

        Iterator<String> keys = envMap.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            Object value = envMap.get(key);
            if (value != null && !value.toString().isEmpty()) {
                regionDataMap.put(key, value);
            }
        }
        return regionDataMap;
    }
}
