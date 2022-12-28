package com.petstore.crudtest;

import com.petstore.model.UserPojo;
import com.petstore.testbase.BaseTest;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserCrudTest extends BaseTest {
    @Test
    public void getAllProductsInfo() {
        Response response = given()
                .baseUri("https://petstore.swagger.io/v2/user/login")
                .when()
                .get("");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void createProduct() {

        UserPojo userPojo = new UserPojo();
        userPojo.setId(100);
        userPojo.setUsername("guest2");
        userPojo.setPassword("welcome");
        userPojo.setFirstName("abc");
        userPojo.setLastName("abc");
        userPojo.setEmail("abc" + getRandomValue() + "@gmail.com");
        userPojo.setPhone("01923562545");
        userPojo.setUserStatus(10);


        Response response = given()
                .baseUri("https://petstore.swagger.io/v2/user")
                .header("Content-Type", "application/json")
                .header("accept", "application/json")
                .when()
                .body(userPojo)
                .post();
        response.then().log().all().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleProductInfo() {

        Response response = given()
                .baseUri("https://petstore.swagger.io/v2/user/guest2")
                .header("Content-Type", "application/json")
                .header("accept", "application/json")
                .when()
                .get("");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test

    public void verifyUserUpdatedSuccessfully() {


        UserPojo userPojo = new UserPojo();
        userPojo.setId(101);
        userPojo.setUsername("guest2");
        userPojo.setPassword("welcome");
        userPojo.setFirstName("abcd");
        userPojo.setLastName("abcd");
        userPojo.setEmail("abcd" + getRandomValue() + "@gmail.com");
        userPojo.setPhone("01923562545");
        userPojo.setUserStatus(20);
        Response response = given()
                .baseUri("https://petstore.swagger.io/v2/user/guest2")
                .header("Content-Type", "application/json")
                .header("accept", "application/json")
                .when()
                .body(userPojo)
                .put();
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void deleteUser() {
        Response response = given()
                .baseUri("https://petstore.swagger.io/v2/user/guest2")
                .header("Content-Type", "application/json")
                .header("accept", "application/json")
                .when()
                .delete();
        response.then().statusCode(200);
        response.prettyPrint();
    }


}
