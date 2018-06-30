/**
 * Created by thanos-imac on 30/6/18.
 */
package test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageFactory.loginPage;
import PageFactory.homePage;

public class testLogin {
    WebDriver driver;
    loginPage objLogin;
    homePage  objHomePage;

    @BeforeTest

    public void setup(){

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.github.com");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div/span/div/a[1]")).click();
        waitForLoad(driver);
    }

    @Test(priority = 0)

    public void testHomePageAppear() throws InterruptedException {

        //TC01
        //Create Login Page object
        objLogin = new loginPage(driver);
        //Verify login page title
        String loginPageTitle = objLogin.getLoginTitle();
        Assert.assertTrue(loginPageTitle.contains("Sign in to GitHub"));
        //login to application
        objLogin.loginToPage("add here your email", "add here your password");

        //TC02
        // go the next page
        objHomePage = new homePage(driver);
        //Verify home page
        driver.findElement(By.xpath("//*[@id='user-links']/li[3]/details/summary/img")).click();
        Thread.sleep(8000);
        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().contains("add here your user name"));

    }

    @AfterTest
    public void afterTest() {
        driver.close();
        driver.quit();
    }
    public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(pageLoadCondition);
    }
}
