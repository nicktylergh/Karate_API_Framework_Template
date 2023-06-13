# PocKarate

Karate config file:
One of its essential features is the karate-config file. This file contains all the configurations related to the testing we will perform. It is written in JavaScript and includes global variables that can be accessed throughout the project.

Src/test/Resources

filePath.json:
I have a configuration file called filePath.json. It is a JSON file that contains shortcuts to frequently used project locations. For example, it includes an environment variable that stores the actual location of the environment file.

Environment.json:
The Environment.json file, which contains information about the database connection. If we need to retrieve data from the database, we can find the database configuration in this file.

ApiServerData.json:
We have ApiServerData.json, and it contains various endpoints that we'll be using in our testing. It includes URLs and different fields that are relevant to the testing process.

Src/Test/Java

Data.globalUserApiUS package:
We also have a package called data.GlobalUserAPIUS. This package contains JSON files that serve as request bodies. When we perform methods like POST, PUT or PATCH, we can use these JSON files as the request body.







UTILS Package:
Additionally, we have a package called UTILS, which includes utility classes. Within this package, we have several classes such as Constants.java, DataGenerator.java, DBUtils.java, and JsonFileUtils.java.

1.	Constants.java:
In the Constants class, we define global Java variables that are used throughout the project. It includes variables like class names and configuration data. We also have a data environment map and query-related variables defined here.

2.	DataGenerator.java:
The DataGenerator class is responsible for generating data based on the type of request being made. It uses the Faker data dependency to provide random values. The generated data is stored in the environment map and used in test data and request bodies. The class includes methods for updating test data and request bodies after each request.

3.	DBUtils.java:
In the DBUtils class, we handle database-related operations. It allows us to establish connections to the database using JDBC. We define connection variables and provide a connectToDB() method to establish the connection and retrieve query results.

4.	JsonFileUtils.java:
The JsonFileUtils class is used to convert maps or lists into JSON objects. It contains the modifyTestData method, which is used to update JSON files. This method takes arguments to locate each field and transforms the received map into a JSON file.

Feature files:
We use feature files to define and execute our test cases. Karate eliminates the need for separate step definition classes by providing predefined functions.

Helpers feature file:
The Helpers feature file contains scenarios for configuring headers, authentication, and test data. We use the @qa tag to identify scenarios specific to the QA environment. The file-path and other variables defined in the environment are loaded into memory using the read method. We can execute Java classes directly within the feature file to provide variables for headers. The helper feature files enable us to obtain tokens and generate test data.

Feature file examples:
Feature files contain test cases for specific endpoints, such as getUserProfile. We define variables in the background to load necessary shortcuts and JSON files. The base URL is determined based on the environment variable. Header information is retrieved and stored in variables based on the environment. Java classes are executed to set up the headers. Scenarios in the feature files define the endpoint and perform requests using Karate functions like URL and method. Responses can be printed and validated using status codes and response schema.

Karate Report:
The Karate Report provides a detailed overview of each operation's steps. Successful steps are displayed in green font, while failed steps are highlighted in red. The report includes information such as response time, response body, and comments from the feature files. It serves as a comprehensive summary of the test execution.

That wraps up the overview of the different components and files involved in your Karate project. Each file and package plays a specific role in facilitating the testing process, from configuration and data generation to executing test cases and generating reports.
