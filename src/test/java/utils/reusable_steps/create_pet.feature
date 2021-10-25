Feature: Reusable create user steps

  Background:
    #carga request
    * def req_create_pet = read('../../petstore/request/create_pet.json')
    #carga response
    * def res_create_pet = read('../../petstore/response/create_pet.json')
    * def res_get_pet = read('../../petstore/response/get_pet.json')
    #carga clase java utils
    * def utils_class = Java.type('utils.util')
    * def util = new utils_class()


  Scenario: Create pet with random data
  	* set req_create_pet.id = util.random_number(10)
    * set req_create_pet.name = util.random_string(5)
    * set req_create_pet.status = constants.user_status.active

    Given url ambiente.url
    And path path_pet
    And header Content-Type = 'application/json'
    And request req_create_pet
    When method post
    Then status 200
    And print response
    And match response == res_create_pet
    