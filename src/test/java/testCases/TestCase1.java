package testCases;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase1 {

    @Test
    void getEmployeeDetails(){
        //specify base URI
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

        //Request Object
        RequestSpecification httpRequest = RestAssured.given();

        //Response Object
        Response response = httpRequest.request(Method.GET,"/employee/1");

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
    }
}
