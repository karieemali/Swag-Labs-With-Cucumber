package steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ProductsPage;
import pages.LoginPage;
import tests.TestBase;

public class UserLogin extends TestBase {
    LoginPage loginPage;
    ProductsPage productsPage;

    @Given("The user in the login page")
    public void the_user_in_the_login_page() {
        loginPage = new LoginPage(driver);
    }
    @When("I entered {string} , {string}")
    public void i_entered(String username, String password) {
        loginPage.UserCanAddElementLogin(username, password);
    }
    @When("I click on login bottom")
    public void i_click_on_login_bottom() {
        loginPage.UserCanLogin();
    }
    @Then("Move to the products page successfully")
    public void move_to_the_home_page_successfully() {
        productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.title.getText().equalsIgnoreCase("Products"));
    }
    @Then("user can logout from site")
    public void user_can_logout_from_site() throws InterruptedException {
        productsPage.UserCanLogout();
    }
}
