package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully(){

        //locate ‘Forgot your password’ link and click
        WebElement forgotPass = driver.findElement(By.xpath("//a[contains(text(),'Forgot your password?')]"));
        forgotPass.click();

        // Verify the text ‘Forgot Your Password?’
        String expectedMessage = "Forgot Your Password?"; //expected message
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Forgot Your Password?')]"));
        String actualMessage = actualMessageElement.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }


    @After
    public void teardown(){
        closeBrowser();
    }
}
