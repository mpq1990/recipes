package com.example.recipes.services;

import com.example.recipes.model.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
