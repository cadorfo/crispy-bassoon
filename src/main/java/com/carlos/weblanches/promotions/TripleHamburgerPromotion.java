package com.carlos.weblanches.promotions;

import com.carlos.weblanches.models.IngredientEnum;

public class TripleHamburgerPromotion extends TriplePromotion {

    public TripleHamburgerPromotion(Promotion nextPromotion) {
        super(nextPromotion, IngredientEnum.HAMBURGER);
    }

}
