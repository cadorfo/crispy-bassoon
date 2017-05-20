package com.carlos.weblanches.promotions;

import com.carlos.weblanches.models.Sandwich;

/**
 * Created by carlos on 20/05/17.
 */
public abstract class Promotion {

    Promotion nextPromotion = null;

    public Promotion(Promotion nextPromotion) {
        this.nextPromotion = nextPromotion;
    }

    public void execute(Sandwich sandwich) {
        if (isEligible(sandwich)) {
            applyPromotion(sandwich);
        }
        if (nextPromotion != null) {
            nextPromotion.execute(sandwich);
        }
    }

    abstract boolean isEligible(Sandwich sandwich);

    abstract Sandwich applyPromotion(Sandwich sandwich);
}
