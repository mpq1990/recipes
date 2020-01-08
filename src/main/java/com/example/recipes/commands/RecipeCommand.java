package com.example.recipes.commands;

import com.example.recipes.model.Difficulty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipeCommand {
    private Long id;

    @NotBlank
    @Size(min = 1, max = 255)
    private String description;

    @Min(1)
    @Max(1000)
    private Integer prepTime;

    @Min(1)
    @Max(1000)
    private Integer cookTime;

    @Min(1)
    @Max(1000)
    private Integer servings;

    private String source;

    @URL
    private String url;

    @NotBlank
    private String directions;

    private Set<IngredientCommand> ingredientCommands = new HashSet<>();
    private Byte[] image;
    private Difficulty difficulty;
    private Set<CategoryCommand> categoryCommands = new HashSet<>();
    private NotesCommand notesCommand;
}
