package zad2;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;


public class zad2_OrderInShop{

    private WebDriver driver;
    String totalAmount;
    String orderReference;


    @Given("Open browser with https://mystore-testlab.coderslab.pl/index.php")
    public void openSite() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }

    @And("SignIn button clicked")
    public void LogInClick() {
        WebElement logInClick = driver.findElement(By.id("_desktop_user_info"));
        logInClick.click();
    }

    @Then("Input (.*) and (.*) in LogIn page")
    public void LogInData(String email, String password) {
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys("qwerty@wp.pl");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("12345");
    }

    @And("Submit LogIn Data")
    public void SubmitLogIn() {
        WebElement submitLogIn = driver.findElement(By.id("submit-login"));
        submitLogIn.click();
    }

    @Then("Search (.*) in search area")
    public void SearchProduct(String productName) {
        WebElement searchProduct = driver.findElement(By.name("s"));
        searchProduct.click();
        searchProduct.clear();
        searchProduct.sendKeys(productName);
        searchProduct.submit();

        WebElement clickSearch = driver.findElement(By.className("material-icons"));
        clickSearch.click();
    }

    @And("Open product page")
    public void OpenProductPage() {
        WebElement openProductPage = driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div[2]/div[2]/div[2]/form/div[1]/div[1]/select/option[2]/title"));
        openProductPage.click();
    }

    @Then("Select correct (.*)")
    public void SelectSize(String size) {
        WebElement selectSize = driver.findElement(By.cssSelector("[title*='" + size + "']"));
        selectSize.click();
        selectSize.clear();
        selectSize.sendKeys(size);
        }


    @And("Choose (.*)")
    public void ChooseQuantity(String quantity ) {
        WebElement chooseQuantity = driver.findElement(By.id("quantity_wanted"));
        chooseQuantity.click();
        chooseQuantity.clear();
        chooseQuantity.sendKeys(quantity);
    }

    @Then("Add products to cart")
    public void AddProductsToCart() {
        WebElement addProductToCart = driver.findElement(By.className("add-to-cart"));
        addProductToCart.click();

    }

    @And("Go to checkout")
    public void GoToCheckout() {
        WebElement goToCheckout = driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a"));
        goToCheckout.click();
    }

    @Then("Choose address to order")
    public void ChooseAddress() {
        WebElement chooseaddress = driver.findElement(By.id("id-address-delivery-address-14740"));
         chooseaddress.click();
    }

    @And("Confirm to continue")
    public void ConfirmToContinue() {
        WebElement confirmtocontinue = driver.findElement(By.name("confirm-addresses"));
        confirmtocontinue.click();
    }

    @Then("Get shipping method PrestaShop pick up in-store")
    public void GetShippingMethod() {
        WebElement getShippingMethod = driver.findElement(By.id("delivery_option_1"));
        getShippingMethod.click();
    }

    @And("Continue to payment")
    public void ContinueToPayment() {
        WebElement continueToPayment = driver.findElement(By.name("confirmDeliveryOption"));
        continueToPayment.click();
    }

    @Then("Select first payment method")
    public void PayByCheck() {
        WebElement payByCheck = driver.findElement(By.id("payment-option-1"));
        payByCheck.click();
    }

    @And("Agree to the terms")
    public void AgreeTerms() {
        WebElement agreeTerms = driver.findElement(By.name("conditions_to_approve[terms-and-conditions]"));
        agreeTerms.click();
    }

    @And("Click the button order with an obligation to pay")
    public void ClickTheButtonObligationToPay() {
        WebElement clickthebuttonobligationtopay = driver.findElement(By.id("payment-confirmation"));
        clickthebuttonobligationtopay.click();
    }

    @Then("Take screenshot that confirm the order and total amount")
    public void TakeScreenshotforConfirmation()  {
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
//Path to the location to save screenshot
        FileUtils.copyFile(source, new File("./SeleniumScreenshots/MyStoreScreen.png"));
        System.out.println("Screenshot is captured");
        }

    @Then("Close browser")
    public void closeBrowser() {
        driver.quit();
    }
}
