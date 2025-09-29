package utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class Constants {

    // ==============================
    // Config File Locations
    // ==============================
    public static final String ENV_FILE = "classpath:config/Environment.json";
    public static final String API_SERVER_FILE = "classpath:config/ApiServerData.json";
    public static final String FILE_PATH_CONFIG = "classpath:config/FilePath.json";

    // ==============================
    // Default DB Settings (can be overridden in Environment.json)
    // ==============================
    public static final String DEFAULT_DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DEFAULT_DB_URL = "";
    public static final String DEFAULT_DB_USER = "";
    public static final String DEFAULT_DB_PASSWORD = "";

    // ==============================
    // Runtime Storage
    // ==============================
    public static Map<String, Object> envDataMap = new LinkedHashMap<>();
}
