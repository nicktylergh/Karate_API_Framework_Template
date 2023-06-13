@SmokeTest
Feature: Update news letter

  Background: 
    * def filePath = read(file_path)
    * def testDataFilePath = filePath.NewsLetterTestData
    * def apiServerDataJson = read(apiServerData)
    * def baseURL = env == 'qa' ? apiServerDataJson.baseQaURL : apiServerDataJson.baseAnotherEnvURL
    * def getHeaderInfo = env == 'qa' ? filePath.Headers+'@qa' : filePath.Headers+'@env'
    * print getHeaderInfo
    * def setHeader = call read(getHeaderInfo)
    * print setHeader
    * configure headers = setHeader.HEADER

  #1.Updating a resource PUT REQUEST
  Scenario Outline: Verify User able to update newsletter with valid data
    * def apiURI = apiServerDataJson["global-user-api(US)"].newsLetterUpdate
    * def endpoint = baseURL+apiURI
    Given url endpoint
    * def generateTestData = call read("file:"+filePath.GenerateTestData+'@newsLetterUpdate'){fileName:'#(testDataFilePath)', region: '<region>', index: '<index>', email: '#(email)'}
    * def request_body = read('file:'+filePath.NewsLetterTestData)
    * print request_body
    And request request_body.<region>[<index>]
    When method PUT
    * print response
    # validate response status code
    Then status <status_code>
    And match response.$metadata == { httpStatusCode: 200, requestId: '#string', attempts: '#number', totalRetryDelay: '#number' }
    And match response.Attributes ==
      """
      {
      newsletterFr: '#boolean',
      newsletterUk: '#boolean',
      newsletter: '#boolean',
      newsletterDe: '#boolean',
      timestamp: { updated_at: '#string' }
      }
      """

    @qa
    Examples: 
      | region | index | status_code |
      | qa     |     0 |         200 |
      | qa     |     1 |         200 |
