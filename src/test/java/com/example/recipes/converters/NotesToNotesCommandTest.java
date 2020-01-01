package com.example.recipes.converters;

import com.example.recipes.commands.NotesCommand;
import com.example.recipes.model.Notes;
import com.example.recipes.model.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

class NotesToNotesCommandTest {


    public static final Long ID = 1L;
    public static final String NOTES = "Some Notes";

    NotesToNotesCommand converter;

    @Test
    void testNullParameter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Notes()));
    }

    @BeforeEach
    void setUp() {
        converter = new NotesToNotesCommand();
    }

    @Test
    void convert() {
        Notes notes = new Notes();
        notes.setId(ID);
        notes.setRecipeNotes(NOTES);

        NotesCommand notesCommand = converter.convert(notes);


        assertEquals(ID, notesCommand.getId());
        assertEquals(NOTES, notesCommand.getRecipeNotes());
    }
}