package com.blecua84.wordsinbinarytree.models;

public class Word {

    private String value;
    private int weight;

    public Word(String value) {
        this.value = value;
        this.weight = 1;
    }

    public String getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }

    public void increaseWeight() {
        this.weight++;
    }
}
