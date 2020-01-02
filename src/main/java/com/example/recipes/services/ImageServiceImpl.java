package com.example.recipes.services;

import com.example.recipes.model.Recipe;
import com.example.recipes.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {
    private final RecipeRepository recipeRepository;

    public ImageServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void saveImageFile(Long recipeId, MultipartFile file) {

        Recipe recipe = recipeRepository.findById(recipeId).orElse(null);

        if (recipe == null) {
            throw new RuntimeException("Could not find the recipe with id " + recipeId);
        }

        try {
            Byte[] bytesObjects = new Byte[file.getBytes().length];
            int i = 0;

            for (byte b : file.getBytes()) {
                bytesObjects[i++] = b;
            }

            recipe.setImage(bytesObjects);
            recipeRepository.save(recipe);

        } catch (IOException e) {
            log.error("An error has occurred while trying to save image for recipe with id " + recipeId);
            e.printStackTrace();
        }

        log.debug("Got a file!");
    }
}
