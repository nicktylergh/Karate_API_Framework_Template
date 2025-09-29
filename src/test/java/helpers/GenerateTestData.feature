Feature: Set up Test Data

  @updateUserProfile
  Scenario: Create data for update user profile endpoint
    * def DataGenerator = Java.type('utils.DataGenerator')
    * eval new DataGenerator().generateUserProfileData(fileName, region, index, email, password)

  @newsLetterUpdate
  Scenario: Create data for newsletter update endpoint
    * def DataGenerator = Java.type('utils.DataGenerator')
    * eval new DataGenerator().generateNewsLetterData(fileName, region, index, email)
