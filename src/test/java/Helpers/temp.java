package Helpers;

import org.json.simple.JSONObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class temp
{
    String url = "http://localhost:3000";
    RequestSpecification httpRequest;
    Response response;

    @Test
    public void testing()
    {
        JSONObject params = new JSONObject();
        params.put("title", "ATeamBeny");
        params.put("author", "Beny1");
        RestAssured.baseURI = url;
        httpRequest = RestAssured.given();
        httpRequest.header("Content-Type","application/json");

        httpRequest.body(params.toJSONString());
        response = httpRequest.post("/posts");
        params.put("title", "ATeamBenyUpdate");
        params.put("author", "BenyUpdate");
        httpRequest.body(params.toJSONString());
        response = httpRequest.put("/posts/1");
        response = httpRequest.delete("/posts/1");

        response.prettyPrint();
    }
}
