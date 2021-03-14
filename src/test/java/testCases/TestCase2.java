package testCases;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase2 {

    @Test
    void createEmployeeRecord(){

        //specify base URI
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

        //Request Object
        RequestSpecification httpRequest = RestAssured.given();

        //Request Payload sending along with Post Request
        JSONObject requestParams = new JSONObject();
        requestParams.put("name","test");
        requestParams.put("salary","123");
        requestParams.put("age","23");

        httpRequest.header("Content-Type", "application/json");

        httpRequest.body(requestParams.toJSONString());

        //Response Object
        Response response = httpRequest.request(Method.POST,"/create");

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: "+responseBody);

        //Status code validation
        int statusCode = response.statusCode();
        System.out.println("Status code: "+statusCode);
        Assert.assertEquals(statusCode,200);

        //Status line verification
        String statusLine = response.statusLine();
        System.out.println("Status Line: "+statusLine);
        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");

        //Status validation
        String statusFromResponse = response.jsonPath().get("status");
        Assert.assertEquals(statusFromResponse,"success");
        System.out.println(statusFromResponse);
    }
}
