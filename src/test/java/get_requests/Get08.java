package get_requests;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get08 extends JsonplaceholderBaseUrl {
    /*
    Given
       https://jsonplaceholder.typicode.com/todos/2
   When
       I send GET Request to the URL
   Then
       Status code is 200
       And "completed" is false
       And "userId" is 1
       And "title" is "quis ut nam facilis et officia qui"
       And header "Via" is "1.1 vegur"
       And header "Server" is "cloudflare"
       {
           "userId": 1,
           "id": 2,
           "title": "quis ut nam facilis et officia qui",
           "completed": false
       }
*/

    @Test
    public void get08() {
        //  Set the URL
        spec.pathParams("first","todos","second",2);

        //  Set The Expected Data  ==> Payload
        Map<String,Object> expectedData = new HashMap<>();   //SERIALIZATION
        expectedData.put("userId",1);
        expectedData.put("id",2);
        expectedData.put("title","quis ut nam facilis et officia qui");
        expectedData.put("completed",false);

        System.out.println("expectedData = " + expectedData);


        //  Send the request and Get the Response
        Response response = given().spec(spec).get("/{first}/{second}");
        response.prettyPrint();

        //  Do Assertion
        Map<String,Object> actualData =  response.as(HashMap.class);  //DE-SERIALIZATION
        System.out.println("actualData = " + actualData);

        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("id"), actualData.get("id"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("completed"), actualData.get("completed"));
        assertEquals(200,response.getStatusCode());
        assertEquals("1.1 vegur",response.header("Via"));
        assertEquals("cloudflare",response.header("Server"));

    }


    //=================================================================================
    //===============================D??NAM??K Y??NTEM====================================
    //=================================================================================
    @Test
    public void get08b() {
        //  Set the URL
        spec.pathParams("first","todos","second",2);

        //  Set The Expected Data  ==> Payload
        JsonPlaceHolderTestData objJsonPlc = new JsonPlaceHolderTestData();
        Map<String,Object> expectedData = objJsonPlc.expectedDataMethod(1,"quis ut nam facilis et officia qui",false);
        System.out.println("expectedData" + expectedData);

        //  Send the request and Get the Response
        Response response = given().spec(spec).get("/{first}/{second}");
        response.prettyPrint();

        //  Do Assertion
        Map<String,Object> actualData =  response.as(HashMap.class);  //DE-SERIALIZATION
        System.out.println("actualData = " + actualData);

        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("completed"), actualData.get("completed"));
        assertEquals(200,response.getStatusCode());
        assertEquals("1.1 vegur",response.header("Via"));
        assertEquals("cloudflare",response.header("Server"));

    }
}
