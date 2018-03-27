package com.blecua84.wordsinbinarytree.services.impl;

import com.blecua84.wordsinbinarytree.models.Word;
import com.blecua84.wordsinbinarytree.services.WordService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WordServiceImpl implements WordService {

    private static final String EMPTY_CHAR = " ";

    @Override
    public List<Word> extractWordWithWeightFromString(String inputPhrase) {
        List<Word> words = null;

        if(inputPhrase != null && !inputPhrase.isEmpty()) {
            words = new ArrayList<>();
            String[] inputWords = inputPhrase.split(EMPTY_CHAR);
            Optional<Word> currentOptionalWord;

            for(String inputWord: inputWords) {
                currentOptionalWord = words.stream().filter(word -> inputWord.equals(word.getValue())).findFirst();

                if (!currentOptionalWord.isPresent())
                    words.add(new Word(inputWord));
                else {
                    currentOptionalWord.get().increaseWeight();
                }
            }
        }

        return words;
    }
}
