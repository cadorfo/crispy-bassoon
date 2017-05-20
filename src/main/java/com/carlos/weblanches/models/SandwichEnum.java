package com.carlos.weblanches.models;

import java.util.Arrays;
import java.util.List;

import static com.carlos.weblanches.models.IngredientEnum.*;

/**
 * Created by carlos on 20/05/17.
 */
public enum SandwichEnum {
    XBACON, XBURGER, XEGG, XEGGBACON;

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

    private List<Ingredient> ingredientList;

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }
}
