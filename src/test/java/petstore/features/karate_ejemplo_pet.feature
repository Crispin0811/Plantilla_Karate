@pet_ejemplos
Feature: Pet
  As a user
  I want to register pets
  So I can buy petstore services

  Background: Carga de variables
    # carga request
    * def req_create_pet = read('../request/create_pet.json')
    # carga response
    * def res_create_pet = read('../response/create_pet.json')
    * def res_get_pet = read('../response/get_pet.json')
    # carga clase java utils
    * def utils_class = Java.type('utils.util')
    * def util = new utils_class()

  @pet_ejemplo_01
  Scenario: Create a pet - Request hardcode
    Given url ambiente.url
    And path path_pet
    And header Content-Type = 'application/json'
    # Definiendo un request de manera fija por código
    And request '{"id": 14152, "name": "Pluto","status": "available"}'
    When method post
    Then status 200
    And print response
    And match response == {"id": #number,"name": "#string","photoUrls": [],"tags": [],"status": "#string"}

  @pet_ejemplo_02
  Scenario: Create a pet - Request hardcode modificando campos de un request base
  # Definiendo valores fijos del request modificando campos del request base desde file
    * set req_create_pet.id = 141523
    * set req_create_pet.name = 'Mars'
    * set req_create_pet.status = 'available'

    Given url ambiente.url
    And path path_pet
    And header Content-Type = 'application/json'
    And request req_create_pet
    When method post
    Then status 200
    And print response
    # Validando el response desde la definición de un archivo con el schema
    And match response == res_create_pet
    
  @pet_ejemplo_03
  Scenario: Create a pet - Data Random
    # Implementación de utilitario para generación de datos aleatorios
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



