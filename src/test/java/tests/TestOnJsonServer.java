package tests;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class TestOnJsonServer {
   // @Test
    public void get(){
        baseURI = "http://localhost:3000";
        given().
                get("/users").
                then().
                statusCode(200).
                log().all();


    }
   // @Test
    public void post(){
        baseURI = "http://localhost:3000";
        JSONObject request = new JSONObject();
        request.put("firstName","Nikhil");
        request.put("lastName","Kumar");
        request.put("subjectId",2);

        given().contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("/users").
                then().
                statusCode(201);
    }
    //@Test
    public void put(){
        baseURI = "http://localhost:3000";
        JSONObject request = new JSONObject();
        request.put("firstName","Tanmay kumar");
        request.put("lastName","Das");
        request.put("subjectId",2);

        given().contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                put("/users/4").
                then().
                statusCode(200);
    }
   // @Test
    public void patch(){
        baseURI = "http://localhost:3000";
        JSONObject request = new JSONObject();
        request.put("firstName","Tanmay");

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                patch("/users/4").
                then().
                statusCode(200);
    }@Test
    public void delete(){
        baseURI = "http://localhost:3000";
        when().delete("users/5").then().statusCode(200);
    }
    }

