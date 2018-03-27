package com.blecua84.wordsinbinarytree.services;

import com.blecua84.wordsinbinarytree.models.Word;
import com.blecua84.wordsinbinarytree.services.impl.WordServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class WordServiceTest {

    private WordService wordService;

    @Before
    public void init() {
        this.wordService = new WordServiceImpl();
    }

    @Test
    public void class_shouldExist() throws ClassNotFoundException {
        assertNotNull(Class.forName("com.blecua84.wordsinbinarytree.services.impl.WordServiceImpl"));
    }

    @Test
    public void extractWordWithWeightFromString_shouldExist() throws ClassNotFoundException, NoSuchMethodException {
        Class WordService = Class.forName("com.blecua84.wordsinbinarytree.services.impl.WordServiceImpl");

        assertNotNull(WordService.getMethod("extractWordWithWeightFromString", String.class));
        assertEquals(List.class, WordService.getMethod("extractWordWithWeightFromString", String.class).getReturnType());
    }

    @Test
    public void extractWordWithWeightFromString_inputStringAsNull_shouldReturnNullValue() {
        assertNull(wordService.extractWordWithWeightFromString(null));
    }

    @Test
    public void extractWordWithWeightFromString_inputStringAsEmpty_shouldReturnNullValue() {
        assertNull(wordService.extractWordWithWeightFromString(""));
    }

    @Test
    public void extractWordWithWeightFromString_inputStringWithOneWord_shouldReturnAListWithOneValueAndWeightOne() {
        List<Word> result = wordService.extractWordWithWeightFromString("First");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("First", result.get(0).getValue());
        assertEquals(1, result.get(0).getWeight());
    }

    @Test
    public void extractWordWithWeightFromString_inputStringWithTwoSameWord_shouldReturnAListWithOneValueAndWeightTwo() {
        List<Word> result = wordService.extractWordWithWeightFromString("First First");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("First", result.get(0).getValue());
        assertEquals(2, result.get(0).getWeight());
    }

    @Test
    public void extractWordWithWeightFromString_inputStringWithTwoDifferentWords_shouldReturnAListWithTwoObjectsWithWeightOne() {
        List<Word> result = wordService.extractWordWithWeightFromString("First Element");

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("First", result.get(0).getValue());
        assertEquals(1, result.get(0).getWeight());
        assertEquals("Element", result.get(1).getValue());
        assertEquals(1, result.get(1).getWeight());
    }

    @Test
    public void extractWordWithWeightFromString_inputStringWithDifferentWords_shouldReturnAListProperly() {
        List<Word> result = wordService.extractWordWithWeightFromString("ant boat row ant car ant die ant boat row ant");

        assertNotNull(result);
        assertEquals(5, result.get(0).getWeight());
        assertEquals("ant", result.get(0).getValue());
        assertEquals(2, result.get(1).getWeight());
        assertEquals("boat", result.get(1).getValue());
        assertEquals(2, result.get(2).getWeight());
        assertEquals("row", result.get(2).getValue());
        assertEquals(1, result.get(3).getWeight());
        assertEquals("car", result.get(3).getValue());
        assertEquals(1, result.get(4).getWeight());
        assertEquals("die", result.get(4).getValue());
    }
}
