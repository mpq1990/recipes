package com.example.recipes.controllers;

import com.example.recipes.commands.RecipeCommand;
import com.example.recipes.services.ImageService;
import com.example.recipes.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class ImageControllerTest {
    @Mock
    ImageService imageService;

    @Mock
    RecipeService recipeService;

    ImageController imageController;
    MockMvc mockMvc;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        imageController = new ImageController(recipeService, imageService);
        mockMvc = MockMvcBuilders.standaloneSetup(imageController).build();
    }

    @Test
    void showUploadForm() throws Exception {
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(1L);

        when(recipeService.findCommandById(anyLong())).
                thenReturn(recipeCommand);

        mockMvc.perform(get("/recipe/1/image")).
                andExpect(status().isOk()).
                andExpect(view().name("recipe/imageuploadform")).
                andExpect(model().attributeExists("recipe"));
    }

    @Test
    void handleImagePost() throws Exception {
        MockMultipartFile mockMultipartFile = new MockMultipartFile(
                "imagefile",
                "testing.txt",
                "text/plain",
                "some text here".getBytes());

        mockMvc.perform(multipart("/recipe/1/image").file(mockMultipartFile)).
                andExpect(status().is3xxRedirection()).
                andExpect(header().string("Location", "/recipe/1/show"));

        verify(imageService, times(1)).saveImageFile(anyLong(), any());

    }

    @Test
    void handleImageFromDb() throws Exception {
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(1L);

        String storedString = "some test text";
        Byte[] bytesInDb = new Byte[storedString.getBytes().length];

        int i = 0;

        for (byte byteStored : storedString.getBytes()) {
            bytesInDb[i++] = byteStored;
        }

        recipeCommand.setImage(bytesInDb);

        when(recipeService.findCommandById(anyLong())).thenReturn(recipeCommand);

        MockHttpServletResponse response = mockMvc.perform(get("/recipe/1/recipeimage")).
                andExpect(status().isOk()).
                andReturn().getResponse();

        byte[] responseBytes = response.getContentAsByteArray();

        assertEquals(storedString.getBytes().length, responseBytes.length);
    }
}