package com.blecua84.wordsinbinarytree.services;

import com.blecua84.wordsinbinarytree.models.Word;

import java.util.List;

public interface WordService {

    List<Word> extractWordWithWeightFromString(String inputPhrase);
}
