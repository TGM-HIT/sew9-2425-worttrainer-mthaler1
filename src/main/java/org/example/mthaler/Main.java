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

        JOptionPane.showMessageDialog(null, "Quiz abgeschlossen\n" + trainer.getCorrectAnswersTotal() + "/5 Fragen richtig", "Fertig", JOptionPane.INFORMATION_MESSAGE);
    }


}
