package com.gorest.testbase;

import com.gorest.utils.TestUtils;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;

public class TestBase extends TestUtils {
    private static RequestSpecification spec;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2/users";
    }
}
