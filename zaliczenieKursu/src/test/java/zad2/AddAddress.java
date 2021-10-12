package zad4;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AddAddress {

    public String keyword;
    private WebDriver driver;

    @Given("an open user browser with gloapps")
    public void openCreateAccount() {
        // Skonfiguruj sterownik przeglądarki
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        // Przejdź do przeglądarki
        driver.get("https://qloapps.coderslab.pl");
    }

    @And ("email set with (.*)")
    public void setEmail(String mail) {
        WebElement email = driver.findElement(By.className("email"));
        email.sendKeys ("qwerty@gmail.com");
    }
    @And ("password set with (.*)")
    public void setPassword(String mail) {
        WebElement email = driver.findElement(By.className("passwd"));
        email.sendKeys("12345");
    }

    @And ("create Account clicked")
    public void signInButon (String account){
        WebElement signInButton = driver.findElement(By.className ("submit"));
        signInButton.click();
    }

    @And ("open the user menu")
    public void signIn (String menu) {
        WebElement signInButton = driver.findElement(By.id("user_info_acc"));
        signInButton.click();
    }
    @And ("click Accounts")
    public void signInButton(String Accounts){
        WebElement signInButton = driver.findElement(By.name ("submit"));
        signInButton.click();

    @When ("firstName set with (.*)")
    public void setfirstName (String "firstname") {

        WebElement firstName = driver.findElement(By.name("customer_firstname"));
        firstName.sendKeys ("firstname");
    }
    @And ("lastName set with (.*)")
    public void setlastName(String "lastname"){
        WebElement lastNameField = driver.findElement(By.className("customer_lastname"));
        lastNameField.sendKeys("lastname");
    }

    @And ("password set with (.*)")
    public void setpassword(){
        WebElement password = driver.findElement(By.className("password"));
        password.sendKeys("passwd");
    }

    @And ("register clicked")
    public void clickInButton(String "registrastion"){
        WebElement clickInButton = driver.findElement(By.className ("clearfix"));
        clickInButton.click();
    }


    @Then("account with (.*) is created")
    public void theFirstOneShouldContainKeyword(String "expectedText") {
        System.out.println("expectedText");
    }

    @And("close browser")
    public void closeBrowser(){
        driver.quit();
    }


}
