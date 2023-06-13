package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Constants {

	public final static String CLASSNAME = "";
	public static Connection connection = null;
	public static Statement statement = null;
	public static ResultSet rs = null;
	public static List<LinkedHashMap<String, String>> resultsetInListOfMaps = new ArrayList<>();
	public static Map<String, Object> envDataMap = new LinkedHashMap<String, Object>();
	public static String query;
	public static String depQuery;
	public static void setQuery(String region) {
		
	}
}
