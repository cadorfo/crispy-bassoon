package com.carlos.weblanches.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Sandwich {

    private SandwichEnum sandwichEnum;
    private List<Double> discounts = new ArrayList<>();
    private List<Ingredient> ingredients;

    public Sandwich(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Sandwich(SandwichEnum sandwichEnum) {
        this.ingredients = sandwichEnum.getIngredientList();
        this.sandwichEnum = sandwichEnum;
    }

    @JsonIgnore
    public String getName() {
        return sandwichEnum.getName();
    }

    @JsonIgnore
    public List<Double> getDiscounts() {
        return discounts;
    }

    public double getTotalCost() {
        return totalIngredientsCosts() - totalDiscounts();
    }

    @JsonGetter
    private Double totalDiscounts() {
        return discounts.stream().mapToDouble(value -> value).sum();
    }

    private double totalIngredientsCosts() {
        return ingredients.stream().mapToDouble(item -> item.getCost()).sum();
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public String getFormattedPrice() {
        return NumberFormat.getCurrencyInstance().format(getTotalCost());
    }
}
