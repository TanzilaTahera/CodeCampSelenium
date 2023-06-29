package ncs.codecamp;

import io.restassured.internal.common.assertion.Assertion;
import ncs.codecamp.models.Form;
import ncs.codecamp.models.Planet;
import ncs.codecamp.models.PlanetPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.http.WebSocket;
import java.sql.SQLOutput;
import java.time.Duration;
import java.util.List;

public class playgroundTests {

    public WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = getWebDriver();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/#/");
        driver.manage().window().maximize();
    }
    public void playGroundHomeTest(){
        //1. Arrange
        //2. Act
        //3. Assert
        //choosing header of web playground using css selector
        var text = driver.findElement(By.cssSelector("h1.mb-3")).getText();
        Assertions.assertEquals(text,"Web Playground");
    }

    //@Test
    public void submitFormTest() throws InterruptedException {
        driver.findElement(By.cssSelector("[aria-label=forms]")).click();

        Form form = new Form(driver);

        form.enterName("Tanzila");
        form.enterEmail("tanzila_tahera@yahoo.com");
        form.selectState("NSW");
        form.clickAgree(true);
        form.submit();

    }
    @Test
    public void explorePlanets(){
        driver.findElement(By.cssSelector("[aria-label=planets]")).click();
        PlanetPage planetPage = new PlanetPage(driver);

        planetPage.getPlanet("earth").clickExplore();

    }
    //@Test
    public void planetButtonClick(){
        driver.findElement(By.cssSelector("[aria-label=planets]")).click();

        for (WebElement planetDiv : driver.findElements(By.cssSelector(".planet"))){
           Planet planetCard = new Planet(planetDiv);
           if (planetCard.getPlanetName().equalsIgnoreCase("earth")){
               planetCard.clickExplore();
           }
        }
    }
    public void formInfo () throws InterruptedException {

        driver.findElement(By.cssSelector("[href='#/forms']")).click();

        driver.findElement(By.id("name")).sendKeys("Tanzila");
        driver.findElement(By.id("email")).sendKeys("tanzila_tahera@yahoo.com");
        //Select drpState = new Select(driver.findElement(By.id("state")));
        // driver.findElement(By.id("list-item-229-0")).click();
        //drpState.selectByVisibleText("NSW");

        driver.findElement(By.cssSelector(".v-select__selections")).click();
        List<WebElement> states = driver.findElements(By.cssSelector("div[role=option]"));

        //System.out.println(states);
    Thread.sleep(2000);
        for(WebElement state: states){
            if(state.getText().equals("NSW"))
                state.click();
        }

        driver.findElement(By.cssSelector("[for='agree']")).click();
      //  driver.findElement(By.cssSelector(".v-select__selections")).click();

        for (WebElement button : driver.findElements(By.cssSelector("[type=button]"))){
            if (button.getText().equalsIgnoreCase("submit"))
            {
                Thread.sleep(700);
                break;
            }
        }

       // By byPopUpMessage = By.className("popup")

    }

    public void clickMeUptoDown(){
        By buttonBy = By.cssSelector("[role='button']");

        driver.findElement(buttonBy).click();


        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.textToBe(buttonBy,"CLICK ME UP!"));


        //need to wait for the text to appear
        var btnText = driver.findElement(buttonBy).getText();
        System.out.println(btnText);

        Assertions.assertEquals(btnText,"CLICK ME UP!");
    }

    public void clickMeDowntoUp(){
        By buttonByDown = By.cssSelector("[role='button']");

        driver.findElement(buttonByDown).click();


        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.textToBe(buttonByDown,"CLICK ME DOWN!"));


        //need to wait for the text to appear
        var btnText = driver.findElement(buttonByDown).getText();
        System.out.println(btnText);

        Assertions.assertEquals(btnText,"CLICK ME DOWN!");
    }

    public void demoTest(){
        //driver.get("https://d18u5zoaatmpxx.cloudfront.net/#/");

        driver.findElement(By.id("forename")).sendKeys("Tanzila");
        driver.findElement(By.id("submit")).click();

        String text = driver.findElement(By.xpath("//h1[@class=\"display-1 mb-3\"]")).getText();

        Assertions.assertEquals(text,"Web Playground");

        System.out.println(text);


    }
    public WebDriver getWebDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        return driver;
    }
    public void getWindowHandle(){
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/#/forms");
        driver.manage().window().maximize();
    }
    @AfterEach
    public void cleanUp(){
        //driver.quit();

    }
}
