package utils;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import net.datafaker.Faker;
import org.json.JSONException;

public class DataGenerator extends JsonFileUtils {

    private static final Faker faker = new Faker();

    /**
     * Generates random user profile test data and updates the JSON file.
     */
    public void generateUserProfileData(String fileName, String region, String indexStr, String email, String password) {
        try {
            int index = Integer.parseInt(indexStr);

            Map<String, Object> user = new LinkedHashMap<>();
            user.put("email", email);
            user.put("password", password);
            user.put("phoneNumber", faker.phoneNumber().phoneNumber());
            user.put("firstName", faker.name().firstName());
            user.put("lastName", faker.name().lastName());

            modifyTestData(user, fileName, region, index);

            System.out.println("User profile data generated and updated for region: " + region);

        } catch (NumberFormatException e) {
            System.err.println("Invalid index provided: " + indexStr);
        } catch (IOException | JSONException e) {
            System.err.println("Error while updating user profile data: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error in generateUserProfileData: " + e.getMessage());
        }
    }

    /**
     * Generates random newsletter test data and updates the JSON file.
     */
    public void generateNewsLetterData(String fileName, String region, String indexStr, String email) {
        try {
            int index = Integer.parseInt(indexStr);

            Map<String, Object> user = new LinkedHashMap<>();
            user.put("email", email);
            user.put("countryCode", faker.address().countryCode()); // DataFaker API change
            user.put("firstName", faker.name().firstName());
            user.put("lastName", faker.name().lastName());
            user.put("newsletter", false);

            modifyTestData(user, fileName, region, index);

            System.out.println("Newsletter data generated and updated for region: " + region);

        } catch (NumberFormatException e) {
            System.err.println("Invalid index provided: " + indexStr);
        } catch (IOException | JSONException e) {
            System.err.println("Error while updating newsletter data: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error in generateNewsLetterData: " + e.getMessage());
        }
    }
}
