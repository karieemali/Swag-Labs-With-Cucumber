package steps;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import pages.ProductsPage;
import tests.TestBase;

public class SortingZToAOrder extends TestBase {

    LoginPage loginPage;
    ProductsPage productsPage;
    @Given("the user is on the products page after logging in successfully With I enter {string} , {string}")
    public void the_user_is_on_the_products_page_after_logging_in_successfully_with_i_enter(String username, String password) throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.UserCanAddElementLogin(username, password);
        loginPage.UserCanLogin();
        Thread.sleep(1000);
    }
    @When("the user selects Sort by Alphabetic \\(Descending) from the sorting options")
    public void the_user_selects_sort_by_alphabetic_descending_from_the_sorting_options() {
        productsPage = new ProductsPage(driver);
        productsPage.UserCanSortByAlphabeticInDescendingOrder();
    }
    @Then("all products should be displayed in Descending alphabetical order")
    public void all_products_should_be_displayed_in_descending_alphabetical_order() throws InterruptedException {
        Assert.assertTrue(productsPage.firstProdDes.getText().contains("Test"));
        productsPage.UserCanLogout();
    }
}
