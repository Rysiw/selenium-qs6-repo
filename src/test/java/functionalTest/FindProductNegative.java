package functionalTest;

import hotlinePages.ProductPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Log4Test;

/**
 * Created by Ruslan on 11/9/14.
 */
public class FindProductNegative extends FunctionalTest {
    private static final By INCORRECT_ITEM = By.className("sabj");

    @DataProvider
    public Object[][] searchData() {
        return new Object[][] {
                new Object[] {"#$%"},
        };
    }

    @Test(dataProvider = "searchData")
    public void findProductNegative(String searchItem) throws InterruptedException {
        Log4Test.info("Test FindProductNegative is started");
        Log4Test.info("Search for Item");
        ProductPage.findProduct(driver, searchItem);
        Thread.sleep(5000);
        Assert.assertTrue(driver.findElement(INCORRECT_ITEM).isDisplayed(), Log4Test.info("Product wasn't found."));
        Log4Test.info("Item wasn't found. Test FindProductNegative passed successful");
    }
}