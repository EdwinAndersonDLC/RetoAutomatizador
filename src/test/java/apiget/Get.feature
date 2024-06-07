@METODOGET
Feature: TEST API GET

  @GET
  Scenario Outline:  Prueba de API con metod Get members
    Given url "http://localhost:5002/api/members/<id>"
    And header Accept = "application/json"
    And header Authorization = "Basic YWRtaW46YWRtaW4="
    When method GET
    Then status <status>
    * print response

    Examples:
      | id | status |
      | 1  | 200    |