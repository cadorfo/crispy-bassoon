package com.carlos.weblanches.promotions;

import com.carlos.weblanches.models.IngredientEnum;
import com.carlos.weblanches.models.Sandwich;

public class TriplePromotion extends Promotion {

    IngredientEnum ingredientEnum = IngredientEnum.HAMBURGER;

    public TriplePromotion(Promotion nextPromotion, IngredientEnum ingredientEnum) {
        super(nextPromotion);
        this.ingredientEnum = ingredientEnum;
    }

    @Override
    boolean isEligible(Sandwich sandwich) {
        return ingredientCount(sandwich) >= 3;
    }

    private Long ingredientCount(Sandwich sandwich) {
        return sandwich.getIngredients().stream().filter(item -> item.getIngredientEnum() == ingredientEnum).count();
    }

    @Override
    Sandwich applyPromotion(Sandwich sandwich) {
        Long numberOfExtraHamburgers = ingredientCount(sandwich) / 3;
        sandwich.getDiscounts().add(numberOfExtraHamburgers * ingredientEnum.getIngrediment().getCost());
        return sandwich;
    }
}
