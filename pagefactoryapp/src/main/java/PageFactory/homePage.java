/**
 * Created by thanos-imac on 30/6/18.
 */
package PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    public class homePage {

    WebDriver driver;

    @FindBy(xpath="//*[@id='user-links']/li[3]/details/ul/li[1]")

    WebElement homePageUserName;

    public homePage(WebDriver driver){
        this.driver = driver;
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    //Get the User name from Home Page
    public String getHomePageDashboardUserName(){
        return    homePageUserName.getText();

    }
}
