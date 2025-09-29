Feature: User profile API

  Background:
    * def filePath = read(file_path)
    * def apiServerDataJson = read(apiServerData)
    * def baseURL = apiServerDataJson.baseQaURL
    * def apiURI = apiServerDataJson.userProfile.get
    * def endpoint = baseURL + apiURI
    * configure headers = { Content-Type: 'application/json' }

  Scenario: Verify user can retrieve profile information
    Given url endpoint
    When method GET
    Then status 200
    And match response ==
    """
    {
      userId: '#uuid',
      email: '#string',
      firstName: '#string',
      lastName: '#string',
      phoneNumber: '#string',
      countryCode: '#string',
      newsletter: '#boolean',
      createdAt: '#string',
      updatedAt: '#string'
    }
    """
