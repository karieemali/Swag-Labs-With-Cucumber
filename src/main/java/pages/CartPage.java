package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageBase{
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    public WebElement titleCartPage;
    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeFirstProd;
    @FindBy(id = "remove-sauce-labs-bike-light")
    WebElement removeSecondProd;
    @FindBy(id = "remove-sauce-labs-bolt-t-shirt")
    WebElement removeThirdProd;
    @FindBy(id = "remove-sauce-labs-fleece-jacket")
    WebElement removeFourProd;
    @FindBy(id = "continue-shopping")
    WebElement continueShoppingBtn;
    @FindBy(id = "checkout")
    WebElement checkoutBtn;

    public void UserCanRemoveProducts()
    {
        clickButton(removeFirstProd);
        clickButton(removeSecondProd);
        clickButton(removeThirdProd);
        clickButton(removeFourProd);
        clickButton(continueShoppingBtn);
    }
    public void OpenCheckOutPage()
    {
        clickButton(checkoutBtn);
    }
}
