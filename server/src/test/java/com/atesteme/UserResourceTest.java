package com.atesteme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
public class UserResourceTest {
    @Test
    public void testCreateUser() {
        given()
            .contentType("application/json")
            .body("{ \"name\": \"diego\", \"email\": \"diego@mail.com\", \"password\": \"Senha123!\", \"cep\": \"12345678\" }")
        .when()
            .post("/user")
        .then()
            .statusCode(201)
            .body("id", notNullValue())
            .body("name", equalTo("diego"))
            .body("email", equalTo("diego@mail.com"));
    }

    @Test
    public void testLoginUsuarioSucesso() {
        given()
            .contentType("application/json")
            .body("{ \"name\": \"diego\", \"email\": \"diego@mail.com\", \"password\": \"Senha123!\", \"cep\": \"12345678\" }")
        .when()
            .post("/user")
        .then()
            .statusCode(anyOf(is(201), is(409)));

        given()
            .contentType("application/json")
            .body("{ \"email\": \"diego@mail.com\", \"password\": \"Senha123!\" }")
        .when()
            .post("/auth")
        .then()
            .statusCode(200)
            .body("token", notNullValue());
    }

    @Test
    public void testGetMe() {
        given()
            .contentType("application/json")
            .body("{ \"name\": \"diego\", \"email\": \"diego@mail.com\", \"password\": \"Senha123!\", \"cep\": \"12345678\" }")
        .when()
            .post("/user")
        .then()
            .statusCode(anyOf(is(201), is(409)));
            
        given()
            .contentType("application/json")
            .body("{ \"email\": \"diego@mail.com\", \"password\": \"Senha123!\" }")
        .when()
            .post("/auth")
        .then()
            .statusCode(200)
            .body("token", notNullValue());

        given()
            .header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNzU4Mjc0NzI0LCJleHAiOjE3NTgyNzgzMjR9.aRADgvpnhhtM-Cknf5rZEYFLnAYq2PrM0kQMOvFgL-M")
        .when()
            .get("/user/me")
        .then()
            .statusCode(200)
            .body("name", equalTo("diego"))
            .body("email", notNullValue())
            .body("id", notNullValue());
    }
}
