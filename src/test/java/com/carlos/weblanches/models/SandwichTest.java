package com.carlos.weblanches.models;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.carlos.weblanches.models.SandwichEnum.*;

public class SandwichTest {

    @Test
    public void cost() {
        List<Ingredient> ingredientList = new ArrayList<>();
        ingredientList.add(IngredientEnum.BACON.getIngrediment());
        ingredientList.add(IngredientEnum.HAMBURGER.getIngrediment());
        Sandwich sandwich = new Sandwich(ingredientList);
        double totalCost = calculateIngredientsCost(ingredientList);
        assert totalCost == sandwich.getTotalCost();
    }

    @Test
    public void costXEGGCost() {

        Sandwich sandwich = new Sandwich(XEGG.getIngredientList());
        double totalCost = calculateIngredientsCost(XEGG.getIngredientList());
        assert totalCost == sandwich.getTotalCost();
    }

    @Test
    public void costXEGGBaconCost() {

        Sandwich sandwich = new Sandwich(XEGGBACON.getIngredientList());
        double totalCost = calculateIngredientsCost(XEGGBACON.getIngredientList());
        assert totalCost == sandwich.getTotalCost();
    }

    @Test
    public void costBaconCost() {

        Sandwich sandwich = new Sandwich(XBACON.getIngredientList());
        double totalCost = calculateIngredientsCost(XBACON.getIngredientList());
        assert totalCost == sandwich.getTotalCost();
    }

    @Test
    public void costBurgerCost() {

        Sandwich sandwich = new Sandwich(XBURGER.getIngredientList());
        double totalCost = calculateIngredientsCost(XBURGER.getIngredientList());
        assert totalCost == sandwich.getTotalCost();
    }


    private double calculateIngredientsCost(List<Ingredient> ingredients) {
        return ingredients.stream().mapToDouble(item -> item.getCost()).sum();
    }
}
