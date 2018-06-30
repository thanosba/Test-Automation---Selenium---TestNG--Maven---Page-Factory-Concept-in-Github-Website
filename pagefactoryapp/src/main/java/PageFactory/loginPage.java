/**
 * Created by thanos-imac on 30/6/18.
 */
package PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

    WebDriver driver;

    //verify text
    @FindBy(xpath = "//*[@id='login']/form/div[1]/h1")
    WebElement titleText;

    //Username or email address
    @FindBy(id="login_field")
    WebElement userNameEmail;

    //Password
    @FindBy(id="password")
    WebElement password;

    //btn login
    @FindBy(name="commit")
    WebElement login;

    public loginPage(WebDriver driver){
    this.driver = driver;
    //This initElements method will create all WebElements
    PageFactory.initElements(driver, this);
}

    public void setUserNameEmail(String strUserNameEmail){
        userNameEmail.sendKeys(strUserNameEmail);
  }

    public void setPassword(String strPassword){
      password.sendKeys(strPassword);
  }

    public void clickLogin(){
      login.click();
  }

    //Get the title of Login Page
    public String getLoginTitle(){
      return titleText.getText();
    }

    public void loginToPage(String strUserNameEmail,String strPasword){

        //Fill user name
        this.setUserNameEmail(strUserNameEmail);

        //Fill password
        this.setPassword(strPasword);

        //Click Login button
        this.clickLogin();
    }
}
