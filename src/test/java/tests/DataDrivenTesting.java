package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;

public class DataDrivenTesting {
//@DataProvider(name = "PostingData")
    public Object[][] dataForPost(){
    //Matrix style : Rows & Column
//        Object[][] data = new Object[2][3];
//
//        data[0][0] = "Sachin";
//        data[0][1] = "Tendulkar";
//        data[0][2] = 1;
//        data[1][0] = "Rohit";
//        data[1][1] = "Sharma";
//        data[1][2] = 2;
//
//        return data;
    //JSON style
    return new Object[][]{
            {"KL","Rahul",1},
            {"Rishabh","Pant",2}
    };
    }
   // @Test(dataProvider = "PostingData")
    public void post(String firstName,String lastName,int subjectID) {
        baseURI = "http://localhost:3000";
        JSONObject request = new JSONObject();
        request.put("firstName", firstName);
        request.put("lastName", lastName);
        request.put("subjectId", subjectID);

        given().contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("/users").
                then().
                statusCode(201).log().all();
    }
    @DataProvider(name="DataForDeleting")
    public Object[][] dataForDelete(){
    return new Object[][]{
            {7,8}

    };
    }
    @Test(dataProvider = "DataForDeleting")
    public void testDelete(int userId){
        baseURI = "http://localhost:3000";
         when().delete("/users/" +userId).then().statusCode(200).log().all();
         //Status Code is 200/204 when data is successfully deleted

    }
}

