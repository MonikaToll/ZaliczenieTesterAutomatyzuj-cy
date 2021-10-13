package zad1;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class zad1_LoginPlusAddress {
    private WebDriver driver;


    @Given("Open browser with https://mystore-testlab.coderslab.pl")
    public void openSite() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl");
    }

    @And("SignIn button clicked")
    public void SignInClick() {
        WebElement signInClick = driver.findElement(By.id("_desktop_user_info"));
        signInClick.click();
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

    @Then("Add new address button clicked")
    public void AddressesButtonClick() {
        WebElement addressesButtonClick = driver.findElement(By.id("addresses-link"));
        addressesButtonClick.click();
    }

    @Then("Create new address button clicked")
    public void CreateNewAddressButtonClick() {
        WebElement createNewAddressButtonClick = driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/a/span"));
        createNewAddressButtonClick.click();
    }

    @Then("Fill sheet with (.*), (.*), (.*), (.*), (.*), (.*), (.*) and (.*)")
    public void FillSheet(String alias, String firstName, String lastName, String company, String vat, String addressLine1, String addressLine2, String zipPostcode, String city, String phone) {
        WebElement aliasField = driver.findElement(By.name("alias"));
        aliasField.click();
        aliasField.clear();
        aliasField.sendKeys(alias);

        WebElement firstnameField = driver.findElement(By.name("firstname"));
        firstnameField.click();
        firstnameField.clear();
        firstnameField.sendKeys(firstName);

        WebElement lastnameField = driver.findElement(By.name("lastname"));
        lastnameField.click();
        lastnameField.clear();
        lastnameField.sendKeys(lastName);

        WebElement companyField = driver.findElement(By.name("company"));
        companyField.click();
        companyField.clear();
        companyField.sendKeys(company);

        WebElement vatField = driver.findElement(By.name("vat_number"));
        vatField.click();
        vatField.clear();
        vatField.sendKeys(vat);

        WebElement address1Field = driver.findElement(By.name("address1"));
        address1Field.click();
        address1Field.clear();
        address1Field.sendKeys(addressLine1);

        WebElement address2Field = driver.findElement(By.name("address2"));
        address2Field.click();
        address2Field.clear();
        address2Field.sendKeys(addressLine2);

        WebElement cityField = driver.findElement(By.name("city"));
        cityField.click();
        cityField.clear();
        cityField.sendKeys(city);

        WebElement postcodeField = driver.findElement(By.name("postcode"));
        postcodeField.click();
        postcodeField.clear();
        postcodeField.sendKeys(zipPostcode);

        WebElement countryField = driver.findElement(By.xpath("//*[@id=\"form-fields\"]/div[10]/div[1]/select/option[2]"));
        countryField.click();

        WebElement phoneField = driver.findElement(By.name("phone"));
        phoneField.click();
        phoneField.clear();
        phoneField.sendKeys(phone);
    }

    @And("Submit sheet")
    public void SubmitSheet() {
        WebElement submitSheet = driver.findElement(By.className("btm-primary"));
        submitSheet.click();
    }

    @And("Check if address data is correct (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*) and (.*)")
    public void CheckAddressData(String firstName, String lastName, String alias, String company, String vat, String addressLine1, String addressLine2, String zipPostcode, String city, String country, String phone) {


        String bodyText = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div[1]/article/div[1]")).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(alias));
        Assert.assertTrue("Text not found!", bodyText.contains(firstName + " " + lastName));
        Assert.assertTrue("Text not found!", bodyText.contains(company));
        Assert.assertTrue("Text not found!", bodyText.contains(vat));
        Assert.assertTrue("Text not found!", bodyText.contains(addressLine1));
        Assert.assertTrue("Text not found!", bodyText.contains(addressLine2));
        Assert.assertTrue("Text not found!", bodyText.contains(zipPostcode));
        Assert.assertTrue("Text not found!", bodyText.contains(city));
        Assert.assertTrue("Text not found!", bodyText.contains(phone));
        Assert.assertTrue("Text not found!", bodyText.contains(country));
    }

    @Then("Delete address")
    public void DeleteAddress() {
        WebElement deleteAddress = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div[1]/article/div[2]/a[2]"));
        deleteAddress.click();
    }

    @And("Check if address is deleted")
    public void DeleteAddressCheck() {
        Assert.assertEquals(0, driver.findElements(By.xpath("/html/body/main/section/div/div/section/section/div[1]/article/div[2]/a[2]")).size());
    }

    @Then("Quit browser")
    public void quitBrowser() {
        driver.quit();
    }
}