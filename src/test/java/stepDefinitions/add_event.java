package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.uwas.Driver;

import java.time.LocalDate;
import java.util.List;

public class add_event {
    Driver driver;

    public add_event(Driver driver) {
        System.out.println(System.getProperty("environment"));
        this.driver = driver;
        this.driver.setupController();

    }


    @Given("photographer should login")
    public void photographer_should_login() {
        try {

            this.driver.getWebDriver().get(this.driver.getBaseUrl()+"/login");
            Thread.sleep(10);
            this.driver.getWebDriver().findElement(By.id("email")).sendKeys("azizaouadi12@gmail.com");
            Thread.sleep(10);
            this.driver.getWebDriver().findElement(By.id("password")).sendKeys("Admin123!");
            Thread.sleep(10);
            this.driver.getWebDriver().findElement(By.id("testLogin")).click();
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("photographer should click on the button of add event")
    public void photographer_should_click_on_the_button_of_add_event() {
        try {
            Thread.sleep(5000);
            WebElement drp = this.driver.getWebDriver().findElement(By.id("dropdown-event-link"));
            drp.click();
            Thread.sleep(500);
            this.driver.getWebDriver().findElement(By.id("event-add")).click();


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("photographer should fill the title of event as {string}")
    public void photographer_should_fill_the_title_of_event(String title_of_event) {
        try {
            Thread.sleep(10000);
            WebElement title = this.driver.getWebDriver().findElement(By.id("event-title"));
            title.sendKeys(title_of_event);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("photographer should fill the location of event as {string}")
    public void photographer_should_fill_the_location_of_event(String location_of_event) {
        try {
            Thread.sleep(5000);
            this.driver.getWebDriver().findElement(By.id("location")).sendKeys(location_of_event);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("photographer should fill the date of event as {string}")
    public void photographer_should_fill_the_date_of_event(String date_of_event) {
        try {

            WebElement dateInput = this.driver.getWebDriver().findElement(By.id("testEventDate"));
            Thread.sleep(1000);
            dateInput.sendKeys(Keys.CONTROL, "a");
            Thread.sleep(1000);
            dateInput.sendKeys(Keys.DELETE);
            Thread.sleep(1000);
            dateInput.sendKeys(date_of_event);
            Thread.sleep(1000);
            dateInput.sendKeys(Keys.ENTER);


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("photographer put an image for the event")
    public void photographer_put_an_image_for_the_event() {
        try {
            Thread.sleep(3000);
            WebElement source = this.driver.getWebDriver().findElement(By.id("upload"));
            source.sendKeys("C://Users/Lenovo/Desktop/traditions-noel-europe-1024x683.jpg");


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    @And("photographer should click on the button ok")
    public void photographer_should_click_on_the_button_ok() {
        try {
            Thread.sleep(1000);
            this.driver.getWebDriver().findElement(By.id("test123")).click();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Then("title of event as {string} event in location of event as {string} at the date of event as {string} is created")
    public void title_of_event_in_location_at_date_is_created(String title_of_event, String location_of_event, String date_of_event) {
        try {
            Thread.sleep(1000);
            boolean found = false;
            List<WebElement> eventNames = this.driver.getWebDriver().findElements(By.id("event-name"));
            List<WebElement> eventLocation = this.driver.getWebDriver().findElements(By.id("event-location"));
            List<WebElement> eventDate = this.driver.getWebDriver().findElements(By.id("event-date"));
            List<WebElement> eventStatus = this.driver.getWebDriver().findElements(By.className("ant-tag-gold"));


            for (int i = 0; i < eventNames.size(); i++) {
                String name_string =eventNames.get(i).getText();
                String location_string = eventLocation.get(i).getText();
                String date_string = eventDate.get(i).getText();
                boolean name = name_string.toUpperCase().equals(title_of_event.toUpperCase());
                boolean location = (location_string.toUpperCase().equals(location_of_event.toUpperCase()));
                boolean date = date_string.equals(date_of_event);
                boolean status = eventStatus.get(i).getText().equals("In progress");
                if ((name) && (date ) && (status)&&(location)) {
                    found = true;
                    break;
                }
            }
            if (found) {
                Assert.assertTrue(true);
                System.out.println("test pass");
            }
            else {
                Assert.assertFalse(false);
                System.out.println("test fail");
            }

            Thread.sleep(100);
            this.driver.getWebDriver().quit();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Then("an error message appear under the title field")
    public void an_error_message_appear_under_the_title_field() {
        try {
            Assert.assertTrue(this.driver.getWebDriver().findElement(By.id("event-default-price")).isDisplayed());
            Assert.assertTrue(this.driver.getWebDriver().findElement(By.id("event-title")).isDisplayed());
            Assert.assertTrue(this.driver.getWebDriver().findElement(By.id("location")).isDisplayed());
            Assert.assertTrue(this.driver.getWebDriver().findElement(By.id("testEventDate")).isDisplayed());
            Thread.sleep(100);
            this.driver.getWebDriver().quit();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    @Then("title of event as {string} event in location of event as {string} is created with the date added")
    public void title_of_event_in_location_of_event_is_created_with_the_date_added(String title_of_event, String location_of_event) {
        try {
            boolean found = false;
            List<WebElement> eventNames =this.driver.getWebDriver().findElements(By.id("event-name"));
            List<WebElement> eventLocation =this.driver.getWebDriver().findElements(By.id("event-location"));
            List<WebElement> eventDate = this.driver.getWebDriver().findElements(By.id("event-date"));
            List<WebElement> eventStatus = this.driver.getWebDriver().findElements(By.className("ant-tag"));
            LocalDate localDate = LocalDate.now();
            for (int i = 0; i < eventNames.size(); i++) {
                String name_string = eventNames.get(i).getText();
                String location_string = eventLocation.get(i).getText();
                boolean name = name_string.toUpperCase().equals(title_of_event.toUpperCase());
                boolean location = location_string.toUpperCase().equals(location_of_event.toUpperCase());
                boolean date = eventDate.get(i).getText().equals(localDate.toString());
                boolean status = eventStatus.get(i).getText().equals("In progress");
                if ((name) && (location) && (date) && (status)) {
                    found = true;
                    break;
                }
            }
            if (found) {
                Assert.assertTrue(found);
                System.out.println("test pass");
            }
            else {
                Assert.assertFalse(found);
                System.out.println("test fail");
            }

            Thread.sleep(100);
            this.driver.getWebDriver().quit();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Then("an error message appear and the event is created without image")
    public void an_error_message_appear_and_the_event_is_created_without_image() {
        try {
            WebElement im = this.driver.getWebDriver().findElement(By.className("ant-card-cover"));
            im = im.findElement(By.tagName("img"));
            Thread.sleep(1000);
            String src_im = im.getAttribute("src");
            boolean find = false ;
            if (src_im.contentEquals("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQW_80vVH0RghGLTxWZjz0EYc9JanOzT-m0wEUvdU0caY6bKU5n8oF5hbOHZlU9GVUM1dQ&usqp=CAU")){
                find = true ;
            }
            if (find) {
                Assert.assertTrue(find);
                System.out.println("test pass");
            }
            else {
                Assert.assertFalse(find);




                
                System.out.println("test fail");
            }

            Thread.sleep(10);
            this.driver.getWebDriver().quit();


        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("photographer put a file in the image field for the event")
    public void photographer_put_a_file_in_the_image_field_for_the_event() {
        try {
            Thread.sleep(10);
            WebElement source = this.driver.getWebDriver().findElement(By.id("upload"));
            source.sendKeys("C://Users/Lenovo/Desktop/CORAL IO_Rescrit_JEI_2021 2022 2023_v1.0 (1) - Copie.docx");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}



     