package get_requests;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static junit.framework.TestCase.*;

public class Get07 extends JsonplaceholderBaseUrl {
     /*
      Given
       https://jsonplaceholder.typicode.com/todos
When
    I send GET Request to the URL
Then
    1)Status code is 200
    2)Print all ids greater than 190 on the console
      Assert that there are 10 ids greater than 190
    3)Print all userIds whose ids are less than 5 on the console
      Assert that the number of userIds whose ids are less than 5 is 4
    4)Print all titles whose ids are less than 5
      Assert that "delectus aut autem" is one of the titles whose id is less than 5

   */

    @Test
    public void get01() {
        //  Set the URL
        spec.pathParam("first","todos");

        //  Expected Data

        //  Send the request and Get the Response
        Response response = given().spec(spec).when().get("/{first}");

        //  Do Assertion

        // 1)Status code is 200
        response.then().assertThat().statusCode(200);
        //response.prettyPrint();

        // 2)Print all ids greater than 190 on the console
        JsonPath json = response.jsonPath();
        List<Integer> idler = json.getList("findAll{it.id>190}.id");  //Groovy Language : JAVA temelli programlama dili
        System.out.println("ID'si 190dan buyuk olanlar : " + idler);

        // Assert that there are 10 ids greater than 190
        assertEquals("ID 190dan buyuk olanlar eslesmedi",10,idler.size());

        // 3)Print all userIds whose ids are less than 5 on the console
        List<Integer> userIds = json.getList("findAll{it.id<5}.userId");
        System.out.println("UserId'si 5'ten kucuk olanlar : " + userIds);

        // Assert that the number of userIds whose ids are less than 5 is 4
        assertEquals("Id'si 5'ten kucuk olan user id'ler 4 tane degil",4,userIds.size());

        // 4)Print all titles whose ids are less than 5
        List<String> titles = json.getList("findAll{it.id<5}.title");
        System.out.println("Id'si 5'ten kucuk olan title'lar : " + titles);

        // Assert that "delectus aut autem" is one of the titles whose id is less than 5
        assertTrue("Id'si 5ten kucuk olan title'lardan herhangi biri \"delectus aut autem\" icermemektedir",
                titles.contains("delectus aut autem"));

        assertTrue("Id'si 5ten kucuk olan title'lardan herhangi biri \"delectus aut autem\" icermemektedir",
                titles.stream().anyMatch(t->t.equals("delectus aut autem")));


    }
}
