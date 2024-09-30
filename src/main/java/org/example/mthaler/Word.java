package org.example.mthaler;

import java.net.MalformedURLException;
import java.net.URL;

public class Word {
    private String name;
    private String imageURL;
    private int totalAnswers;
    private int correctAnswers;

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

    public void setTotalAnswers() {
        this.totalAnswers += 1;
    }

    public void setCorrectAnswers() {
        this.correctAnswers += 1;
    }
}

