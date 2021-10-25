Feature: Ejemplo de prueba con pet

@ejemplo
Scenario: VAlidar otp

    Given url 'https://petstore.swagger.io/v2/user'
    * def req_body = read('../request/create_user.json')
    # * set req_body.username = util.random_string(5)
    And request req_body
    When method post
    Then status 200
    * print response