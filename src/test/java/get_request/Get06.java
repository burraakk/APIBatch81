package get_request;

import base_url.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;
import static junit.framework.TestCase.*;
import static org.hamcrest.Matchers.*;

public class Get06 extends RestfulBaseUrl {
    /*
       Given
           https://restful-booker.herokuapp.com/booking/22
       When
           User send a GET request to the URL
       Then
           HTTP Status Code should be 200
       And
           Response content type is "application/json"
       And
           Response body should be like;
   {
    "firstname": "Jim",
    "lastname": "Brown",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {                   //OUTER JSON
        "checkin": "2018-01-01",        //INNER JSON
        "checkout": "2019-01-01"        //INNER JSON
    },
    "additionalneeds": "Breakfast"
}
    */


    @Test
    public void get01() {
        //  Set the URL
        spec.pathParams("first","booking","second",13);

        //  Expected Data

        //  Send the request and Get Response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //  Do Assertion
        //1.Yol
        response.then().assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname",equalTo("Kimie"),
                        "lastname",equalTo("Jackie"),
                        "totalprice",equalTo(111),
                        "depositpaid",equalTo(true),
                        "bookingdates.checkin",equalTo("2018-01-01"),
                        "bookingdates.checkout",equalTo("2019-01-01"),
                        "additionalneeds",equalTo("Breakfast"));

        //2.Yol : JsonPath class'ının kullanımı
        JsonPath json = response.jsonPath();

        assertEquals("Kimie",json.getString("firstname"));
        assertEquals("Jackie",json.getString("lastname"));
        assertEquals(111,json.getInt("totalprice"));
        assertEquals(true, json.getBoolean("depositpaid"));
        assertEquals("2018-01-01",json.getString("bookingdates.checkin"));
        assertEquals("2019-01-01",json.getString("bookingdates.checkout"));
        assertEquals("Breakfast",json.getString("additionalneeds"));


        //3.Yol : Soft Assert kullanımı
        //softAssert classı 3 adımda kullanılır

        //i)Obje oluşturma
        SoftAssert softAssert = new SoftAssert();

        //ii)Do Assertion
        softAssert.assertEquals(json.getString("firstname"),"Kimie","Firstname hatali");
        softAssert.assertEquals(json.getString("lastname"),"Jackie","Lastname hatali");
        softAssert.assertEquals(json.getInt("totalprice"),133,"Totalprice hatali");
        softAssert.assertEquals(json.getBoolean("depositpaid"),true,"Depositpaid hatali");
        softAssert.assertEquals(json.getString("bookingdates.checkin"),"2018-01-05","Checkin hatali");
        softAssert.assertEquals(json.getString("bookingdates.checkout"),"2019-01-01","Checkout hatali");
        softAssert.assertEquals(json.getString("additionalneeds"),"Breakfast","Additionalneeds hatali");
        softAssert.assertAll();   //BUNU YAZMAZSAN HEPSİ GEÇER

        /*iii) Dogrulama islemleri sonunda softAssert.assertAll() diyerek
               yaptigimiz tum dogrulama islemlerinin kontrol edilmesini sagliyoruz.
               Eger islemin sonunda softAssert.assertAll() kullanmaz isek
               taleplerimiz hatalı bile olsa testimiz pass olacaktir.
        */



    }
}
