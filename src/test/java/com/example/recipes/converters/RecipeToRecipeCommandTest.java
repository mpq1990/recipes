package com.example.recipes.converters;

import com.example.recipes.commands.RecipeCommand;
import com.example.recipes.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

class RecipeToRecipeCommandTest {

    public static final Long ID = 1L;
    public static final Long ID_TWO = 2L;
    public static final Integer COOK_TIME = 20;
    public static final Integer PREP_TIME = 30;
    public static final String DESCRIPTION = "Korean Chicken";
    public static final String DIRECTIONS = "Very hard directions";
    public static final Difficulty DIFFICULTY = Difficulty.HARD;
    public static final Integer SERVINGS = 4;
    public static final String SOURCE = "Some Awesome Recipe website";
    public static final String URL = "Some url of the awesome website";

    RecipeToRecipeCommand converter;

    @BeforeEach
    void setUp() {
        converter = new RecipeToRecipeCommand(
                new CategoryToCategoryCommand(),
                new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand()),
                new NotesToNotesCommand());
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Recipe()));
    }

    @Test
    void convert() throws Exception{
        Recipe recipe = new Recipe();
        recipe.setId(ID);
        recipe.setCookTime(COOK_TIME);
        recipe.setPrepTime(PREP_TIME);
        recipe.setDescription(DESCRIPTION);
        recipe.setDifficulty(DIFFICULTY);
        recipe.setDirections(DIRECTIONS);
        recipe.setServings(SERVINGS);
        recipe.setSource(SOURCE);
        recipe.setUrl(URL);

        Notes notes = new Notes();
        notes.setId(ID);
        recipe.setNotes(notes);

        Category categoryOne = new Category();
        categoryOne.setId(ID);
        recipe.getCategories().add(categoryOne);

        Category categoryTwo = new Category();
        categoryTwo.setId(ID_TWO);
        recipe.getCategories().add(categoryTwo);

        Ingredient ingredientOne = new Ingredient();
        ingredientOne.setId(ID);
        recipe.getIngredients().add(ingredientOne);

        Ingredient ingredientTwo = new Ingredient();
        ingredientTwo.setId(ID_TWO);
        recipe.getIngredients().add(ingredientTwo);

        RecipeCommand recipeCommand = converter.convert(recipe);

        assertNotNull(recipeCommand);
        assertEquals(ID, recipeCommand.getId());
        assertEquals(COOK_TIME, recipeCommand.getCookTime());
        assertEquals(PREP_TIME, recipeCommand.getPrepTime());
        assertEquals(DESCRIPTION, recipeCommand.getDescription());
        assertEquals(DIFFICULTY, recipeCommand.getDifficulty());
        assertEquals(DIRECTIONS, recipeCommand.getDirections());
        assertEquals(SERVINGS, recipeCommand.getServings());
        assertEquals(SOURCE, recipeCommand.getSource());
        assertEquals(URL, recipeCommand.getUrl());
        assertEquals(ID, recipeCommand.getNotesCommand().getId());
        assertEquals(2, recipeCommand.getCategoryCommands().size());
        assertEquals(2, recipeCommand.getIngredientCommands().size());
    }

    @Test
    void TestEmptyIngredientsCategoryWithConvert() throws Exception{
        Recipe recipe = new Recipe();
        recipe.setId(ID);
        recipe.setCookTime(COOK_TIME);
        recipe.setPrepTime(PREP_TIME);
        recipe.setDescription(DESCRIPTION);
        recipe.setDifficulty(DIFFICULTY);
        recipe.setDirections(DIRECTIONS);
        recipe.setServings(SERVINGS);
        recipe.setSource(SOURCE);
        recipe.setUrl(URL);

        Notes notes = new Notes();
        notes.setId(ID);
        recipe.setNotes(notes);

        RecipeCommand recipeCommand = converter.convert(recipe);

        assertNotNull(recipeCommand);
        assertEquals(ID, recipeCommand.getId());
        assertEquals(COOK_TIME, recipeCommand.getCookTime());
        assertEquals(PREP_TIME, recipeCommand.getPrepTime());
        assertEquals(DESCRIPTION, recipeCommand.getDescription());
        assertEquals(DIFFICULTY, recipeCommand.getDifficulty());
        assertEquals(DIRECTIONS, recipeCommand.getDirections());
        assertEquals(SERVINGS, recipeCommand.getServings());
        assertEquals(SOURCE, recipeCommand.getSource());
        assertEquals(URL, recipeCommand.getUrl());
        assertEquals(ID, recipeCommand.getNotesCommand().getId());
        assertEquals(0, recipeCommand.getCategoryCommands().size());
        assertEquals(0, recipeCommand.getIngredientCommands().size());
    }
}