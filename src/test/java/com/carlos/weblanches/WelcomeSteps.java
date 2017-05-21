package com.carlos.weblanches;

import com.carlos.weblanches.models.Ingredient;
import com.carlos.weblanches.models.IngredientEnum;
import com.carlos.weblanches.models.Sandwich;
import com.carlos.weblanches.models.SandwichEnum;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java8.En;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

/**
 * Created by carlos on 21/05/17.
 */

public class WelcomeSteps implements En {

    WebDriver driver = null;

    public WelcomeSteps() {
        Given("^I go to weblanches website$", () -> {
            System.setProperty("webdriver.chrome.driver", "/home/carlos/app/selenium/chromedriver");
            driver = new ChromeDriver();
            driver.navigate().to("http://localhost:8080");

        });
        When("I look at the menu",()-> {});
        Then("^All sandwich names and prices are right$",( DataTable datatable )-> {
            List<Sandwich> sandwiches = transformSandwiches(datatable);
            sandwiches.forEach(item -> {
                WebElement sandwichLine = driver.findElement(By.cssSelector("#id-"+item.getSandwichEnum().name()));
                String name = sandwichLine.findElement(By.cssSelector("[name='name']")).getText();
                String price = sandwichLine.findElement(By.cssSelector("[name='price']")).getText();
                Assert.assertEquals(name,item.getName());
                Assert.assertEquals(price, item.getFormattedPrice());
            });
            driver.close();
        });
    }
    private List<Sandwich> transformSandwiches(DataTable dataTable) {
        List<Sandwich> result = new ArrayList<>();
        dataTable.getGherkinRows().forEach(dataTableRow -> {
            SandwichEnum sandwichEnum = SandwichEnum.valueOf(dataTableRow.getCells().get(0));
            result.add(new Sandwich(sandwichEnum));
        });

        return result;
    }

}
