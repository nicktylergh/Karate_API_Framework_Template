Feature: Generate Authentication token for qa Environment

  #qa
  @token
  Scenario: Generate access Token
    * def ServerData = read(apiServerData)
    * def baseURL =  ServerData.baseQaURL
    * def apiURI = ServerData.authSignIn
    * def endpoint = baseURL+apiURI
    * def request_body =
      """
      {
      "email": '#(email)',
      "password": '#(password)'
      }
      """
    Given headers {Accept: 'application/json'}
    And url endpoint
    And request request_body
    When method POST
    * print response
    * def token = response.AccessToken
