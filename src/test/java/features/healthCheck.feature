
Feature: Healt Check Info

  Background:
    * def filePath = read(file_path)
    * def apiServerDataJson = read(apiServerData)
    * def baseURL = env == 'qa' ? apiServerDataJson.baseQaURL : apiServerDataJson.baseAnotherEnvURL
    * def getHeaderInfo = env == 'qa' ? filePath.Headers+'@qa' : filePath.Headers+'@env'
    * print getHeaderInfo
    * def setHeader = call read(getHeaderInfo)
    * print setHeader
    * configure headers = setHeader.HEADER

  #1.getting user information
  Scenario: Verify User able to get profile information
    * def apiURI = apiServerDataJson["global-user-api(US)"].healthCheck
    * def endpoint = baseURL+apiURI
    Given url endpoint
    When method GET
    * print response
    # Validate status code
		Then status 200
	  # Validate the response schema
	  And match response == 
	  """
    {
        "status": "#string",
        "version": "#string",
        "serverTimestamp": "#string",
        "memoryUsage": {
            "eventLoopDelay": "#string",
            "rssBytes": "#string",
            "heapUsed": "#string"
        }
    }
    """
    