package com.carlos.weblanches.models;

import java.util.Arrays;
import java.util.List;

import static com.carlos.weblanches.models.IngredientEnum.*;

/**
 * Created by carlos on 20/05/17.
 */
public enum SandwichEnum {
    XBACON("X-Bacon"), XBURGER("X-Burger"), XEGG("X-Egg"), XEGGBACON("X-Egg-Bacon");

    static {
        XBACON.ingredientList = Arrays.asList(
                BACON.getIngrediment(),
                HAMBURGER.getIngrediment(),
                CHEESE.getIngrediment());

        XBURGER.ingredientList = Arrays.asList(
                HAMBURGER.getIngrediment(),
                CHEESE.getIngrediment()
        );

        XEGG.ingredientList = Arrays.asList(
                EGG.getIngrediment(),
                HAMBURGER.getIngrediment(),
                CHEESE.getIngrediment()
        );

        XEGGBACON.ingredientList = Arrays.asList(
                EGG.getIngrediment(),
                BACON.getIngrediment(),
                HAMBURGER.getIngrediment(),
                CHEESE.getIngrediment()
        );
    }

    private final String name;

    private List<Ingredient> ingredientList;


    SandwichEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }
}
