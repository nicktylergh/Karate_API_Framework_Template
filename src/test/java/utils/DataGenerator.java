package utils;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONException;

import com.github.javafaker.Faker;

public class DataGenerator extends JsonFileUtils {


	public void generateUserProfileData(String fileName, String region, String indexStr, String email, String password) throws JSONException, IOException {
		int index = Integer.parseInt(indexStr);
		Faker fakeData = new Faker(); // to use to generate random data.

		//use DBUtils in case database connection is needed for test data.

		String phoneNumber = fakeData.phoneNumber().phoneNumber();
		String firstName = fakeData.name().firstName();
		String lastName = fakeData.name().lastName();

		Map<String, Object> user = new LinkedHashMap<String, Object>();
		user.put("email", email);
		user.put("password", password);
		user.put("phoneNumber", phoneNumber);
		user.put("firstName", firstName);
		user.put("lastName", lastName);


		modifyTestData(user, fileName, region, index);

	}
	public void generateNewsLetterData(String fileName, String region, String indexStr, String email) throws JSONException, IOException {
		int index = Integer.parseInt(indexStr);
		Faker fakeData = new Faker(); // to use to generate random data.
		
		//use DBUtils in case database connection is needed for test data.
		
		String countryCode = fakeData.country().countryCode2();
		String firstName = fakeData.name().firstName();
		String lastName = fakeData.name().lastName();
		boolean newsletter = false;
		
		Map<String, Object> user = new LinkedHashMap<String, Object>();
		user.put("email", email);
		user.put("countryCode", countryCode);
		user.put("firstName", firstName);
		user.put("lastName", lastName);
		user.put("newsletter", newsletter);
		
		
		modifyTestData(user, fileName, region, index);
		
	}

}
