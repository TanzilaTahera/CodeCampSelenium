package ncs.codecamp.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Form {

    public WebDriver driver;

    public Form(WebDriver driver){
        this.driver = driver;
    }
    public void enterName(String nameKey){

        driver.findElement(By.id("name")).sendKeys(nameKey);
    }
    public void enterEmail(String emailKey){
        driver.findElement(By.id("email")).sendKeys(emailKey);
    }
    public void selectState(String stateKey) throws InterruptedException {
        driver.findElement(By.cssSelector(".v-select__selections")).click();
        List<WebElement> states = driver.findElements(By.cssSelector("div[role=option]"));

        //System.out.println(states);
        Thread.sleep(2000);
        for(WebElement state: states){
            if(state.getText().equals(stateKey))
                state.click();
        }

    }
    public void clickAgree(boolean agreeKey){
        driver.findElement(By.cssSelector("[for='agree']")).click();

    }
    public void submit(){
        for (WebElement button : driver.findElements(By.cssSelector("[type=button]"))){
            if (button.getText().equalsIgnoreCase("submit"))
            {
                button.click();
                break;
            }
        }


    }


}
