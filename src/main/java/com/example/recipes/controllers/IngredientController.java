package com.example.recipes.controllers;

import com.example.recipes.commands.IngredientCommand;
import com.example.recipes.commands.RecipeCommand;
import com.example.recipes.services.IngredientService;
import com.example.recipes.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IngredientController {

    private RecipeService recipeService;
    private IngredientService ingredientService;

    public IngredientController(RecipeService recipeService, IngredientService ingredientService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
    }

    @RequestMapping("/recipe/{id}/ingredients")
    public String listIngredients(@PathVariable String id, Model model) {
        log.debug("getting the list of ingredients for the recipe with id: " + id);
        RecipeCommand recipeCommand = recipeService.findCommandById(Long.valueOf(id));

        model.addAttribute("recipe", recipeCommand);
        return "recipe/ingredient/list";
    }

    @GetMapping
    @RequestMapping("/recipe/{recipeId}/ingredient/{id}/show")
    public String showIngredient(@PathVariable String recipeId, @PathVariable String id, Model model) {
        IngredientCommand ingredientCommand = ingredientService.
                findByRecipeIdAndIngredientId(Long.valueOf(recipeId), Long.valueOf(id));
        model.addAttribute("ingredient", ingredientCommand);
        return "recipe/ingredient/show";
    }
}
