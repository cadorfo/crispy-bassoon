package com.carlos.weblanches.models;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {

    private List<Double> discounts = new ArrayList<>();
    private List<Ingredient> ingredients;

    public Sandwich(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Double> getDiscounts() {
        return discounts;
    }

    public double getTotalCost() {
        return totalIngredientsCosts() - totalDiscounts();
    }

    private Double totalDiscounts() {
        return discounts.stream().mapToDouble(value -> value).sum();
    }

    private double totalIngredientsCosts() {
        return ingredients.stream().mapToDouble(item -> item.getCost()).sum();
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }
}
