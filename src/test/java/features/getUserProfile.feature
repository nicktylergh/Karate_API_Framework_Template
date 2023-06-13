Feature: User profile information

  Background:
    * def filePath = read(file_path)
    * def apiServerDataJson = read(apiServerData)
    * def baseURL = env == 'qa' ? apiServerDataJson.baseQaURL : apiServerDataJson.baseAnotherEnvURL
    * def getHeaderInfo = env == 'qa' ? filePath.Headers+'@qa' : filePath.Headers+'@anotherRegion'
    * def setHeader = call read(getHeaderInfo)
    * configure headers = setHeader.HEADER


  #1.getting user information
  Scenario: Verify User able to get profile information
    * def apiURI = apiServerDataJson["global-user-api(US)"].getUserProfile
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
	    userId: '#uuid',
	    email: '#string',
	    firstName: '#string',
	    lastName: '#string',
	    phoneNumber: '#string',
	    countryCode: '#string',
	    newsletter: '#boolean',
	    newsletterUk: '#boolean',
	    newsletterFr: '#boolean',
	    newsletterDe: '#boolean',
	    source: '#string',
	    timestamp: {
	      createdAt: '#string',
	      updatedAt: '#string'
	    }
	  }
	  """

	  # Validate the response data
	  And match response.email == 'nick.tyler@ecoatm.com'
    