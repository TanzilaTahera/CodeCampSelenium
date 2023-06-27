package ncs.codecamp;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class playgroundTests {

    @Test
    public void demoTest(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://d18u5zoaatmpxx.cloudfront.net/#/");

        driver.findElement(By.id("forename")).sendKeys("Tanzila");
        driver.findElement(By.id("submit")).click();

        driver.





    }
}
