package com.carlos.weblanches.controllers;

import com.carlos.weblanches.models.Ingredient;
import com.carlos.weblanches.models.IngredientEnum;
import com.carlos.weblanches.models.Sandwich;
import com.carlos.weblanches.promotions.PromotionChain;
import com.carlos.weblanches.services.MenuServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@Controller()
@RequestMapping("/customSandwich")
public class CustomSandwichController {

    @Autowired
    MenuServices menu;

    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        model.put("ingredients", menu.listIngredients());
        String brasil = "";
        return "customSandwich/index";
    }

    @RequestMapping(value = "/calculatePrice", method = RequestMethod.POST)
    public @ResponseBody
    Sandwich calculatePrice(@RequestBody Map<String, Integer> ingredients) {
        List<Ingredient> ingredientList = new ArrayList<>();
        ingredients.keySet().forEach(item -> {
            IntStream.range(0, Integer.valueOf(ingredients.get(item)))
                    .forEach(peekItem -> ingredientList.add(IngredientEnum.valueOf(item).getIngrediment()));
        });

        Sandwich sandwich = new Sandwich(ingredientList);
        PromotionChain.createChain().execute(sandwich);
        return sandwich;
    }
}
