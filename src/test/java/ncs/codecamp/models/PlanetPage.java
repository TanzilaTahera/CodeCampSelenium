package ncs.codecamp.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PlanetPage {
    private WebDriver driver;

    public PlanetPage (WebDriver driver){
        this.driver = driver;
    }
    public List<WebElement> getPlanets() {
        List<WebElement> planetList = new ArrayList<>();

        for (WebElement planetDiv : driver.findElements(By.cssSelector(".planet"))) {
            planetList.add(planetDiv);
        }

        return planetList;
    }


    public Planet getPlanet(String planetName){

        for (WebElement planetElmnt : getPlanets()){
            Planet planetObj = new Planet(planetElmnt);
            if(planetObj.getPlanetName().equalsIgnoreCase(planetName)){
                return planetObj;
            }

        }
        throw new RuntimeException("Not found");
    }
}
