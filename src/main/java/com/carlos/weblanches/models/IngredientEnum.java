package com.carlos.weblanches.models;

public enum IngredientEnum {
    BACON("Bacon", 2.0),
    LETTUCE("Alface", 0.4),
    HAMBURGER("Hambúrguer de carne", 3.0),
    EGG("Ovo", 0.8),
    CHEESE("Queijo", 1.5);

    private String name;
    private Double cost;

    IngredientEnum(String name, Double cost) {
        this.name = name;
        this.cost = cost;
    }

    public Ingredient getIngrediment() {
        return new Ingredient(name, cost, this);
    }
}
