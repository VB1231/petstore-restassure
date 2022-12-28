package com.petstore.crudtest;

import com.petstore.model.PetPojo;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PetUserTest {
    @Test
    public void getAllProductsInfo() {
        Response response = given()
                .baseUri("https://petstore.swagger.io/v2/pet/100")
                .when()
                .get("");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void createProduct() {

        PetPojo petPojo = new PetPojo();
        petPojo.setId(101);
        petPojo.setName("pluto");
        petPojo.setStatus("avilable");

        Response response = given()
                .baseUri("https://petstore.swagger.io/v2/pet")
                .header("Content-Type", "application/json")
                .header("accept", "application/json")
                .when()
                .body(petPojo)
                .post();
        response.then().log().all().statusCode(200);
        response.prettyPrint();
    }

    @Test

    public void verifyUserUpdatedSuccessfully() {

        PetPojo petPojo = new PetPojo();
        petPojo.setId(101);
        petPojo.setName("garfield");
        petPojo.setStatus("avilable");
       List<String> courseList = new ArrayList<>();
        courseList.add("");
        courseList.add("");
        petPojo.setTags(courseList);
        List<String> courseList1 = new ArrayList<>();
        courseList1.add("");
        courseList1.add("");
        petPojo.setPhotourl(courseList1);
        List<String> courseList2 = new ArrayList<>();
        courseList.add("");
        courseList.add("");
        petPojo.setTags(courseList2);

        Response response = given()
                .baseUri("https://petstore.swagger.io/v2/pet")
                .header("Content-Type", "application/json")
                .header("accept", "application/json")
                .when()
                .body(petPojo)
                .put();
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void deleteUser() {
        Response response = given()
                .baseUri("https://petstore.swagger.io/v2/user/100")
                .header("Content-Type", "application/json")
                .header("accept", "application/json")
                .when()
                .delete();
        response.then().statusCode(404);
        response.prettyPrint();
    }


}
