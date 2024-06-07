
@METODOPUT
Feature: TEST API PUT

  @PUT
  Scenario Outline: Prueba de API con metodo put
    Given url 'http://localhost:5002/api/members/<id>'
    And header Content-Type = 'application/json'
    * configure charset = null
    And header Authorization = 'Basic YWRtaW46YWRtaW4='
    When request {"name": "<pname>","gender": "<pgender>"}
    And method PUT
    Then status <STATUS>
    * print response

    Examples:
      | id | pname | pgender | STATUS |
      | 3  | tedst | male    | 200    |
