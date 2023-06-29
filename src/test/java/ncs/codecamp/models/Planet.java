package ncs.codecamp.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Planet {

    private WebElement CurrentPlanet;

    public Planet(WebElement planetCard){
        CurrentPlanet = planetCard;
    }
    public String getPlanetName(){
        return CurrentPlanet.findElement(By.className("name")).getText();
    }

  public void clickExplore(){
        CurrentPlanet.findElement(By.tagName("button")).click();
   }


}
