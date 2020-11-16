package SanityTests;

import Extensions.uiActions;
import Extensions.verifications;
import Utllities.commonOps;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.*;

import java.util.Random;

@Listeners(Utllities.listeners.class)
public class nopCommerceWeb extends commonOps
{

    @Test(description = "Test 01: Register to NopCommerce")
    @Description("Test Description: Create a new user in NopCommerce Web Application")
    public void test01_register() throws InterruptedException
    {
        webFlows.register(getData("FirstName"),getData("LastName"), new Random().nextInt()+"@gmail.com",getData("Password"));
        verifications.visibleText(nopCommerceRegisterPage.txt_registrationConfirmation,"Your registration completed");
}

    @Test(description = "Test 02: Add Item to Cart")
    @Description("Test Description: Add a new Item to NopCommerce Web Application Shopping cart")
    public void test02_addToCart() throws InterruptedException
    {
        webFlows.addItemToCart();
        verifications.numberOfElements(nopCommerceShoppingCartPage.rows,1);
    }
    @Test(description = "Test 03: Remove Item from Cart ")
    @Description("Test Description: Remove Item from NopCommerce Web Application Shopping cart")
    public void test03_RemoveFromCart() throws InterruptedException
    {
        webFlows.addItemToCart();
        uiActions.mouseHoverElements(nopCommerceUpperBarPage.lnk_shopingCart,nopCommerceUpperBarPage.btn_goToCart);
        uiActions.click(nopCommerceShoppingCartPage.box_removeProductBox);
        uiActions.click(nopCommerceShoppingCartPage.btn_updateShoppingCart);
        verifications.visibleText(nopCommerceShoppingCartPage.txt_emptyShoppingCart,"Your Shopping Cart is empty!");
    }
    @Test(description = "Test 04: Sorting Items")
    @Description("Test Description: Sorting Items in NopCommerce Web Application")
    public void test04_sortBy() throws InterruptedException
    {
        String[] expItems = new String[]{getData("expectedItem1"), getData("expectedItem2"), getData("expectedItem3")};
                webFlows.sortItemsBy(getData("SortingMethod"));
        for (int i = 0; i < nopCommerceCellPhonesPage.lst_itemGrid.size(); i++)
        {
            assertEquals(expItems[i],nopCommerceCellPhonesPage.lst_itemGrid.get(i).getText());
        }
    }
    @Test(description = "Test 05: Empty Search Pop-Up Alert")
    @Description("Test Description: Verified Empty Search Pop-Up Alert When Search Field is Empty")
    public void test05_emptySearchPopup() throws InterruptedException
    {

        uiActions.clearText(nopCommerceUpperBarPage.txt_searchStore);
        uiActions.click(nopCommerceUpperBarPage.btn_search);
        popup = driver.switchTo().alert();
        String popupText = popup.getText();
        try
        {
            verifications.visibleTextString(popupText, "Please enter some search keyword");
        } catch (Exception e)
        {
            fail();
        } finally
        {
            popup.accept();
        }
    }

    @Test(description = "Test 06: Verify NopCommerce Logo")
    @Description("Test Description: Verify NopCommerce default Logo ")
    public void test06_verifyLogo() throws InterruptedException
        {
            verifications.visualElement(nopCommerceUpperBarPage.img_logo,"nopCommerceLogo_ver01");
        }

    @Test(description = "Test07: Verify Elements Location By Y Axis")
    @Description("Test Description: Verify NopCommerce top-menu Element Location By Y Axis")
    public void test07_verifyYaxis()
    {
        for (int i = 1; i < nopCommerceHeaderMenu.lnk_topmenu.size(); i++)
        {
           assertEquals(nopCommerceHeaderMenu.lnk_topmenu.get(i-1).getLocation().getY(), nopCommerceHeaderMenu.lnk_topmenu.get(i).getLocation().getY());
        }
    }
}

