package com.example.recipes.converters;

import com.example.recipes.commands.CategoryCommand;
import com.example.recipes.commands.IngredientCommand;
import com.example.recipes.commands.RecipeCommand;
import com.example.recipes.model.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {
    private final IngredientCommandToIngredient ingredientCommandToIngredient;
    private final CategoryCommandToCategory categoryCommandToCategory;
    private final NotesCommandToNotes notesCommandToNotes;

    public RecipeCommandToRecipe(IngredientCommandToIngredient ingredientCommandToIngredient,
                                 CategoryCommandToCategory categoryCommandToCategory,
                                 NotesCommandToNotes notesCommandToNotes) {
        this.ingredientCommandToIngredient = ingredientCommandToIngredient;
        this.categoryCommandToCategory = categoryCommandToCategory;
        this.notesCommandToNotes = notesCommandToNotes;
    }

    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand recipeCommand) {
        if (recipeCommand == null) {
            return null;
        }

        final Recipe recipe = new Recipe();
        recipe.setId(recipeCommand.getId());
        recipe.setCookTime(recipeCommand.getCookTime());
        recipe.setPrepTime(recipeCommand.getPrepTime());
        recipe.setDescription(recipeCommand.getDescription());
        recipe.setDifficulty(recipeCommand.getDifficulty());
        recipe.setDirections(recipeCommand.getDirections());
        recipe.setServings(recipeCommand.getServings());
        recipe.setSource(recipeCommand.getSource());
        recipe.setUrl(recipeCommand.getUrl());

        recipe.setNotes(notesCommandToNotes.convert(recipeCommand.getNotesCommand()));

        if (recipeCommand.getIngredientCommands() != null && recipeCommand.getIngredientCommands().size() > 0) {
            recipeCommand.getIngredientCommands().forEach((IngredientCommand command) ->
                    recipe.getIngredients().add(ingredientCommandToIngredient.convert(command)));
        }

        if (recipeCommand.getCategoryCommands() != null && recipeCommand.getCategoryCommands().size() > 0) {
            recipeCommand.getCategoryCommands().forEach((CategoryCommand command) ->
                    recipe.getCategories().add(categoryCommandToCategory.convert(command)));
        }

        return recipe;
    }
}
