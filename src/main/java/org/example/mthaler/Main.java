package org.example.mthaler;


import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        Rechtschreibtrainer trainer = new Rechtschreibtrainer();


        for(int i = 0; i < 5; i++) {
            trainer.randomWord();

            for (;;) {
                // Lade das Bild
                ImageIcon originalIcon = new ImageIcon(trainer.getCurrentWord().getImageURL());

                // Skaliere das Bild auf die gewünschte Größe (z.B. 100x100 Pixel)
                Image scaledImage = originalIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledImage);

                // Kombiniere Bild und Text
                Object[] message = {
                        "Was siehst du? " + trainer.getCurrentWord().getCorrectAnswers() + "/" + trainer.getCurrentWord().getTotalAnswers() + " richtig",
                        scaledIcon,
                };

                // Frage anzeigen
                String userInput = JOptionPane.showInputDialog(null, message, "Bild, Text und Eingabe", JOptionPane.PLAIN_MESSAGE);
                if (userInput == null) {
                    JOptionPane.showMessageDialog(null, "Programm abgebrochen", "Abbruch", JOptionPane.WARNING_MESSAGE);
                    System.exit(0); // Programm beenden
                }

                if(trainer.checkWord(userInput)) {
                    break;
                }
            }

        }

        JOptionPane.showMessageDialog(null, "Quiz abgeschlossen\n", "Fertig", JOptionPane.INFORMATION_MESSAGE);
        for (Word word : trainer.getWords()) {
            double correctAnswers = word.getCorrectAnswers();
            double totalAnswers = word.getTotalAnswers();
            double currentCorrectAnswers = word.getCurrentCorrectAnswers();
            double currentTotalAnswers = word.getCurrentTotalAnswers();

            double differenzAntworten = Math.abs((currentCorrectAnswers / currentTotalAnswers) - (correctAnswers / totalAnswers)) * 100;
            differenzAntworten = Math.floor(differenzAntworten * 100) / 100;
            if (currentCorrectAnswers/currentTotalAnswers >= correctAnswers/totalAnswers) {
                JOptionPane.showMessageDialog(null, "Congratulations! Das Wort \"" + word.getName() + "\" hast du um " + differenzAntworten +  "% Prozent besser beantwortet", "Besser geübt!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Leider hast du das Wort \"" + word.getName() + "\" um " + differenzAntworten +  "% Prozent schlechter beantwortet", "Nächstes Mal!", JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }


}
