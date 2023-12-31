package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.uwas.Driver;

public class sign_up_steps {
    Driver driver ;

    public sign_up_steps (Driver driver) {
        this.driver = driver;
        this.driver.setupController();
    }
    @Given("user open the website and click on sign up now")
    public void user_open_the_website_and_click_on_sign_up_now() {
        try {
            this.driver.getWebDriver().get(this.driver.getBaseUrl()+"/login");
            new WebDriverWait(driver.getWebDriver(),Duration.ofSeconds(15))
            .until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
            Thread.sleep(10);
            this.driver.getWebDriver().findElement(By.linkText("Sign up now!")).click();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("user fill first_name as {string}")
    public void user_fill_first_name(String first_name) {

        try {
            Thread.sleep(1);
            new WebDriverWait(driver.getWebDriver(),Duration.ofSeconds(15))
            .until(ExpectedConditions.visibilityOfElementLocated(By.id("first_name")));
            this.driver.getWebDriver().findElement(By.id("first_name")).sendKeys(first_name);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        }



    @And("user fill last_name as {string}")
    public void user_fill_last_name(String last_name) {
        try {
            Thread.sleep(1);
            this.driver.getWebDriver().findElement(By.id("last_name")).sendKeys(last_name);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @And("user fill email as {string}")
    public void user_fill_email(String email) {
        try {
            Thread.sleep(1);
            this.driver.getWebDriver().findElement(By.id("email")).sendKeys(email);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
//     @And("user fill password as {string}")
//     public void user_fill_password ( String password ) {
//         try {
//             Thread.sleep(1);
//             this.driver.getWebDriver().findElement(By.id("password")).sendKeys(password);

//         }catch (InterruptedException e) {
//             throw new RuntimeException(e);
//         }

// }
//     @And("user fill confirm_password as {string}")
//     public void user_fill_confirm_password ( String confirm_password ) {
//         try {
//             Thread.sleep(1);
//             this.driver.getWebDriver().findElement(By.id("confirmPassword")).sendKeys(confirm_password);
//         } catch (InterruptedException e) {
//             throw new RuntimeException(e);

//         }
//     }
    @And("user click on the captcha")
    public void user_click_on_the_captcha (  ) {
        try {


            Thread.sleep(15000);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);

        }

    }
    @And("user click on sign up")
    public void user_click_on_sign_up () {
        try {
            Thread.sleep(4);
            this.driver.getWebDriver().findElement(By.id("testRegister")).click();
        }catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
    }

    @Then("user have an account he can login with this credentials email as {string} and password as {string}")
    public void user_have_an_account_he_can_login_with_this_credentials_email_and_password ( String email , String password) {
        try {
            new WebDriverWait(driver.getWebDriver(),Duration.ofSeconds(5))
            .until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
            this.driver.getWebDriver().findElement(By.id("email")).sendKeys(email);
            this.driver.getWebDriver().findElement(By.id("password")).sendKeys(password);
            this.driver.getWebDriver().findElement(By.id("testLogin")).click();
            Thread.sleep(4);
            boolean f = true ;

            String current_url = this.driver.getWebDriver().getCurrentUrl();
            if (current_url.contentEquals("https://recette.uwas.fr/login")) {
                f = false;
            }
            Assert.assertTrue(f);
            this.driver.getWebDriver().quit();
        }catch (InterruptedException e) {
            throw new RuntimeException(e);

        }

    }

    @Then("user fail to create an account")
    public void user_fail_to_create_an_account (){
        try {
            // Thread.sleep(3000);
            Assert.assertTrue(this.driver.getWebDriver().findElement(By.id("confirmPassword")).isDisplayed());
            Assert.assertTrue(this.driver.getWebDriver().findElement(By.id("first_name")).isDisplayed());
            Assert.assertTrue(this.driver.getWebDriver().findElement(By.id("last_name")).isDisplayed());
            Thread.sleep(2);
            this.driver.getWebDriver().quit();

        }catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
    }
}

