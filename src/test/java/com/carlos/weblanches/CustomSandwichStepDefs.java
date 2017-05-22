package com.carlos.weblanches;

import com.carlos.weblanches.models.IngredientEnum;
import cucumber.api.DataTable;
import cucumber.api.java8.En;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.IntStream;

public class CustomSandwichStepDefs implements En {
    ChromeDriver driver = null;

    public CustomSandwichStepDefs() {

        Given("^I am at the custom sandwich page$", () -> {
            String url = getProperties().getProperty("url");
            String driverAddress = getProperties().getProperty("driverAddress");
            System.setProperty("webdriver.chrome.driver", driverAddress);

            driver = new ChromeDriver();

            driver.navigate().to(url + "/customSandwich/");

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

    public Properties getProperties() {
        try {
            Properties properties = new Properties();
            properties.load(getClass().getClassLoader().getResourceAsStream("cucumber.properties"));
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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
