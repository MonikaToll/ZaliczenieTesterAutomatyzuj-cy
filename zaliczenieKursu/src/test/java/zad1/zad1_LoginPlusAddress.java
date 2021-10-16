package zad1;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class zad1_LoginPlusAddress {
    private WebDriver driver;


    @Given("Open mystore browser with https://mystore-testlab.coderslab.pl")
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
        emailField.sendKeys(email);
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    @And("Submit LogIn Data")
    public void SubmitLogUser() {
        WebElement submitLogUser = driver.findElement(By.id("submit-login"));
        submitLogUser.click();
    }

    @Then("Add new address button clicked")
    public void AddressesButtonClick() {
        WebElement addressesButtonClick = driver.findElement(By.id("addresses-link"));
        addressesButtonClick.click();
    }

    @Then("Create new address button clicked")
    public void CreateNewAddressButtonClick() {
        WebElement createNewAddressButtonClick = driver.findElement(By.xpath("//div[@class=\"addresses-footer\"]/a"));
        createNewAddressButtonClick.click();
    }

    @Then("Fill sheet with (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*) and (.*)")
    public void FillSheet(String alias, String firstName, String lastName, String company, String vat, String addressLine1, String addressLine2, String city, String zipPostcode, String country, String phone) {
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

        WebElement countryField1 = driver.findElement(By.xpath("//select[@name=\"id_country\"]/option[2]"));
        countryField1.click();

        WebElement phoneField = driver.findElement(By.name("phone"));
        phoneField.click();
        phoneField.clear();
        phoneField.sendKeys(phone);
    }

    @And("Submit sheet")
    public void SubmitSheet() {
        WebElement submitSheet = driver.findElement(By.xpath("//button[@class=\"btn btn-primary float-xs-right\"]"));
        submitSheet.click();
    }

    @And("Check if address data is correct (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*) and (.*)")
    public void CheckAddressData(String alias, String firstName, String lastName, String company, String vat, String addressLine1, String addressLine2, String city, String zipPostcode, String country, String phone) {

        List<WebElement> addresses = driver.findElements(By.xpath("//article[@class=\"address\"]"));
        String bodyText = addresses.get(addresses.size()-1).getText();

        Assert.assertTrue(alias + " not found!", bodyText.contains(alias));
        Assert.assertTrue(firstName + " " + lastName + " not found!", bodyText.contains(firstName + " " + lastName));
        Assert.assertTrue(vat + " not found!", bodyText.contains(vat));
        Assert.assertTrue(company + " not found!", bodyText.contains(company));
        Assert.assertTrue(addressLine1 + " not found!", bodyText.contains(addressLine1));
        Assert.assertTrue(addressLine2 + " not found!", bodyText.contains(addressLine2));
        Assert.assertTrue(zipPostcode + " not found!", bodyText.contains(zipPostcode));
        Assert.assertTrue(city + " not found!", bodyText.contains(city));
        Assert.assertTrue(phone + " not found!", bodyText.contains(phone));
        Assert.assertTrue(country + " not found!", bodyText.contains(country));
    }

    @Then("Quit browser")
    public void quitBrowser() {
        driver.quit();
    }
}