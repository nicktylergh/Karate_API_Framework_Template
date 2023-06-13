Feature: Set up Test Data

  @updateUserProfile
  Scenario: create data for update user endpoint
    * def javaClassObject = Java.type('utils.DataGenerator')
    * print fileName
    * def result = (new javaClassObject()).generateUserProfileData(fileName, region,index, email, password)
    
   @newsLetterUpdate
  Scenario: create data for newsLetter update
    * def javaClassObject = Java.type('utils.DataGenerator')
    * print fileName
    * def result = (new javaClassObject()).generateNewsLetterData(fileName, region,index, email)