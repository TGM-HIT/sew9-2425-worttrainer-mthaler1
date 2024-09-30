package org.example.mthaler;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonReadWrite extends ReadWrite {

    public JsonReadWrite() {

    }

    @Override
    public ArrayList<Word> read() {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<Word> words = new ArrayList<>();

        try {
            // Lade die Wörter aus der JSON-Datei
            words = (ArrayList<Word>) objectMapper.readValue(new File("data/data.json"), new TypeReference<List<Word>>() {});
        } catch (IOException e) {
            throw new IllegalArgumentException("Dateienpfad nicht gefunden.");
        }

        return words; // Gebe die Liste von Wörtern zurück
    }

    @Override
    public void write(ArrayList<Word> words) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Schreibe die neue Liste in die Datei (überschreibt die vorhandene Datei)
            objectMapper.writeValue(new File("data/data.json"), words);
            System.out.println("Daten erfolgreich in data.json geschrieben.");
        } catch (IOException e) {
            e.printStackTrace(); // Protokolliere den Fehler
        }
    }
}
