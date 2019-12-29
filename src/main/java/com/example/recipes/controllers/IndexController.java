package com.example.recipes.controllers;

import com.example.recipes.model.Category;
import com.example.recipes.model.UnitOfMeasure;
import com.example.recipes.repositories.CategoryRepository;
import com.example.recipes.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getIndexPage() {
        Optional<Category> categoryOptional = categoryRepository.findByDescription("Indian");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByUom("Pinch");

        System.out.println("Cat id is: " + categoryOptional.get().getId());
        System.out.println("Cat id is: " + unitOfMeasureOptional.get().getId());
        return "index";
    }
}
