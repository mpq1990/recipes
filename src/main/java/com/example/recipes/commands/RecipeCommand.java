package com.example.recipes.commands;

import com.example.recipes.model.Difficulty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipeCommand {
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Set<IngredientCommand> ingredientCommands = new HashSet<>();
    private Byte[] image;
    private Difficulty difficulty;
    private Set<CategoryCommand> categoryCommands = new HashSet<>();
    private NotesCommand notesCommand;
}
