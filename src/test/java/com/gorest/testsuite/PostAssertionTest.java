package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostAssertionTest {

    static ValidatableResponse response;
    @BeforeClass
    public static void inIT() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        response = given()
                // response = given()
                .when()
                .queryParam("page", "1")
                .queryParam("per_page", "25")
                .get("/posts")
                .then().statusCode(200);


    }
//Verify the if the total record is 25

    @Test
    public void test001(){
        response.body("total.size", equalTo(25));

    }
// Verify the if the title of id = 2730 is equal to ”Ad ipsa coruscus ipsam eos demitto
//centum.”
    @Test
    public void test002(){
        response.body("find{it.id == 2730}.title",equalTo("Ad ipsa coruscus ipsam eos demitto centum."));
    }

    //Check the single user_id in the Array list (5522
@Test
    public void test003(){
        response.body("user_id",hasItem(5522));

    }

// Check the multiple ids in the ArrayList (2693, 2683,2674)

    @Test
    public void test004(){
       response.body("id",hasItems(2693, 2683,2674)) ;

    }


//Verify the body of userid = 2730 "Quo celebrer adipisci. Delinquo audeo virga. Vel utilis despirmatio. Convoco alii tracto. Amicitia volo iste. Beneficium amissio armarium. Turpe torrens pax. Et qui nesciunt. Bellum vesper strues. Cornu consequatur supplanto. Contabesco conforto alii. Celo bellicus universe. Paulatim temporibus ut. Vestigium defigo vilitas. Sit damno celo. Despirmatio laborum commemoro."

    @Test
    public void test005(){
        response.body("find{it.id ==2730}.body",equalTo("Amor debilito et. Magni combibo claro. Administratio comitatus voveo. Suadeo suggero cervus. Ubi crudelis similique. Abeo tactus possimus. Auctus adeo depono. Thermae verbera condico. Communis bis complectus. Defleo spoliatio demo. Clamo coruscus truculenter. Claudeo depereo peior. Curriculum abeo triduana. Vix auxilium amita. Desolo vultuosus strues. Aedificium supellex aperte. Ver toties vel. Cura asperiores vobis. Sit theca cupio. Cresco distinctio ad."));

    }


}
