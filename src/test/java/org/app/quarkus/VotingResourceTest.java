package org.app.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

@QuarkusTest
public class VotingResourceTest {

    @Test
    public void testVotingEndpoint() {
        given()
                .when().get("/voting/John/25")
                .then()
                .statusCode(200)
                .contentType(ContentType.TEXT)
                .body(containsString("Hello !, John You are eligible to vote!"));
    }

    @Test
    public void testUnderageEndpoint() {
        given()
                .when().get("/voting/Mary/17")
                .then()
                .statusCode(200)
                .contentType(ContentType.TEXT)
                .body(containsString("Hello !, Mary Sorry, you are not eligible to vote yet."));
    }
}
