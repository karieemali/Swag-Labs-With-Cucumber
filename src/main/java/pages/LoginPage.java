package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user-name")
    WebElement userName;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "login-button")
    WebElement loginBtn;

    public void UserCanAddElementLogin(String user , String pass)
    {
        sendTxt(userName,user);
        sendTxt(password,pass);
    }
    public void UserCanLogin()
    {
        clickButton(loginBtn);
    }
}
