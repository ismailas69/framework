package stepdefinitions;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Pojo;

import static io.restassured.RestAssured.given;

public class ApiTesting {
    Pojo pojo = new Pojo();
    @Test
    public void get01(){

//        Set the Url
        String endpoint = "https://catfact.ninja/fact";

//        Set expected data

//        Send the GET request and get response

        Response response = given().when().get(endpoint);
        response.prettyPrint();
        Pojo pojo = response.as(Pojo.class);
        System.out.println("length = " + pojo.getLength());
//        Do validation

        response.then().assertThat().statusCode(200);
    }
    //Test commit
}
