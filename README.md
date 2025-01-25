POST - http://localhost:5151/signup
{
    "username" : "Ovi",
    "password" : "Ovi@1234"
}

GET - http://localhost:5151/login
{
    "username": "Ovi",
    "password": "Ovi@1234"
}
output - JwtToken
eyJ0eXAiOiJqd3QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJPdmkiLCJpYXQiOjE3Mzc3ODAwMjksImV4cCI6MTczNzc4MDMyOX0.jpFhqpkPrmV7saiYauHJ0bl6MO9ooINpR06vcwJeVV4
