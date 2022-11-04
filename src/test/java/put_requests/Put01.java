package put_requests;

import base_urls.JsonplaceholderBaseUrl;
import org.junit.Test;

public class Put01 extends JsonplaceholderBaseUrl {
    /*
    Given
     1) https://jsonplaceholder.typicode.com/todos/198
     2) {
             "userId": 21,
             "title": "Wash the dishes",
             "completed": false
           }
    When
I send PUT Request to the Url
 Then
      Status code is 200
      And response body is like   {
                   "userId": 21,
                   "title": "Wash the dishes",
                   "completed": false
                  }
 */

    @Test
    public void put01() {
        //1. Set The URL

        // 2. Set The Expected Data ( put, post, patch)

        // 3. Send The Request And Get The Response

        // 4. Do Assertion

    }
}
