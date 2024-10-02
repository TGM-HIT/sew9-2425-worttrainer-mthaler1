package org.example.mthaler;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.net.MalformedURLException;
import java.net.URL;

public class Word {
    private String name;
    private String imageURL;
    private int totalAnswers;
    private int correctAnswers;
    @JsonIgnore
    private int currentTotalAnswers = 0;
    @JsonIgnore
    private int currentCorrectAnswers = 0;

    public Word() {}


    public Word(String name, String imageURL, int totalAnswers, int correctAnswers) {
        if(name.equals("")) {
            throw new IllegalArgumentException("Wort ist leer.");
        }
        if(imageURL.equals("")) {
            throw new IllegalArgumentException("URL ist leer.");
        }
        this.name = name;
        this.imageURL = imageURL;
        this.totalAnswers = totalAnswers;
        this.correctAnswers = correctAnswers;

    }

    public String getName() {
        return name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public int getTotalAnswers() {
        return totalAnswers;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public int getCurrentTotalAnswers() {
        return currentTotalAnswers;
    }

    public int getCurrentCorrectAnswers() {
        return currentCorrectAnswers;
    }

    public void setTotalAnswers() {
        this.totalAnswers += 1;
        this.currentTotalAnswers += 1;
    }

    public void setCorrectAnswers() {
        this.correctAnswers += 1;
        this.currentCorrectAnswers += 1;
    }
}

