package com.carlos.weblanches.services;

import com.carlos.weblanches.models.Ingredient;
import com.carlos.weblanches.models.IngredientEnum;
import com.carlos.weblanches.models.Sandwich;
import com.carlos.weblanches.models.SandwichEnum;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component()
public class MenuServices {

    public List<Sandwich> listSandwitches() {
        return Arrays.stream(SandwichEnum.values())
                .map(Sandwich::new)
                .collect(Collectors.toList());
    }

    public List<Ingredient> listIngredients() {
        return Arrays.stream(IngredientEnum.values())
                .map(IngredientEnum::getIngrediment)
                .collect(Collectors.toList());
    }
}
