package com.example.recipes.controllers;

import com.example.recipes.commands.RecipeCommand;
import com.example.recipes.exceptions.NotFoundException;
import com.example.recipes.model.Recipe;
import com.example.recipes.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class RecipeControllerTest {
    @Mock
    RecipeService recipeService;

    @InjectMocks
    RecipeController recipeController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(recipeController).
                setControllerAdvice(new ControllerExceptionHandler()).
                build();
    }

    @Test
    void showById() throws Exception {

        Recipe recipe = new Recipe();
        recipe.setId(1L);

        when(recipeService.findById(anyLong())).thenReturn(recipe);

        mockMvc.perform(get("/recipe/1/show")).
                andExpect(status().isOk()).
                andExpect(view().name("/recipe/show")).
                andExpect(model().attributeExists("recipe"));
    }

    @Test
    void showByIdRecipeNotFound() throws Exception {
        when(recipeService.findById(anyLong())).thenThrow(NotFoundException.class);

        mockMvc.perform(get("/recipe/1/show")).
                andExpect(status().isNotFound()).
                andExpect(view().name("404Error"));
    }

    @Test
    void showByIdRecipeBadRequest() throws Exception {
        mockMvc.perform(get("/recipe/ssss/show")).
                andExpect(status().isBadRequest()).
                andExpect(view().name("400Error"));
    }

    @Test
    void createRecipeGetForm() throws Exception {
        RecipeCommand recipeCommand = new RecipeCommand();

        mockMvc.perform(get("/recipe/new")).
                andExpect(status().isOk()).
                andExpect(view().name("recipe/recipeForm")).
                andExpect(model().attributeExists("recipe"));
    }

    @Test
    void createRecipePostForm() throws Exception {
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(3L);

        when(recipeService.saveRecipeCommand(any())).thenReturn(recipeCommand);

        mockMvc.perform(post("/recipe").
                contentType(MediaType.APPLICATION_FORM_URLENCODED).
                param("id", "").
                param("description", "some description").
                param("directions", "some directions")).
                andExpect(status().is3xxRedirection()).
                andExpect(view().name("redirect:/recipe/3/show"));
    }

    @Test
    void createRecipePostFormCheckValidations() throws Exception {
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(3L);

        mockMvc.perform(post("/recipe").
                contentType(MediaType.APPLICATION_FORM_URLENCODED).
                param("id", "")).
                andExpect(status().isOk()).
                andExpect(view().name("recipe/recipeForm")).
                andExpect(model().attributeExists("recipe"));
    }

    @Test
    void updateRecipePostForm() throws Exception {
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(3L);

        when(recipeService.findCommandById(anyLong())).thenReturn(recipeCommand);

        mockMvc.perform(get("/recipe/1/update"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/recipeform"))
                .andExpect(model().attributeExists("recipe"));
    }

    @Test
    void deleteRecipe() throws Exception {
        mockMvc.perform(get("/recipe/1/delete")).
                andExpect(status().is3xxRedirection()).
                andExpect(view().name("redirect:/"));

        verify(recipeService, times(1)).deleteById(anyLong());
    }


}