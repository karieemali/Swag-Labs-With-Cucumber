package pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends PageBase{
    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    public WebElement title;
    @FindBy(id = "react-burger-menu-btn")
    WebElement menu;
    @FindBy(id = "logout_sidebar_link")
    WebElement logoutBtn;
    @FindBy(className = "product_sort_container")
    WebElement sortList;
    @FindBy(xpath = "//*[@id=\"item_4_title_link\"]/div")
    public WebElement firstProdAse;
    @FindBy(xpath = "//*[@id=\"item_3_title_link\"]/div")
    public WebElement firstProdDes;
    @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div")
    public WebElement lowPrice;
    @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div")
    public WebElement highPrice;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addFirstProd;
    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement addSecondProd;
    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement addThirdProd;
    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    WebElement addFourProd;
    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon;
    @FindBy(id = "reset_sidebar_link")
    WebElement resetAppStateBtn;
    @FindBy(id = "react-burger-cross-btn")
    WebElement closeMenuBtn;

    public void UserCanLogout() throws InterruptedException {
        clickButton(menu);
        Thread.sleep(1000);
        clickButton((logoutBtn));
    }

    public void UserCanAddProducts()
    {
        clickButton(addFirstProd);
        clickButton(addSecondProd);
        clickButton(addThirdProd);
        clickButton(addFourProd);
        clickButton(cartIcon);
    }


    public void SelectOptionOrder(String sortOption)
    {
        Select select = new Select(sortList);
        select.selectByVisibleText(sortOption);
    }
    public void UserCanSortByAlphabeticInAscendingOrder() {
        Select select = new Select(sortList);
        select.selectByIndex(0);
    }
    public void UserCanSortByAlphabeticInDescendingOrder()
    {
        Select select = new Select(sortList);
        select.selectByIndex(1);
    }
    public void UserCanSortByLowPriceOrder() throws InterruptedException {
        Select select = new Select(sortList);
        select.selectByIndex(2);
        Thread.sleep(1000);
    }
    public void UserCanSortByHighPriceOrder()
    {
        Select select = new Select(sortList);
        select.selectByIndex(3);
    }
    public void ResetApp() throws InterruptedException {
        clickButton(menu);
        Thread.sleep(1000);
        clickButton(resetAppStateBtn);
        clickButton(closeMenuBtn);
    }
}
