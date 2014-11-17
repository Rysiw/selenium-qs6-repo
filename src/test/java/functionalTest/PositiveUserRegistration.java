package functionalTest;

import tools.EmailGenerator;
import hotlinePages.HomePage;
import hotlinePages.RegisterPage;
import hotlinePages.RegisterSuccessPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Log4Test;

/**
 * Created by Ruslan on 11/2/14.
 */
public class PositiveUserRegistration extends FunctionalTest{

    @DataProvider
    public Object[][] registerPositiveData() {
        return new Object[][] {
                new Object[] {EmailGenerator.emailGenerator("user", "@gmail.com"),"user", "Qwerty123","Qwerty123"},
        };
    }

    @Test(dataProvider = "registerPositiveData")
    public void registerUserTestPositive(String email, String regName, String password, String passwordRepeat) throws InterruptedException {
        Log4Test.info("Test PositiveUserRegistration is started");
        HomePage.openRegisterPage(driver);
        RegisterPage.registerNewUser(driver, email, regName, password, passwordRepeat);
        Assert.assertTrue(RegisterSuccessPage.successRegister(driver), Log4Test.info("Welcome to HotLine. Register is success"));
        Log4Test.info("New User was registered. Test PositiveUserRegistration passed successful");

    }

}
