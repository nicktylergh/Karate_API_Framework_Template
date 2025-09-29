@SmokeTest
Feature: Update Newsletter

  Background:
    * def filePath = read(file_path)
    * def testDataFilePath = filePath.NewsLetterTestData
    * def apiServerDataJson = read(apiServerData)
    * def baseURL = env == 'qa' ? apiServerDataJson.baseQaURL : apiServerDataJson.baseAnotherEnvURL
    * def getHeaderInfo = env == 'qa' ? filePath.Headers+'@qa' : filePath.Headers+'@env'
    * def setHeader = call read(getHeaderInfo)
    * configure headers = setHeader.HEADER

  Scenario Outline: Verify user can update newsletter with valid data
    * def apiURI = apiServerDataJson["global-user-api(US)"].newsLetterUpdate
    * def endpoint = baseURL + apiURI
    * def generateTestData = call read("file:" + filePath.GenerateTestData + '@newsLetterUpdate')
    """
    {
      fileName: '#(testDataFilePath)',
      region: '<region>',
      index: '<index>',
      email: '#(email)'
    }
    """
    * def request_body = read('file:' + filePath.NewsLetterTestData)
    And request request_body.<region>[<index>]
    When method PUT
    Then status <status_code>
    And match response.$metadata ==
  {
  httpStatusCode: 200,
  requestId: '#string',
  attempts: '#number',
  totalRetryDelay: '#number'
  }
    And match response.Attributes ==
  {
  newsletterFr: '#boolean',
  newsletterUk: '#boolean',
  newsletter: '#boolean',
  newsletterDe: '#boolean',
  timestamp: { updated_at: '#string' }
  }

    @qa
    Examples:
      | region | index | status_code |
      | qa     | 0     | 200         |
      | qa     | 1     | 200         |
