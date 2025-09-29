Feature: Generate Authentication Token

  @token
  Scenario: Generate access token for given environment
    * def serverData = read(apiServerData)
    * def baseURL = env == 'qa' ? serverData.baseQaURL : serverData.baseAnotherEnvURL
    * def apiURI = serverData.authSignIn
    * def endpoint = baseURL + apiURI

    * def request_body =
    """
    {
      "email": "#(email)",
      "password": "#(password)"
    }
    """

    Given headers { Accept: 'application/json' }
    And url endpoint
    And request request_body
    When method POST
    Then status 200
    * print response
    * def token = response.token ? response.token : response.accessToken
    * karate.set('authToken', token)
