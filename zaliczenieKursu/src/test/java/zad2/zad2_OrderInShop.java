package zad2;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;


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

    @And("SignIn button approved")
    public void LogInApproved() {
        WebElement logInApproved = driver.findElement(By.id("_desktop_user_info"));
        logInApproved.click();
    }

    @Then("Input (.*) and (.*) in LogIn area")
    public void LogInPage(String email, String password) {
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    @And("User LogIn to the shop")
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
        WebElement openProductPage = driver.findElement(By.xpath("//div[@class=\"product-description\"]/h2/a[contains(text(),\"Hummingbird printed sweater\")]"));
        openProductPage.click();
    }

    @Then("Select correct (.*)")
    public void SelectSize(String size) {
        WebElement selectSize = driver.findElement(By.cssSelector("[title*='" + size + "']"));
        selectSize.click();
        }


    @And("Choose quantity (.*)")
    public void ChooseQuantity(String quantity ) throws InterruptedException {
        WebElement chooseQuantity = driver.findElement(By.id("quantity_wanted"));
        Thread.sleep(1000);
        chooseQuantity.clear();
        chooseQuantity.sendKeys(quantity);
    }

    @Then("Add products to cart")
    public void AddProductsToCart() {
        WebElement addProductToCart = driver.findElement(By.className("add-to-cart"));
        addProductToCart.click();

    }

    @And("Go to checkout")
    public void GoToCheckout() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        String buttonPath = "//a[@class=\"btn btn-primary\"]";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(buttonPath)));
        WebElement goToCheckout = driver.findElement(By.xpath(buttonPath));
        goToCheckout.click();
    }

    @And("Proceed to checkout")
    public void ProceedToCheckout() {
        WebElement goToCheckout = driver.findElement(By.className("btn-primary"));
        goToCheckout.click();
    }

    @Then("Choose address to order")
    public void ChooseAddress() {
        WebElement chooseaddress = driver.findElements(By.className("address-item")).get(0);
        chooseaddress.click();
    }

    @And("Confirm to continue")
    public void ConfirmToContinue() {
        WebElement confirmtocontinue = driver.findElement(By.name("confirm-addresses"));
        confirmtocontinue.click();
    }

    @Then("Get shipping method PrestaShop pick up in-store")
    public void GetShippingMethod() {
        WebElement getShippingMethod = driver.findElement(By.xpath("//input[@id=\"delivery_option_1\"]/.."));
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
    public void TakeScreenshotforConfirmation() throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(Paths.get("C:\\SeleniumScreenshots\\MyStoreScreen.png"));

        Files.move( source.toPath(), Paths.get("C:\\SeleniumScreenshots\\MyStoreScreen_" + UUID.randomUUID() + ".png"));
        //StandardCopyOption.REPLACE_EXISTING
        //source.renameTo(new File("C:\\SeleniumScreenshots\\MyStoreScreen.png"));
        System.out.println("Screenshot is captured");
        }

    @Then("Close browser")
    public void closeBrowser() {
        driver.quit();
    }
}
