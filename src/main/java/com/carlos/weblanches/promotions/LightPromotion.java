package com.carlos.weblanches.promotions;

import com.carlos.weblanches.models.IngredientEnum;
import com.carlos.weblanches.models.Sandwich;

/**
 * Created by carlos on 20/05/17.
 */
public class LightPromotion extends Promotion {
    public LightPromotion(Promotion promotion) {
        super(promotion);
    }

    @Override
    boolean isEligible(Sandwich sandwich) {
        return !constainsBacon(sandwich) && constainsLettuce(sandwich);
    }

    private boolean constainsLettuce(Sandwich sandwich) {
        return sandwich.getIngredients().stream().anyMatch(item -> item.getIngredientEnum() == IngredientEnum.LETTUCE);
    }

    private boolean constainsBacon(Sandwich sandwich) {
        return sandwich.getIngredients().stream().anyMatch(item -> item.getIngredientEnum() == IngredientEnum.BACON);
    }

    @Override
    Sandwich applyPromotion(Sandwich sandwich) {
        sandwich.getDiscounts().add(sandwich.getTotalCost() * 0.1);
        return sandwich;
    }
}
