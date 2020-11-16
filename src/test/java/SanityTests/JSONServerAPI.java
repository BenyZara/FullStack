package SanityTests;

import Extensions.verifications;
import Utllities.commonOps;
import WorkFlows.apiFlows;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import java.util.Random;

public class JSONServerAPI extends commonOps
{

    @Test(description = "Test 01: Add Section and Verify it")
    @Description("Test Description: Add Section to JSON Server and Verify it")
    public void test01_addSectionAndVerify() throws InterruptedException
    {
        apiFlows.postSection("NewTitle","NewAuthor");
        verifications.text(String.valueOf(response.getStatusCode()),"201");
    }
    @Test(description = "Test 02: Get property From JSON Server")
    @Description("Test Description: Get property from List From JSON Server")
    public void test02_getProperty() throws InterruptedException
    {
        verifications.text(apiFlows.getListProperty("title[0]"),"NewTitle");

    }
    @Test(description = "Test 03: Update Section and Verify it")
    @Description("Test Description: Update Section to JSON Server and Verify it")
    public void test03_updateSectionAndVerify() throws InterruptedException
    {
        apiFlows.updateSection("NewUpdateTeam","NewUpdateAuthor","1");
        verifications.text(apiFlows.getListProperty("author[0]"),"NewUpdateAuthor");
    }
    @Test(description = "Test 04: Delete Section and Verify it")
    @Description("Test Description: Delete Section in JSON Server and Verify it")
    public void test04_deleteSectionAndVerify() throws InterruptedException
    {
        apiFlows.deleteSection("1");
        verifications.text(String.valueOf(response.getStatusCode()),"200");

    }

}
