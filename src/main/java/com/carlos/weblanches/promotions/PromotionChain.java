package com.carlos.weblanches.promotions;

public class PromotionChain {

    private static Promotion promotion = null;

    private PromotionChain() {

    }

    public static Promotion getChain() {
        if(promotion == null) {
          promotion = createChain();
        }
        return promotion;
    }

    private static Promotion createChain() {
        Promotion lightPromotion = new LightPromotion(null);
        Promotion tripleCheesePromotion = new TripleCheesePromotion(lightPromotion);
        Promotion tripleBurgerPromotion = new TripleHamburgerPromotion(tripleCheesePromotion);
        return tripleBurgerPromotion;
    }

}
