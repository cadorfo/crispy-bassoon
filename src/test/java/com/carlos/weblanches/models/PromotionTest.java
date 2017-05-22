package com.carlos.weblanches.models;

import com.carlos.weblanches.promotions.PromotionChain;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.carlos.weblanches.models.IngredientEnum.*;
import static com.carlos.weblanches.models.SandwichEnum.XBURGER;

public class PromotionTest {

    @Test
    public void lightPromotionTest() {
        List<Ingredient> ingredientList = Arrays.asList(
                LETTUCE.getIngrediment(),
                HAMBURGER.getIngrediment()
        );
        Sandwich sandwich = new Sandwich(ingredientList);
        PromotionChain.getChain().execute(sandwich);
        double totalCost = calculateIngredientsCost(ingredientList);
        Assert.assertEquals( totalCost * 0.9, sandwich.getTotalCost(), 0.01);
    }

    @Test
    public void tripleBurgerPromotionTest() {
        List<Ingredient> ingredientList = Arrays.asList(
                HAMBURGER.getIngrediment(),
                HAMBURGER.getIngrediment(),
                HAMBURGER.getIngrediment()
        );
        Sandwich sandwich = new Sandwich(ingredientList);
        PromotionChain.getChain().execute(sandwich);
        double totalCost = calculateIngredientsCost(ingredientList);
        Assert.assertEquals(totalCost - (HAMBURGER.getIngrediment().getCost()), sandwich.getTotalCost(), 0.01);
    }

    @Test
    public void tripleCheesePromotionTest() {
        List<Ingredient> ingredientList = Arrays.asList(
                CHEESE.getIngrediment(),
                CHEESE.getIngrediment(),
                CHEESE.getIngrediment(),
                CHEESE.getIngrediment(),
                CHEESE.getIngrediment(),
                CHEESE.getIngrediment()
        );
        Sandwich sandwich = new Sandwich(ingredientList);
        PromotionChain.getChain().execute(sandwich);
        double totalCost = calculateIngredientsCost(ingredientList);
        Assert.assertEquals(totalCost - (CHEESE.getIngrediment().getCost() * 2), sandwich.getTotalCost(), 0.01);
    }


    @Test
    public void tripleCheeseBurgerPromotionTest() {
        List<Ingredient> ingredientList = Arrays.asList(
                CHEESE.getIngrediment(),
                CHEESE.getIngrediment(),
                CHEESE.getIngrediment(),
                HAMBURGER.getIngrediment(),
                HAMBURGER.getIngrediment(),
                HAMBURGER.getIngrediment()
        );
        Sandwich sandwich = new Sandwich(ingredientList);
        PromotionChain.getChain().execute(sandwich);
        double totalCost = calculateIngredientsCost(ingredientList);
        double discountValue = (CHEESE.getIngrediment().getCost() + HAMBURGER.getIngrediment().getCost());
        Assert.assertEquals(totalCost - discountValue, sandwich.getTotalCost(), 0.01);
    }

    @Test
    public void tripleCheeseBurgerLightPromotionTest() {
        List<Ingredient> ingredientList = Arrays.asList(
                CHEESE.getIngrediment(),
                CHEESE.getIngrediment(),
                CHEESE.getIngrediment(),
                HAMBURGER.getIngrediment(),
                HAMBURGER.getIngrediment(),
                HAMBURGER.getIngrediment(),
                LETTUCE.getIngrediment()
        );
        Sandwich sandwich = new Sandwich(ingredientList);
        PromotionChain.getChain().execute(sandwich);
        double totalCost = calculateIngredientsCost(ingredientList);
        double discountValue = (CHEESE.getIngrediment().getCost() + HAMBURGER.getIngrediment().getCost());
        Assert.assertEquals((totalCost - discountValue) * 0.9, sandwich.getTotalCost(), 0.01);
    }

    @Test
    public void tripleCheeseBurgerAlmostLightPromotionTest() {
        List<Ingredient> ingredientList = Arrays.asList(
                CHEESE.getIngrediment(),
                CHEESE.getIngrediment(),
                CHEESE.getIngrediment(),
                HAMBURGER.getIngrediment(),
                HAMBURGER.getIngrediment(),
                HAMBURGER.getIngrediment(),
                LETTUCE.getIngrediment(),
                BACON.getIngrediment()
        );
        Sandwich sandwich = new Sandwich(ingredientList);
        PromotionChain.getChain().execute(sandwich);
        double totalCost = calculateIngredientsCost(ingredientList);
        double discountValue = (CHEESE.getIngrediment().getCost() + HAMBURGER.getIngrediment().getCost());
        Assert.assertEquals((totalCost - discountValue), sandwich.getTotalCost(), 0.01);
    }


    @Test
    public void costBurgerCost() {

        Sandwich sandwich = new Sandwich(XBURGER.getIngredientList());
        double totalCost = calculateIngredientsCost(XBURGER.getIngredientList());
        PromotionChain.getChain().execute(sandwich);
        Assert.assertEquals( totalCost , sandwich.getTotalCost(), 0.0);
    }


    private double calculateIngredientsCost(List<Ingredient> ingredients) {
        return ingredients.stream().mapToDouble(item -> item.getCost()).sum();
    }
}
