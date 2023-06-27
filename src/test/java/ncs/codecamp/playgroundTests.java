package ncs.codecamp;

import io.restassured.internal.common.assertion.Assertion;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.jupiter.api.Assertions;

import java.sql.SQLOutput;

public class playgroundTests {

    @Test
    public void demoTest(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://d18u5zoaatmpxx.cloudfront.net/#/");

        driver.findElement(By.id("forename")).sendKeys("Tanzila");
        driver.findElement(By.id("submit")).click();

        String text = driver.findElement(By.xpath("//h1[@class=\"display-1 mb-3\"]")).getText();

        Assertions.assertEquals(text,"Web Playground");

        System.out.println(text);



    }
}
