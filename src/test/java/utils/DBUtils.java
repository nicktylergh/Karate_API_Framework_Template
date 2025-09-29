package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.json.JSONException;

public class DBUtils extends Constants {

    // Class-level fields for DB state
    private static Connection connection;
    private static Statement statement;
    private static ResultSet rs;
    private static List<LinkedHashMap<String, String>> resultsetInListOfMaps = new ArrayList<>();

    /**
     * Establishes a database connection using environment JSON and constants.
     */
    public static void connectToDB(String region) {
        try {
            // Load JDBC driver
            Class.forName(DEFAULT_DB_DRIVER);

            // Load environment config (if not already loaded)
            if (envDataMap == null || envDataMap.isEmpty()) {
                try {
                    envDataMap = JsonFileUtils.jsonToMap(ENV_FILE, region);
                } catch (JSONException | java.io.IOException e) {
                    System.err.println("Error loading environment JSON: " + e.getMessage());
                    return;
                }
            }

            // Create connection
            connection = DriverManager.getConnection(
                    envDataMap.getOrDefault("DBServerURL", DEFAULT_DB_URL).toString(),
                    envDataMap.getOrDefault("DBUserName", DEFAULT_DB_USER).toString(),
                    envDataMap.getOrDefault("DBPassword", DEFAULT_DB_PASSWORD).toString()
            );

            statement = connection.createStatement();
            System.out.println("Database connection established for region: " + region);

        } catch (Exception e) {
            System.err.println("Could not establish connection with DB: " + e.getMessage());
        }
    }

    /**
     * Executes a SQL query and returns the raw ResultSet.
     */
    public static ResultSet executeQuery(String query) {
        try {
            rs = statement.executeQuery(query);
        } catch (Exception e) {
            System.err.println("Could not retrieve data from DB: " + e.getMessage());
        }
        return rs;
    }

    /**
     * Converts a ResultSet into a list of LinkedHashMaps.
     */
    public static List<LinkedHashMap<String, String>> getResultSetInListOfMap(ResultSet rs) {
        List<LinkedHashMap<String, String>> results = new ArrayList<>();
        try {
            if (rs != null) {
                ResultSetMetaData rsmd = rs.getMetaData();

                while (rs.next()) {
                    LinkedHashMap<String, String> rowMap = new LinkedHashMap<>();
                    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                        rowMap.put(rsmd.getColumnName(i), rs.getString(i));
                    }
                    results.add(rowMap);
                }
            }
        } catch (Exception e) {
            System.err.println("Could not parse DB result set: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                System.err.println("Error closing ResultSet: " + e.getMessage());
            }
        }
        return results;
    }

    /**
     * Convenience method to connect, query, and return results as list of maps.
     */
    public static List<LinkedHashMap<String, String>> makeDBRequest(String query, String region) {
        connectToDB(region);
        ResultSet rs = executeQuery(query);
        return getResultSetInListOfMap(rs);
    }
}
