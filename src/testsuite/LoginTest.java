package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){

        //locate username field and enter valid username
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");

        //locate password field and enter valid password
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("admin123");

        //locate login button and click it
        WebElement logIn = driver.findElement(By.id("btnLogin"));
        logIn.click();

        //Verify the ‘Welcome’ text is display
        String expectedMessage = "Welcome";
        WebElement actualMessageElement = driver.findElement(By.id("welcome"));
        String actualMessage = actualMessageElement.getText().substring(0,7);
        Assert.assertEquals("Welcome",expectedMessage,actualMessage);


    }




    @After
    public void teardown(){
        closeBrowser();
    }

}
