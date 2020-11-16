package WorkFlows;

import Extensions.uiActions;
import Utllities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class mobileFlows extends commonOps
{
    @Step("Search for Item ")
    public static void searchForItem() throws InterruptedException
    {
        uiActions.click(nop4YouMobileHeaderBar.btn_magnifyingGlass);
        uiActions.updateText(nop4YouMobileHeaderBar.txt_searchInput,getData("searchInput"));
        uiActions.click(nop4YouMobileHeaderBar.btn_search);
    }
}
