package com.example.recipes.services;

import com.example.recipes.commands.RecipeCommand;
import com.example.recipes.converters.RecipeCommandToRecipe;
import com.example.recipes.converters.RecipeToRecipeCommand;
import com.example.recipes.exceptions.NotFoundException;
import com.example.recipes.model.Recipe;
import com.example.recipes.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeToRecipeCommand recipeToRecipeCommand;
    private final RecipeCommandToRecipe recipeCommandToRecipe;

    public RecipeServiceImpl(RecipeRepository recipeRepository,
                             RecipeToRecipeCommand recipeToRecipeCommand,
                             RecipeCommandToRecipe recipeCommandToRecipe) {
        this.recipeRepository = recipeRepository;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("I am in the service");
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;
    }

    @Override
    public Recipe findById(Long id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
//        return recipe.orElse(null);
        if (!recipe.isPresent()) {
            throw new NotFoundException("Recipe Not found. Recipe Id: " + id.toString());
        }
        return recipe.get();
    }

    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand command) {
        Recipe detachedRecipe = recipeCommandToRecipe.convert(command);
        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
        log.debug("Recipe saved with id: " + savedRecipe.getId());
        return recipeToRecipeCommand.convert(savedRecipe);
    }

    @Override
    @Transactional
    public RecipeCommand findCommandById(Long id) {
        return recipeToRecipeCommand.convert(findById(id));
    }

    @Override
    public void deleteById(Long id) {
        recipeRepository.deleteById(id);
    }
}
