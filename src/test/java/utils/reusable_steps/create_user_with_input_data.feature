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
    Given path path_user
    * header Accept = 'application/json'
    * header Content-Type = 'application/json'
    And request req_create_user
    When method post
    Then status 200
    And print response
    And match response == res_create_user
    