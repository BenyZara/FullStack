package SanityTests;

import Extensions.uiActions;
import Extensions.verifications;
import Utllities.commonOps;
import WorkFlows.mobileFlows;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.AssertJUnit.assertEquals;

@Listeners(Utllities.listeners.class)
public class nop4YouMobile extends commonOps
{
    @Test(description = "Test 01: Verify Search Results")
    @Description("Test Description: Enter search and verify its appereal in the search result ")
    public void test01_VerifySearchResults() throws InterruptedException
    {
        mobileFlows.searchForItem();
        String[] mobileExpItems = new String[]{getData("MobileExp1"), getData("MobileExp2"), getData("MobileExp3")};

        for (int i = 0; i < nop4YouMobileSearchResultsPage.lst_searchResults.size(); i++)
        {
            System.out.println(nop4YouMobileSearchResultsPage.lst_searchResults.get(i).getText());
            assertEquals(mobileExpItems[i],nop4YouMobileSearchResultsPage.lst_searchResults.get(i).getText());
        }

    }
    @Test(description = "Test 02: Verify currency change")
    @Description("Test Description: Change the currency of products")
    public void test02_VerifyCurrencyChange() throws InterruptedException
    {
        uiActions.click(nop4YouMobileHeaderBar.btn_menu);
        uiActions.click(nop4YouMobileLeftSideMenu.btn_settings);
        uiActions.click(nop4YouMobileSettingsPage.currencyField);
        for (int i = 0; i <nop4YouMobileSettingsPage.lst_currency.size() ; i++)
        {
            if (nop4YouMobileSettingsPage.lst_currency.get(i).getText().equalsIgnoreCase(getData("expCurrency")))
                uiActions.click(nop4YouMobileSettingsPage.lst_currency.get(i));
        }
        uiActions.click(nop4YouMobileHeaderBar.btn_menu);
        mobileFlows.searchForItem();
        verifications.visibleText(nop4YouMobileSearchResultsPage.priceItem,getData("PriceCurrency"));

    }
}
