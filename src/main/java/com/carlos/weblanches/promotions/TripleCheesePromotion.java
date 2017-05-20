package com.carlos.weblanches.promotions;

import com.carlos.weblanches.models.IngredientEnum;

public class TripleCheesePromotion extends TriplePromotion {

    public TripleCheesePromotion(Promotion nextPromotion) {
        super(nextPromotion, IngredientEnum.CHEESE);
    }

}
