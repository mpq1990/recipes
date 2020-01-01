package com.example.recipes.converters;

import com.example.recipes.commands.CategoryCommand;
import com.example.recipes.commands.IngredientCommand;
import com.example.recipes.commands.NotesCommand;
import com.example.recipes.commands.RecipeCommand;
import com.example.recipes.model.Difficulty;
import com.example.recipes.model.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeCommandToRecipeTest {

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

    RecipeCommandToRecipe converter;

    @BeforeEach
    void setUp() {
        converter = new RecipeCommandToRecipe(
                new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure()),
                new CategoryCommandToCategory(),
                new NotesCommandToNotes()
        );
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new RecipeCommand()));
    }

    @Test
    void convert() {
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(ID);
        recipeCommand.setCookTime(COOK_TIME);
        recipeCommand.setPrepTime(PREP_TIME);
        recipeCommand.setDescription(DESCRIPTION);
        recipeCommand.setDifficulty(DIFFICULTY);
        recipeCommand.setDirections(DIRECTIONS);
        recipeCommand.setServings(SERVINGS);
        recipeCommand.setSource(SOURCE);
        recipeCommand.setUrl(URL);

        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(ID);
        recipeCommand.setNotesCommand(notesCommand);

        CategoryCommand categoryCommandOne = new CategoryCommand();
        categoryCommandOne.setId(ID);
        recipeCommand.getCategoryCommands().add(categoryCommandOne);

        CategoryCommand categoryCommandTwo = new CategoryCommand();
        categoryCommandTwo.setId(ID_TWO);
        recipeCommand.getCategoryCommands().add(categoryCommandTwo);

        IngredientCommand ingredientCommandOne = new IngredientCommand();
        ingredientCommandOne.setId(ID);
        recipeCommand.getIngredientCommands().add(ingredientCommandOne);

        IngredientCommand ingredientCommandTwo = new IngredientCommand();
        ingredientCommandTwo.setId(ID_TWO);
        recipeCommand.getIngredientCommands().add(ingredientCommandTwo);

        Recipe recipe  = converter.convert(recipeCommand);

        assertNotNull(recipe);
        assertEquals(ID, recipe.getId());
        assertEquals(COOK_TIME, recipe.getCookTime());
        assertEquals(PREP_TIME, recipe.getPrepTime());
        assertEquals(DESCRIPTION, recipe.getDescription());
        assertEquals(DIFFICULTY, recipe.getDifficulty());
        assertEquals(DIRECTIONS, recipe.getDirections());
        assertEquals(SERVINGS, recipe.getServings());
        assertEquals(SOURCE, recipe.getSource());
        assertEquals(URL, recipe.getUrl());
        assertEquals(ID, recipe.getNotes().getId());
        assertEquals(2, recipe.getCategories().size());
        assertEquals(2, recipe.getIngredients().size());
    }

    @Test
    void testIngredientEmptyInConvert() {
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(ID);
        recipeCommand.setCookTime(COOK_TIME);
        recipeCommand.setPrepTime(PREP_TIME);
        recipeCommand.setDescription(DESCRIPTION);
        recipeCommand.setDifficulty(DIFFICULTY);
        recipeCommand.setDirections(DIRECTIONS);
        recipeCommand.setServings(SERVINGS);
        recipeCommand.setSource(SOURCE);
        recipeCommand.setUrl(URL);

        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(ID);
        recipeCommand.setNotesCommand(notesCommand);

        CategoryCommand categoryCommandOne = new CategoryCommand();
        categoryCommandOne.setId(ID);
        recipeCommand.getCategoryCommands().add(categoryCommandOne);

        CategoryCommand categoryCommandTwo = new CategoryCommand();
        categoryCommandTwo.setId(ID_TWO);
        recipeCommand.getCategoryCommands().add(categoryCommandTwo);

        Recipe recipe  = converter.convert(recipeCommand);

        assertNotNull(recipe);
        assertEquals(ID, recipe.getId());
        assertEquals(COOK_TIME, recipe.getCookTime());
        assertEquals(PREP_TIME, recipe.getPrepTime());
        assertEquals(DESCRIPTION, recipe.getDescription());
        assertEquals(DIFFICULTY, recipe.getDifficulty());
        assertEquals(DIRECTIONS, recipe.getDirections());
        assertEquals(SERVINGS, recipe.getServings());
        assertEquals(SOURCE, recipe.getSource());
        assertEquals(URL, recipe.getUrl());
        assertEquals(ID, recipe.getNotes().getId());
        assertEquals(2, recipe.getCategories().size());
        assertEquals(0, recipe.getIngredients().size());
    }

    @Test
    void testCategoryEmptyInConvert() {
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(ID);
        recipeCommand.setCookTime(COOK_TIME);
        recipeCommand.setPrepTime(PREP_TIME);
        recipeCommand.setDescription(DESCRIPTION);
        recipeCommand.setDifficulty(DIFFICULTY);
        recipeCommand.setDirections(DIRECTIONS);
        recipeCommand.setServings(SERVINGS);
        recipeCommand.setSource(SOURCE);
        recipeCommand.setUrl(URL);

        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(ID);
        recipeCommand.setNotesCommand(notesCommand);

        Recipe recipe  = converter.convert(recipeCommand);

        assertNotNull(recipe);
        assertEquals(ID, recipe.getId());
        assertEquals(COOK_TIME, recipe.getCookTime());
        assertEquals(PREP_TIME, recipe.getPrepTime());
        assertEquals(DESCRIPTION, recipe.getDescription());
        assertEquals(DIFFICULTY, recipe.getDifficulty());
        assertEquals(DIRECTIONS, recipe.getDirections());
        assertEquals(SERVINGS, recipe.getServings());
        assertEquals(SOURCE, recipe.getSource());
        assertEquals(URL, recipe.getUrl());
        assertEquals(ID, recipe.getNotes().getId());
        assertEquals(0, recipe.getCategories().size());
        assertEquals(0, recipe.getIngredients().size());
    }

    @Test
    void testNotesEmptyInConvert() {
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(ID);
        recipeCommand.setCookTime(COOK_TIME);
        recipeCommand.setPrepTime(PREP_TIME);
        recipeCommand.setDescription(DESCRIPTION);
        recipeCommand.setDifficulty(DIFFICULTY);
        recipeCommand.setDirections(DIRECTIONS);
        recipeCommand.setServings(SERVINGS);
        recipeCommand.setSource(SOURCE);
        recipeCommand.setUrl(URL);

        Recipe recipe  = converter.convert(recipeCommand);

        assertNotNull(recipe);
        assertEquals(ID, recipe.getId());
        assertEquals(COOK_TIME, recipe.getCookTime());
        assertEquals(PREP_TIME, recipe.getPrepTime());
        assertEquals(DESCRIPTION, recipe.getDescription());
        assertEquals(DIFFICULTY, recipe.getDifficulty());
        assertEquals(DIRECTIONS, recipe.getDirections());
        assertEquals(SERVINGS, recipe.getServings());
        assertEquals(SOURCE, recipe.getSource());
        assertEquals(URL, recipe.getUrl());
        assertNull(recipe.getNotes());
        assertEquals(0, recipe.getCategories().size());
        assertEquals(0, recipe.getIngredients().size());
    }
}