package utils;

import io.restassured.path.json.JsonPath;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class JSONReader {
    private static final LoggerManager log = LoggerManager.getInstance();
    private final JsonPath jsonPath;

    public JSONReader(String filePath) {
        log.info("Loading file");
        File file = new File(filePath);
        jsonPath = new JsonPath(file);
    }

    public String getString(String path) {
        return jsonPath.getString(path);
    }

    public Map<String, HashMap<String, Object>> getMap(String path) {
        return jsonPath.getMap(path);
    }
}
