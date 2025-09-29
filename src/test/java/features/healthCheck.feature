Feature: Health Check Info

  Background:
    * def filePath = read(file_path)
    * def apiServerDataJson = read(apiServerData)
    * def baseURL = env == 'qa' ? apiServerDataJson.baseQaURL : apiServerDataJson.baseAnotherEnvURL
    * def getHeaderInfo = env == 'qa' ? filePath.Headers+'@qa' : filePath.Headers+'@env'
    * def setHeader = call read(getHeaderInfo)
    * configure headers = setHeader.HEADER

  Scenario: Verify service health check endpoint
    * def apiURI = apiServerDataJson["global-user-api(US)"].healthCheck
    * def endpoint = baseURL + apiURI
    Given url endpoint
    When method GET
    Then status 200
    And match response ==
    """
    {
      status: "#string",
      version: "#string",
      serverTimestamp: "#string",
      memoryUsage: {
        eventLoopDelay: "#string",
        rssBytes: "#string",
        heapUsed: "#string"
      }
    }
    """
