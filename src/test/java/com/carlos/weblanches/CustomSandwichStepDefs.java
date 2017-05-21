package com.carlos.weblanches;

import com.carlos.weblanches.models.IngredientEnum;
import cucumber.api.DataTable;
import cucumber.api.java8.En;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.stream.IntStream;

public class CustomSandwichStepDefs implements En {
    ChromeDriver driver = null;

    public CustomSandwichStepDefs() {
        Given("^I am at the custom sandwich page$", () -> {
            System.setProperty("webdriver.chrome.driver", "/home/carlos/app/selenium/chromedriver");

            driver = new ChromeDriver();

            driver.navigate().to("http://localhost:8080/customSandwich/");

        });

        When("^I choose one with:$", (DataTable dataTable) -> {
            dataTable.getGherkinRows().forEach(dataTableRow -> {
                Integer quantity = Integer.valueOf(dataTableRow.getCells().get(0));
                String ingredient = dataTableRow.getCells().get(1).toUpperCase();
                IntStream.range(0, quantity).forEach(item -> {
                    WebElement webElement = driver.findElement(By.cssSelector(".btn[name='plus'][value='" + ingredient + "']"));
                    webElement.click();
                });
            });
        });

        After(()-> {
            if(driver!= null)
                driver.close();
        } );

        Then("^It shows the right price sandwich price$", (DataTable dataTable) -> {
            Map<String, Integer> ingredientMap = transformIngredients(dataTable);
            Double finalPrice = 0.0;
            finalPrice = ingredientMap.keySet().stream().mapToDouble(ingredientKey -> {
                return IngredientEnum.valueOf(ingredientKey).getIngrediment().getCost() * ingredientMap.get(ingredientKey);
            }).sum();

            WebElement result = driver.findElement(By.cssSelector("#result"));
            Double resultDouble = getCurrencyFromElement(result);

            Assert.assertEquals(finalPrice,resultDouble);
        });

        Then("^It shows the right price sandwich price for light promotion$", (DataTable dataTable) -> {
            Map<String, Integer> ingredientMap = transformIngredients(dataTable);
            Double finalPrice = 0.0;
            finalPrice = ingredientMap.keySet().stream().mapToDouble(ingredientKey -> {
                return IngredientEnum.valueOf(ingredientKey).getIngrediment().getCost() * ingredientMap.get(ingredientKey);
            }).sum();

            WebElement result = driver.findElement(By.cssSelector("#result"));
            Double resultDouble = getCurrencyFromElement(result);
            finalPrice *= 0.9;

            Assert.assertEquals(finalPrice ,resultDouble);
        });
    }

    private Map<String, Integer> transformIngredients(DataTable dataTable) {
        Map<String, Integer> result = new HashMap<>();
        dataTable.getGherkinRows().forEach(dataTableRow -> {
            Integer quantity = Integer.valueOf(dataTableRow.getCells().get(0));
            String ingredient = dataTableRow.getCells().get(1).toUpperCase();
            result.put(ingredient, quantity);
        });

        return result;
    }

    private Double getCurrencyFromElement(WebElement element){
        try {
            return NumberFormat.getCurrencyInstance().parse(element.getText()).doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

}
