package com.example.recipes.bootstrap;

import com.example.recipes.model.Category;
import com.example.recipes.model.UnitOfMeasure;
import com.example.recipes.repositories.CategoryRepository;
import com.example.recipes.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile({"dev", "prod"})
public class DataLoaderSQL implements ApplicationListener<ContextRefreshedEvent> {
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public DataLoaderSQL(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (categoryRepository.count() == 0L){
            log.debug("Loading Categories");
            loadCategories();
        }

        if (unitOfMeasureRepository.count() == 0L){
            log.debug("Loading unit of measurements");
            loadUnitOfMeasurements();
        }
    }

    private void loadCategories(){
        Category cat1 = new Category();
        cat1.setDescription("German");
        categoryRepository.save(cat1);

        Category cat2 = new Category();
        cat2.setDescription("Chinese");
        categoryRepository.save(cat2);

        Category cat3 = new Category();
        cat3.setDescription("Indian");
        categoryRepository.save(cat3);

        Category cat4 = new Category();
        cat4.setDescription("Thai");
        categoryRepository.save(cat4);

        Category cat5= new Category();
        cat5.setDescription("Mexican");
        categoryRepository.save(cat5);

        Category cat6 = new Category();
        cat6.setDescription("American");
        categoryRepository.save(cat6);
    }

    private void loadUnitOfMeasurements(){
        UnitOfMeasure unitOfMeasurement1 = new UnitOfMeasure();
        unitOfMeasurement1.setUom("Tablespoon");
        unitOfMeasureRepository.save(unitOfMeasurement1);

        UnitOfMeasure unitOfMeasurement2 = new UnitOfMeasure();
        unitOfMeasurement2.setUom("Teaspoon");
        unitOfMeasureRepository.save(unitOfMeasurement2);

        UnitOfMeasure unitOfMeasurement3 = new UnitOfMeasure();
        unitOfMeasurement3.setUom("Cup");
        unitOfMeasureRepository.save(unitOfMeasurement3);

        UnitOfMeasure unitOfMeasurement4 = new UnitOfMeasure();
        unitOfMeasurement4.setUom("Ounce");
        unitOfMeasureRepository.save(unitOfMeasurement4);

        UnitOfMeasure unitOfMeasurement5 = new UnitOfMeasure();
        unitOfMeasurement5.setUom("Pinch");
        unitOfMeasureRepository.save(unitOfMeasurement5);

        UnitOfMeasure unitOfMeasurement6 = new UnitOfMeasure();
        unitOfMeasurement6.setUom("Dash");
        unitOfMeasureRepository.save(unitOfMeasurement6);

        UnitOfMeasure unitOfMeasurement7 = new UnitOfMeasure();
        unitOfMeasurement7.setUom("Pint");
        unitOfMeasureRepository.save(unitOfMeasurement7);

        UnitOfMeasure unitOfMeasurement8 = new UnitOfMeasure();
        unitOfMeasurement8.setUom("Clove");
        unitOfMeasureRepository.save(unitOfMeasurement8);
        
        UnitOfMeasure unitOfMeasurement9 = new UnitOfMeasure();
        unitOfMeasurement9.setUom("Pound");
        unitOfMeasureRepository.save(unitOfMeasurement9);

        UnitOfMeasure unitOfMeasurement10 = new UnitOfMeasure();
        unitOfMeasurement10.setUom("Small");
        unitOfMeasureRepository.save(unitOfMeasurement10);

        UnitOfMeasure unitOfMeasurement11 = new UnitOfMeasure();
        unitOfMeasurement11.setUom("Sliced");
        unitOfMeasureRepository.save(unitOfMeasurement11);

        UnitOfMeasure unitOfMeasurement12 = new UnitOfMeasure();
        unitOfMeasurement12.setUom("Clove");
        unitOfMeasureRepository.save(unitOfMeasurement12);

        UnitOfMeasure unitOfMeasurement13 = new UnitOfMeasure();
        unitOfMeasurement13.setUom("Chopped");
        unitOfMeasureRepository.save(unitOfMeasurement13);

        UnitOfMeasure unitOfMeasurement14 = new UnitOfMeasure();
        unitOfMeasurement14.setUom("Wedge");
        unitOfMeasureRepository.save(unitOfMeasurement14);

        UnitOfMeasure unitOfMeasurement15 = new UnitOfMeasure();
        unitOfMeasurement15.setUom("Minced");
        unitOfMeasureRepository.save(unitOfMeasurement15);

        UnitOfMeasure unitOfMeasurement16 = new UnitOfMeasure();
        unitOfMeasurement16.setUom("Each");
        unitOfMeasureRepository.save(unitOfMeasurement16);
    }
}
