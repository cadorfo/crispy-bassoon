package com.carlos.weblanches.promotions;

public class PromotionChain {

    public static Promotion createChain() {
        Promotion lightPromotion = new LightPromotion(null);
        Promotion tripleCheesePromotion = new TripleCheesePromotion(lightPromotion);
        Promotion tripleBurgerPromotion = new TripleHamburgerPromotion(tripleCheesePromotion);
        return tripleBurgerPromotion;
    }

}
