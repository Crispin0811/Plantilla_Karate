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
    * set req_create_user.username = 'user'+id
    * set req_create_user.firstName = util.random_string(8)
    * set req_create_user.lastName = util.random_string(8)
    * set req_create_user.email = util.random_email()
    * set req_create_user.password = ambiente.password
    * set req_create_user.phone = util.random_number(9)
    * set req_create_user.userStatus = 1
    Given path path_user
    * header Accept = 'application/json'
    * header Content-Type = 'application/json'
    And request req_create_user
    When method post
    Then status 200
    And print response
    And match response == res_create_user
    