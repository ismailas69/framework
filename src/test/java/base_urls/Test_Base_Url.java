package base_urls;

import io.cucumber.java.Before;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import utilities.ConfigurationReader;

public class Test_Base_Url {

    public RequestSpecification spec;

    @Before
    protected void setUp(){
        RequestSpecification spec = new RequestSpecBuilder().setBaseUri("type base url here").build();

        spec.pathParams("first", "api", "second", "authenticate");

//        spec = new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("base_url")).build();
    }
}
