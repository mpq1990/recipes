package com.example.recipes.controllers;

import com.example.recipes.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class IndexController {
    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping({"", "/", "/index", "/index.html"})
    public String getIndexPage(Model model) {
        log.debug("get index page");
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
