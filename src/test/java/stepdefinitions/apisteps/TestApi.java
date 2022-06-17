package stepdefinitions.apisteps;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class TestApi {

    Response response;

    @Test
    public void getRequest(){
//  1. Set url endpoint
        String endpoint = "";
//  2. Set the expected data
//  3. Send the GET request and get the response
        Response response = given().when().get(endpoint);
        response.prettyPrint();
//  4. do the validation
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);

//                response.then().statusCode(200).contentType(ContentType.JSON).
//                body("data.employee_name",equalTo("Herrod Chandler")).
//                body("data.employee_salary",equalTo(137500)).
//                body("data.id",equalTo(7));
//
//       way 2
//
//        JsonPath json = response.jsonPath();
//        System.out.println(json.getString("data.employee_name"));
//        System.out.println(json.getInt("data.employee_salary"));
//
//        assertEquals("Herrod Chandler",json.getString("data.employee_name"));
//        assertEquals(137500,json.getInt("data.employee_salary"));
    }


    @Test
        public void postRequest() {
//  1. Set url endpoint
        String endpoint = " ";

//  2. Set the expected data
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("userId",55);
        expectedData.put("title", "Tidy your room");
        expectedData.put("completed",false);

//        //Set the expected data in pojo
//        Todo expectedData = new Todo(55, "Tidy your room",false);

//  3. Send the POST request and get the response
        response = given().contentType(ContentType.JSON).body(expectedData).when().post(endpoint);
        response.prettyPrint();
//  4. Do the validation expected vs Actual
        response.then().assertThat().statusCode(200);

        Map<String,Object> actualData = response.as(HashMap.class);

        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("completed"), actualData.get("completed"));
        assertEquals("data does not match",expectedData.get("id"), actualData.get("id"));

//        we get the actual data into our pojo
//        Todo actualData = response.as(Todo.class);
//        assertEquals(expectedData.getTitle(), actualData.getTitle());
//        assertEquals(expectedData.isCompleted(), actualData.isCompleted());
 }

}
