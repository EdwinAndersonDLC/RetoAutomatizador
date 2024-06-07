@METODODELETE
Feature: Prueba API DELETE

  @DELETE
  Scenario Outline: Test API con metodo DELETE
    Given url "http://localhost:5002/api/members/<id>"
    And header Authorization = "Basic YWRtaW46YWRtaW4="
    When method DELETE
    Then status <STATUS>
    * print response

    Examples:
      | id | STATUS |
      | 10 | 200    |