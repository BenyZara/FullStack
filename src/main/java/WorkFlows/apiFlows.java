package WorkFlows;

import Extensions.apiActions;
import Utllities.commonOps;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class apiFlows extends commonOps
{
    @Step("Get property From Server")
    public static String getListProperty(String jPath)
    {
        Response response = apiActions.get("/posts");
        return apiActions.extractFromJSON(response, jPath);
    }
    @Step("Create new section to Server")
    public static void postSection(String title,String author)
    {
        requestParams.put("title", title);
        requestParams.put("author", author);
        apiActions.post(requestParams,"/posts");
    }
    @Step("Update section in Server")
    public static void updateSection(String title,String author,String id)
    {
        requestParams.put("title", title);
        requestParams.put("author", author);
        apiActions.put(requestParams,"/posts/" + id);
    }
    @Step("Delete section in Server")
    public static void deleteSection(String id)
    {
        apiActions.delete("/posts/" +id);
    }
}
