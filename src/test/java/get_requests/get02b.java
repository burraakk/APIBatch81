package get_requests;

import base_urls.ReqresBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class get02b extends ReqresBaseUrl {
     /*
   Given
       https://reqres.in/api/users/23
   When
       User send a GET Request to the url
   Then
       HTTP Status code should be 404
   And
       Status Line should be HTTP/1.1 404 Not Found
   And
       Server is "cloudflare"
   And
       Response body should be empty

*/

    @Test
    public void get02() {
        //  Set the URL
        spec.pathParams("first","users","second",23);

        //  Expected Data

        //  Send the request and Get the Response
        Response response = given().spec(spec).when().get("{first}/{second}");
        response.prettyPrint();

        //  Do Assertion

        //       HTTP Status code should be 404
        assertEquals(404,response.getStatusCode());
        //       Status Line should be HTTP/1.1 404 Not Found
        assertEquals("HTTP/1.1 404 Not Found",response.getStatusLine());
        //       Server is "cloudflare"
        assertEquals("cloudflare",response.getHeader("Server"));
        //       Response body should be empty
        assertEquals(0,response.asString().replaceAll("[^A-Za-z0-9]","").length());
    }
}
