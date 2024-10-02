package org.example.mthaler;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Rechtschreibtrainer {
    private ArrayList<Word> words;
    private Word currentWord;
    private int currentWordIndex;
    private int correctAnswersTotal;
    private ReadWrite storage;

    public Rechtschreibtrainer() {
        this.storage = new JsonReadWrite();
        this.words = storage.read();
    }

    public void addWord(Word word) {
        this.words.add(word);
    }

    public void randomWord() {
        Random random = new Random();

        currentWordIndex = random.nextInt(this.words.size());
        this.currentWord = this.words.get(currentWordIndex);
    }

    public boolean checkWord(String eingabe) {
        currentWord.setTotalAnswers();
        if(eingabe.equals(this.currentWord.getName())) {
            currentWord.setCorrectAnswers();
            this.correctAnswersTotal++;
            this.saveValues();
            return true;
        } else {
            this.saveValues();
            return false;
        }
    }

    public Word getCurrentWord() {
        return currentWord;
    }

    private void saveValues() {
        this.words.set(currentWordIndex, currentWord);
        storage.write(this.words);
    }

    public int getCorrectAnswersTotal() {
        return correctAnswersTotal;
    }

    public ArrayList<Word> getWords() {
        return words;
    }
}

