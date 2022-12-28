package com.petstore.testbase;

import com.petstore.utils.Utils;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class BaseTest extends Utils {
    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

    }
}
