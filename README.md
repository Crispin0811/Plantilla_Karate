# <img src="https://github.com/intuit/karate/raw/master/karate-core/src/main/resources/res/karate-logo.svg" height="60" width="60"/> Karate Framework - Base Project (PetStore API example)

- [Environment configuration](#environment-configuration)
  * [Java Development Kit](#java-development-kit)
  * [Eclipse IDE for Java Developers](#eclipse-ide-for-java-developers)
  * [Apache maven](#apache-maven)

- [Project plugins and dependencies](#project-plugins-and-dependencies)
  * [Dependencies](#dependencies)
  * [Plugins](#plugins)
    
- [Project structure](#project-structure)
  * [Features folder](#features-folder)
    + [Background](#background)
    + [Scenarios](#scenarios)
  * [Request folder](#request-folder)
  * [Response folder](#response-folder)
  * [Reusable_steps folder](#response-folder)
  * [Environment folder](#environment-folder)
  * [TestRunner file](#testrunner-file)
- [Run test by Eclipse IDE](#run-test-by-eclipse-ide)
- [Run test by console](#run-test-by-console)
- [Reports](#reports)


## Environment configuration
### Java Development Kit

Go to [this link to download JDK 1.8 ](https://www.oracle.com/sa/java/technologies/javase/javase-jdk8-downloads.html), go to *Java SE Development Kit* tab and download *Windows x64* version

#### Configure environment variable

1. Right click the Computer icon.
2. Choose Properties from the context menu.
3. Click the Advanced system settings link.
4. Click Environment Variables. 
5. In the section System Variables, create or edit **"JAVA_HOME"** variable and set path of java jdk. For example
```
Name  : JAVA_HOME
Value : C:\Program Files\Java\jdk1.8.0_211
```
6. In the section System Variables, create or edit **"path"** variable and set *%JAVA_HOME%\bin*. For example
```
Name  : path
Value : %JAVA_HOME%\bin
```


### Eclipse IDE for Java Developers

Download the stable version from [this link](https://www.eclipse.org/)  
During the instalation select **"Eclipse IDE for Java Developers"**



### Apache maven
Download the stable version from [this link](https://maven.apache.org/download.cgi). Select **Binary zip archive**

#### Configure environment variable
1. Right click the Computer icon.
2. Choose Properties from the context menu.
3. Click the Advanced system settings link.
4. Click Environment Variables. 
5. In the section System Variables, create or edit **"MAVEN_HOME"** variable and set path of apache maven. For example
```
Name  : MAVEN_HOME
Value : C:\Automatizacion\apache-maven-3.6.3
```
6. In the section System Variables, create or edit **"path"** variable and set *%MAVEN_HOME%\bin*. For example
```
Name  : path
Value : %MAVEN_HOME%\bin
```

## Project plugins and dependencies

### Dependencies
| groupId | artifactId | version |
| :---: | :---: | :---: |
| com.intuit.karate | karate-apache | 0.9.5 |
| com.intuit.karate | karate-junit5 | 0.9.5 |
| commons-io | commons-io | 0.9.5 |

### Plugins
| groupId | artifactId | version |
| :---: | :---: | :---: |
| org.apache.maven.plugins | maven-compiler-plugin | 3.6.0 |
| org.apache.maven.plugins | maven-surefire-plugin | 2.22.2|

## Project structure

```
└───systemic_qa_backend
    ├───.settings
    ├───src
    │   └───test
    │       └───java
    │           └───petstore
    │           │    ├───features
    │           │    ├───request
    │           │    └───response
    │           │
    │           └───core
    │           │    ├───constants
    │           │    └───environment
    │           │
    │           └───utils
    │                ├───reusable_steps
    │                └───utils.java
    │
    └───target
```

### Features folder  
Contains list of features

```
user_example01.feature

@petstore_user
Feature: User
  As a user
  I want to register on petstore
  So I can buy petstore services


  Background:
    * url ambiente.url
    #carga clase java utils
    * def utils_class = Java.type('utils.util')
    * def util = new utils_class()
	#request
    * def req_create_user = read('../request/create_user.json')
    #response
    * def res_create_user = read('../response/create_user.json')
    * def res_get_user = read('../response/get_user.json')


##### EJEMPLO UTILIZANDO DATOS ALEATORIOS
  @petstore_user_01 
  Scenario: Create user with random data
  	# CREATE USER
  	* def id = util.random_number(5)
    * set req_create_user.id = id
    * set req_create_user.username = 'user'+id
    * set req_create_user.firstName = util.random_string(8)
    * set req_create_user.lastName = util.random_string(8)
    * set req_create_user.email = id + '@'+ util.random_domain()
    * set req_create_user.password = ambiente.password
    * set req_create_user.phone = util.random_number(9)
    * set req_create_user.userStatus = constants.user_status.active
    Given path path_create_user
    * header Accept = 'application/json'
    * header Content-Type = 'application/json'
    And request req_create_user
    When method post
    Then status 200
    And print response
    And match response == res_create_user
    
    # GET CREATED USER
    Given path path_get_user,req_create_user.username
    * header Accept = 'application/json'
    * header Content-Type = 'application/json'
    When method get
    Then status 200
    And print response
    And match response == res_get_user
    
##### EJEMPLO UTILIZANDO DATOS DEFINIDOS
@petstore_user_02
  Scenario: Create user with defined data
  	# CREATE USER
  	* def id = util.random_number(5)
    * set req_create_user.id = id
    * set req_create_user.username = 'jquispe'
    * set req_create_user.firstName = 'Jose'
    * set req_create_user.lastName = 'Quispe'
    * set req_create_user.email = 'jquispe@karate.com'
    * set req_create_user.password = 'pass123'
    * set req_create_user.phone = '+511945124512'
    * set req_create_user.userStatus = constants.user_status.active
    Given path path_create_user
    * header Accept = 'application/json'
    * header Content-Type = 'application/json'
    And request req_create_user
    When method post
    Then status 200
    And print response
    And match response == res_create_user
    
    # GET CREATED USER
    Given path path_get_user,req_create_user.username
    * header Accept = 'application/json'
    * header Content-Type = 'application/json'
    When method get
    Then status 200
    And print response
    And match response == res_get_user
    
    
##### EJEMPLO UTILIZANDO SCENARIO OUTLINE
@petstore_user_03
  Scenario Outline: Create user with defined data
  	# CREATE USER
  	* def id = util.random_number(5)
    * set req_create_user.id = id
    * set req_create_user.username = '<username>'
    * set req_create_user.firstName = '<firstName>'
    * set req_create_user.lastName = '<lastName>'
    * set req_create_user.email = '<email>'
    * set req_create_user.password = '<password>'
    * set req_create_user.phone = '<phone>'
    * set req_create_user.userStatus = constants.user_status.inactive
    Given path path_create_user
    * header Accept = 'application/json'
    * header Content-Type = 'application/json'
    And request req_create_user
    When method post
    Then status 200
    And print response
    And match response == res_create_user
    
    # GET CREATED USER
    Given path path_get_user,req_create_user.username
    * header Accept = 'application/json'
    * header Content-Type = 'application/json'
    When method get
    Then status 200
    And print response
    And match response == res_get_user
    
    Examples:
    	|username	|firstName	|lastName	|email				|password	|phone			|
    	|jperez1	|Juan		|Perez		|jperez@karate.com	|"pass123"	|"+51945141522"	|
    	|llopez		|Luis		|Lopez		|llopez@karate.com	|"pass123"	|"+51945141523"	|
    	|ccaceres	|Carlos		|Caceres	|ccaceres@karate.com|"pass123"	|"+51945141524"	|
```
#### Background:
In this section we set:     
#### - Steps
Steps that will be replicated at the beginning of all scenarios
```
user_example01.feature

* url oapi_url
```

#### - Util
Call feature that have helper steps   
example:
``` 
Util.feature

@ignore
Feature:

Scenario:

* def random_string =
	 """ 
		function(length) {
		   var result           = '';
		   var characters       = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz';
		   var charactersLength = characters.length;
		   for ( var i = 0; i < length; i++ ) {
		      result += characters.charAt(Math.floor(Math.random() * charactersLength));
		   }
		   return result;
		}
	 """
 
 * def random_number =
 	 """ 
		function(length) {
		   var result           = '';
		   var characters       = '123456789';
		   var charactersLength = characters.length;
		   for ( var i = 0; i < length; i++ ) {
		      result += characters.charAt(Math.floor(Math.random() * charactersLength));
		   }
		   return result;
		}
	  """	  
```

call from feature:
```
user_example01.feature

* def utils_class = Java.type('utils.util')
* def util = new utils_class()
```

Use:
```
user_example01.feature

* set req_onboarding.dni = util.random_number(8) 
```

#### - Request
Calls to predefinited json structure to make a request  
Example: 
```
request_create_user.json

{
  "id": 1   ,
  "username": "",
  "firstName": "",
  "lastName": "",
  "email": "",
  "password": "",
  "phone": "",
  "userStatus": 1
}

```

call from feature:
```
user_example01.feature

* def req_create_user = read('../request/create_user.json')
```

Use:
```
 Scenario: Create user with random data
  	# CREATE USER
  	* def id = util.random_number(5)
    * set req_create_user.id = id
    * set req_create_user.username = 'user'+id
    * set req_create_user.firstName = util.random_string(8)
    * set req_create_user.lastName = util.random_string(8)
    * set req_create_user.email = id + '@'+ util.random_domain()
    * set req_create_user.password = ambiente.password
    * set req_create_user.phone = util.random_number(9)
    * set req_create_user.userStatus = constants.user_status.active
    Given path path_create_user
    * header Accept = 'application/json'
    * header Content-Type = 'application/json'
    And request req_create_user
    When method post
    Then status 200
```


#### - Response 
Calls to predefinited json structure to be validate type field or value
Example: 
```
response_create_user.json

{
    "code": "#number",
    "type": "#string",
    "message": "#string"
}

```

Call:
```
user_example01.feature

* def res_onboarding_201 = read('../response/response_onboarding_201.json')
```

Use:
```
 ...
 ....
    Given path path_create_user
    * header Accept = 'application/json'
    * header Content-Type = 'application/json'
    And request req_create_user
    When method post
    Then status 200
    And print response
    And match response == res_create_user
    
```

#### Scenarios
```
  Scenario: Create user with random data
  	# CREATE USER
  	* def id = util.random_number(5)
    * set req_create_user.id = id
    * set req_create_user.username = 'user'+id
    * set req_create_user.firstName = util.random_string(8)
    * set req_create_user.lastName = util.random_string(8)
    * set req_create_user.email = id + '@'+ util.random_domain()
    * set req_create_user.password = ambiente.password
    * set req_create_user.phone = util.random_number(9)
    * set req_create_user.userStatus = constants.user_status.active
    Given path path_create_user
    * header Accept = 'application/json'
    * header Content-Type = 'application/json'
    And request req_create_user
    When method post
    Then status 200
    And print response
    And match response == res_create_user
```
#### - Definitions

In this section we go to write the testcase with the follow definitions (some):
| definition | description | 
| :--- | :--- | 
| url | set url | 
| path | set enpoint path|
| set | set value to oject|
| def | create variable|
| print | print text or value in report|
| header | set header|
| request | set request body|
| method | set method and execute|
| status | validate response status|
| match | validate response schema or values|

Find more definitions [here](https://intuit.github.io/karate/)

#### - Tags
Can use tags to group and order testcases:
```
@petstore_create_user_ok @petstore_user_01 
  Scenario: Create user successfully with random data
  Given ....
  When ....
  Then ....
....

@petstore_create_user_ok @petstore_user_01 
  Scenario: Create user successfully with defined data
  Given ....
  When ....
  Then ....
....

@petstore_create_user_error @petstore_user_03 
Scenario: Try to create user with invalid name
  Given ....
  When ....
  Then ....
....

```
After, for example, if you run @petstore_create_user_ok tag will run 2 scenarios. If you run @petstore_create_user_error will run 1 scenario. If you run @petstore_user_02 will run 1 scenario.

### Request folder:
Contains json request format   
```
{
  "id": 1   ,
  "username": "",
  "firstName": "",
  "lastName": "",
  "email": "",
  "password": "",
  "phone": "",
  "userStatus": 1
}

```

### Response folder:
Contains json response format  
```
{
    "code": "#number",
    "type": "#string",
    "message": "#string"
}
```

### Reusable_steps folder:
Contains features that will be used in many flows
Example:
```
create_user_with_input_data.feature

Feature: Reusable create user steps

  Background:
    * url ambiente.url
    #carga clase java utils
    * def utils_class = Java.type('utils.util')
    * def util = new utils_class()
	#request
    * def req_create_user = read('../request/create_user.json')
    #response
    * def res_create_user = read('../response/create_user.json')


  Scenario: Create user with random data
  	# CREATE USER
  	* def id = util.random_number(5)
    * set req_create_user.id = id
    * set req_create_user.username = __arg.userName
    * set req_create_user.firstName = __arg.firstName
    * set req_create_user.lastName = __arg.lastName
    * set req_create_user.email = __arg.email
    * set req_create_user.password = __arg.password
    * set req_create_user.phone = __arg.phone
    * set req_create_user.userStatus = 1
    Given path path_create_user
    * header Accept = 'application/json'
    * header Content-Type = 'application/json'
    And request req_create_user
    When method post
    Then status 200
    And print response
    And match response == res_create_user
```

Use:
```
user_example02.feature

...
...
@petstore_user_05
  Scenario: Create user with defined data
	# CREATE USER
	* table create_user_input
  	|userName	|firstName	|lastName	|email				|password	|phone			|
        |"jperez4"	|"Juan"		|"Perez"	|"jperez@karate.com"|"pass123"	|"+51945141522"	|
  	* def result = call read('../../utils/reusable_steps/create_user_with_input_data.feature') create_user_input
	* print result[0]	
	
    # GET CREATED USER
    Given path path_get_user,result[0].req_create_user.username
    * header Accept = 'application/json'
    * header Content-Type = 'application/json'
    When method get
    Then status 200
    And print response
    And match response == res_get_user
```

### Constants folder:
Contains variables to use in features
Example:
```
constants.js

function fn() {

	var constants = {};

	// User Status
	constants.user_status = {
		active : 1,
		inactive : 0
	}

	return constants;
}
```

Use:
```
user_example01.feature

...
...

    * set req_create_user.password = ambiente.password
    * set req_create_user.phone = util.random_number(9)
    * set req_create_user.userStatus = constants.user_status.active
```

### Environment folder:
Contains variables that only works in every environment.
A file must be created for each environment (config-dev.js, config-qa.js, config-preprod.js)

Example:
```
config-qa.js

function environmentQA() {

	var ambiente = {
		url : 'https://petstore.swagger.io',
		password : '024680'
	};


	// Feature API Ejemplo
	ambiente.flujoX = {
		user : {
			numero_celular : '+5491177361162',
			dni : '71452242',
			password : '115599'
		},
		cards : {
			visa_debit_card_token : '4123220000000016',
			visa_credit_card : '4540750039904452',
			visa_debit_card : '4517650612965467',
			master_credit_card : '5505688230915366',
			master_debit_card : '5142850020531006',
			amex_credit_card : '371593210378043',
			cabal_credit_card : '6042011000007025'
		}
	}

	return ambiente;
}
```

Use:
```
user_example01.feature

...
...
  Background:
    * url ambiente.url
...
...

```



### TestRunner file

TestRunner file allow to configure the test executions:

Run all test:
```java
  @Karate.Test
  Karate testAll() {
    return Karate.run().relativeTo(getClass());
  }
```

Run specific test by tag:
```java
  @Karate.Test
  Karate testAll() {
    return Karate.run().tags("@SOME_TAG_HERE").relativeTo(getClass());
  }
```
**IMPORTANT: If you want to run by console, you have to write only one test runner configuration(anothers could be commented)**

## Run test by Eclipse IDE
For running test by IDE have to be in testrunner class and **right click** -> **Run As** -> **JUnit Test**



## Run test by console
Configure testrunner with:
```java
  @Karate.Test
  Karate testAll() {
    return Karate.run().relativeTo(getClass());
  }
```
Open command promt, go to project folder and run this command:
```
mvn clean verify -Dkarate.env=qa -Dkarate.options="--tags @SOME_TAG_HERE"
```
 
## Reports
Reports are in project folder **target\surefire-reports**













