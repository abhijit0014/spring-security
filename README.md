## Spring Security 6

**Authentication** – it’s about validating the received credentials; it’s where we verify that both username and password match the ones that our application recognizes

**Authorization** –it’s about verifying if the successfully authenticated user has permissions to access a certain functionality of the application


### Spring security 6 endpoints

#### Signup
````
POST - http://localhost:5151/signup
{
    "username" : "Ovi",
    "password" : "Ovi@1234"
}
````
#### Login
````
GET - http://localhost:5151/login
{
    "username": "Ovi",
    "password": "Ovi@1234"
}
output - JwtToken
eyJ0eXAiOiJqd3QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJPdmkiLCJpYXQiOjE3Mzc3ODAwMjksImV4cCI6MTczNzc4MDMyOX0.jpFhqpkPrmV7saiYauHJ0bl6MO9ooINpR06vcwJeVV4
````

### Dependency
````
<!-- JJWT -->
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.12.3</version>
</dependency>

<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-impl</artifactId>
    <version>0.12.3</version>
    <scope>runtime</scope>
</dependency>

<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-jackson</artifactId>
    <version>0.12.3</version>
    <scope>runtime</scope>
</dependency>
````