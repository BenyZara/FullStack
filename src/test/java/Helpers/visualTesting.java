package Helpers;

import Utllities.commonOps;
import Utllities.helperMethods;
import org.testng.annotations.Test;

public class visualTesting extends commonOps
{
    @Test
    public void createScreenShot()
    {
        helperMethods.takeElementScreenShot(nopCommerceUpperBarPage.img_logo,"nopCommerceLogo_ver01");
    }
}
