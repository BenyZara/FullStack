package Extensions;

import Utllities.commonOps;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

public class apiActions extends commonOps
{
    @Step("Get Data From Server")
    public static Response get(String paramsValues)
    {
        response = httpRequest.get(paramsValues);
        return response;
    }

    @Step("Extract Value From JSON format")
    public static String extractFromJSON(Response response,String path)
    {
        jp = response.jsonPath();
        return jp.get(path).toString();
    }
    @Step("Post Data to Server")
    public static void post(JSONObject params, String resource)
    {
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.post(resource);
        response.prettyPrint();
    }
    @Step("Update Data in Server")
    public static void put(JSONObject params, String resource)
    {
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.put(resource);
        response.prettyPrint();
    }
    @Step("Delete Data to Server")
    public static void delete(String resource)
    {
        response = httpRequest.delete(resource);
        response.prettyPrint();
    }

}
