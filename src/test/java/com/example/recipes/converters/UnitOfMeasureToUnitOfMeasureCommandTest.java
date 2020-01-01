package com.example.recipes.converters;

import com.example.recipes.commands.UnitOfMeasureCommand;
import com.example.recipes.model.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitOfMeasureToUnitOfMeasureCommandTest {

    private final String UOM = "TableSpoon";
    private final Long ID = 1L;

    UnitOfMeasureToUnitOfMeasureCommand converter;

    @BeforeEach
    void setUp() {
        converter = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @Test
    void testNullObjectConvert() throws Exception{
        assertNull(converter.convert(null));
    }

    @Test
    void testEmptyObjectConvert() throws Exception{
        assertNotNull(converter.convert(new UnitOfMeasure()));
    }

    @Test
    void convert() {
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(ID);
        unitOfMeasure.setUom(UOM);

        UnitOfMeasureCommand unitOfMeasureCommand = converter.convert(unitOfMeasure);

        assertEquals(ID, unitOfMeasureCommand.getId());
        assertEquals(UOM, unitOfMeasureCommand.getUom());
    }
}