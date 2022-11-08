package delete_requests;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import utils.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Delete01 extends JsonplaceholderBaseUrl {
     /*
        Given
            https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send DELETE Request to the Url
	 	Then
		 	Status code is 200
		 	And Response body is { }
     */

    @Test
    public void delete01() {
        spec.pathParams("first","todos","second",198);

        Map<String,String> expextedData = new HashMap<>();
        System.out.println("expextedData = " + expextedData);

        Response response = given().spec(spec).when().delete("/{first}/{second}");
        response.prettyPrint();

        Map actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), Map.class);
        System.out.println("actualData = " + actualData);

        // 1. Yol
        assertEquals(expextedData,actualData);

        // 2. Yol
        assertTrue(actualData.isEmpty());

        // 3. Yol
        assertEquals(0,actualData.size());

    }
}
