package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends PageBase{
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id ="first-name")
    WebElement fName;
    @FindBy(id ="last-name")
    WebElement lName;
    @FindBy(id ="postal-code")
    WebElement zip;
    @FindBy(id ="continue")
    WebElement continueBtn;
    @FindBy(className = "summary_total_label")
    public WebElement totPrice;
    @FindBy(id = "finish")
    WebElement finishBtn;
    @FindBy(className = "complete-header")
    public WebElement messageSuccessfully;
    @FindBy(id = "back-to-products")
    WebElement BackHomeBtn;

    public void UserCanFillDataToCheckoutProducts(String firstname , String lastname , String postalCode)
    {
        sendTxt(fName,firstname);
        sendTxt(lName,lastname);
        sendTxt(zip,postalCode);
        clickButton(continueBtn);
    }
    public void UserCanFinishCheckoutStep()
    {
        clickButton(finishBtn);
    }
    public void UserCanNavigateToBackHome()
    {
        clickButton(BackHomeBtn);
    }
}
