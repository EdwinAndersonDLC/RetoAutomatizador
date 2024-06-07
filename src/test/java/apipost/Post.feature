Feature: test post

@POST
Scenario Outline: Test API con metodo POST
  Given url "http://localhost:5002/api/members"
  And header Authorization = "Basic YWRtaW46YWRtaW4="
  * configure charset = null
  And  request {"name":"<pname>","gender":"<pgender>" }
  When method POST
  Then status <STATUS>
  * print response


  Examples:
    | pname | pgender | STATUS |
    | tedst | male    | 201    |