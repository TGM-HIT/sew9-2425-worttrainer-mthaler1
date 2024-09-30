package org.example.mthaler;

import jdk.jfr.Name;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class TestWorttrainer {

    private ArrayList<Word> words;
    private Rechtschreibtrainer trainer;
    private ReadWrite storage;

    @BeforeEach
    public void setUp() {
        words = new ArrayList<>();
        words.add(new Word("Baum", "img/tree.jpg", 0, 0));
        words.add(new Word("Hund", "img/dog.png", 0, 0));
        storage = new JsonReadWrite();
        trainer = new Rechtschreibtrainer();
    }

    @Test
    @Name("Es wird getestet, ob aus dem JSON-File richtig gelesen wird")
    public void testReadJSONData() {
        ArrayList<Word> result = storage.read();

        assertNotNull(result, "Die Liste sollte nicht null sein.");

        assertTrue(result.size() > 0, "Die Liste sollte Wörter enthalten.");
    }

    @Test
    @Name("Es wird getestet, ob in das JSON-File richtig geschrieben wird")
    public void testWriteJSONData() {
        storage.write(words);

        ArrayList<Word> result = storage.read();

        assertEquals(words.size(), result.size(), "Die gespeicherte und gelesene Liste sollten gleich groß sein.");
        assertEquals(words.get(0).getName(), result.get(0).getName(), "Die Namen des ersten Wortes sollten übereinstimmen.");
        assertEquals(words.get(1).getImageURL(), result.get(1).getImageURL(), "Die Bild-URLs sollten übereinstimmen.");
    }

}
