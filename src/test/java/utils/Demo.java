package utils;

public class Demo {

    public static void main(String[] args) {
        try {
            DataGenerator generator = new DataGenerator();

            // Paths (make sure these JSON files exist in your project)
            String userProfileFile = "src/test/java/data/globalUserApiUS/updateUserProfile.json";
            String newsLetterFile  = "src/test/java/data/globalUserApiUS/newsLetterUpdate.json";

            // Example test data
            String region = "qa";
            String index = "0"; // first record in the JSON array

            // Generate user profile test data
            generator.generateUserProfileData(
                    userProfileFile,
                    region,
                    index,
                    "test.user@example.com",
                    "Password123!"
            );

            // Generate newsletter test data
            generator.generateNewsLetterData(
                    newsLetterFile,
                    region,
                    index,
                    "newsletter.user@example.com"
            );

            System.out.println("Demo execution completed successfully.");

        } catch (NumberFormatException e) {
            System.err.println("Invalid index provided: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error in Demo: " + e.getMessage());
        }
    }
}
