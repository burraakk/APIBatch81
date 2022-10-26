package get_request;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.*;

public class Get02 {

    /* Given
    https://restful-booker.herokuapp.com/booking/1
    When
    User send a GET Request to the url
    Then
    HTTP Status code should be 404
    And
    Status Line should be HTTP/1.1 404 Not Found
    And
    Response body contains "Not Found"
    And
    Response body does not contain "TechProEd"
    And
    Server is "Cowboy"
    */

    @Test
    public void get01() {
        // i)  Set the URL,
        String url = "https://restful-booker.herokuapp.com/booking/1";

        //ii) Set the expected Data (beklenen datanin olusturulmasi, post, put, patch)
        //Bizden post, put ya da patch istenmedigi icin bu casede kullanilmayacak

        //iii) Type code to send request (Talep gondermek icin kod yazimi)
        Response response = given().when().get(url);
        response.prettyPrint();

        //iv) Do Assertion ()dogrulama yapmak
        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");

        //Body 'Not Found' içeriyor mu testi yapılıyor
        assertTrue(response.asString().contains("Not Found"));

        //Body'nin 'TechProEd' içermediği testi yapılıyor
        assertFalse(response.asString().contains("TechProEd"));

        //Server'ın 'Cowboy' olup olmadığı testi yapılıyor
        assertEquals("Cowboy", response.getHeader("Server"));

    }
}
