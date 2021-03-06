package com.carlos.weblanches.models;


import java.text.NumberFormat;

public class Ingredient {

    private final IngredientEnum ingredientEnum;
    private final String name;
    private final Double cost;

    public Ingredient(String name, Double cost, IngredientEnum ingredientEnum) {
        this.name = name;
        this.cost = cost;
        this.ingredientEnum = ingredientEnum;
    }

    public String getName() {
        return name;
    }

    public Double getCost() {
        return cost;
    }

    public String getFormattedPrice() {
        return NumberFormat.getCurrencyInstance().format(cost);
    }

    public IngredientEnum getIngredientEnum() {
        return ingredientEnum;
    }
}
