package com.example.recipes.controllers;

import com.example.recipes.model.Recipe;
import com.example.recipes.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/show/{id}")
    public String showById(@PathVariable String id, Model model) {
        Recipe recipe = recipeService.findById(Long.parseLong(id));
        recipe.getIngredients().forEach(ingredient -> {
            if(ingredient.getUnitOfMeasure() != null) {
                System.out.println(ingredient.getUnitOfMeasure().getUom());
            } else {
                System.out.println("it is null for ingredient " + ingredient.getDescription());
            }
        });
        model.addAttribute("recipe", recipeService.findById(Long.parseLong(id)));
        return "/recipe/show";
    }
}
