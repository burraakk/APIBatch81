package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

    public Map<String,Object> expectedDataMethod(Integer userId, String title, Boolean completed){

        Map<String,Object> expectedDataMap = new HashMap<>();   //SERIALIZATION
        if (userId != null){
            expectedDataMap.put("userId",userId);
        }

        if (title != null){
            expectedDataMap.put("title",title);
        }

        if (completed != null){
            expectedDataMap.put("completed",completed);
        }

        return expectedDataMap;
    }

    //Dinamik expected data methodu: Json bir datayı String bir container olarak return ediyor
    public String expectedDataInString(int userId, String title, boolean completed){

        String expectedData = "{\n" +
                "                 \"userId\": "+userId+",\n" +
                "                 \"title\": \""+title+"\",\n" +
                "                 \"completed\": "+completed+"\n" +
                "               }";

        return expectedData;
    }
}
