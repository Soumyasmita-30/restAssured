package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
//import static org.apache.commons.codec.digest.UnixCrypt.body;
import static org.hamcrest.Matchers.*;


public class GetAndPostExamples {
//@Test
    public void testGet(){
        baseURI = "https://reqres.in/api";
        //Checking if the first name is equal to George
        given().
                get("/users?page=2").
                then().
                statusCode(200).
                //Checking if the first name is equal to George
        body("data[4].first_name",equalTo("George")).
        body("data.first_name",hasItems("George", "Rachel"));//checcking if first_name parameters has george and rachel
    }
   // @Test
    public void testPut_1(){
        // Basic step by step setup using Map
        Map<String,Object> map = new HashMap<String,Object>();//LinkedHashMap to follow insertion order
        map.put("name","soumya");
        map.put("job","trainer");
        System.out.println(map);
    }
    //json simple lib
    @Test
    public void testPut_2(){
        JSONObject request = new JSONObject();
        request.put("name","Raju");
        request.put("job","Trainer");
        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in/api";
        given().

                header("Content-Type","application/json").
                contentType(ContentType.JSON).//explicitely telling the server that content-type is JSON
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("/users").
                then().
                //status code for successful creation is 201
                statusCode(201).
                log().all();

    }

}
