import java.io.*;
import java.util.*;

public class LearningPathProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean weiterlernen = true;  // Ob Benutzer weiter lernen möchte

        System.out.println("Willkommen zum Lernprogramm!");  // Begrüßung

        while (weiterlernen) {
            // Sprachauswahl anzeigen
            System.out.println("Welche Programmiersprache möchtest du lernen?");
            System.out.println("1 - Python\n2 - Java\n3 - HTML\n4 - C++\n5 - PHP\n6 - MySQL");

            String eingabe = input.nextLine().trim().toLowerCase();  // Eingabe lesen 
            int wählen = -1;  // Sprache auswählen

            // Sprache erkennen
            switch (eingabe) {
                case "1": case "python":
                    wählen = 1; break;
                case "2": case "java":
                    wählen = 2; break;
                case "3": case "html":
                    wählen = 3; break;
                case "4": case "c++":
                    wählen = 4; break;
                case "5": case "php":
                    wählen = 5; break;
                case "6": case "mysql":
                    wählen = 6; break;
                default:
                    System.out.println("Ungültige Eingabe. Bitte gib eine Zahl (1-6) oder Sprache ein.");
                    continue;  // Zurück zum Anfang der Schleife
            }

            // Nach Vorkenntnissen fragen
            System.out.println("Hast du bereits Vorkenntnisse? 1 - Ja, \n2 - Nein:");
            String erfa = "";
            erfa = input.nextLine().trim().toLowerCase(); // قراءة المدخلات

            if (erfa.equals("ja") || erfa.equals("1")) {
                // Test anbieten
                System.out.println("Möchtest du einen Übungstest machen? 1 - Ja,\n 2 - Nein:");
                String test = input.nextLine();  // قراءة المدخلات من المستخدم

                if (test.equals("1")) {
                    String fileName = "";
                    // Dateiname für den Test wählen
                    switch (wählen) {
                        case 1: fileName = "python_test.txt"; break;
                        case 2: fileName = "java_test.txt"; break;
                        case 3: fileName = "html_test.txt"; break;
                        case 4: fileName = "cpp_test.txt"; break;
                        case 5: fileName = "php_test.txt"; break;
                        case 6: fileName = "mysql_test.txt"; break;
                    }

                    // Test starten
                    if (!fileName.isEmpty()) {
                        startTest(fileName, input);
                    }
                }

            } else if (erfa.equals("nein") || erfa.equals("2")) {
                // Kein Vorwissen → von vorne anfangen
                System.out.println("Du wirst von Anfang an beginnen.");
                // Hier kannst du später Lernmaterial anzeigen
            } else {
                System.out.println("Deine Eingabe konnte nicht bearbeitet werden.");
                continue;  // Wenn ungültige Eingabe, zurück zum Anfang
            }

            // Fragen ob der Benutzer weiter lernen will
            System.out.println("Möchtest du weiterlernen? (ja/nein)");
            String antwort = input.nextLine();
            if (!antwort.equalsIgnoreCase("ja")) {
                weiterlernen = false;
                System.out.println("Danke fürs Lernen! Viel Erfolg weiterhin!");
            }
        }
    }

    // Diese Methode liest den Test aus der Datei und fragt die Fragen
    static void startTest(String fileName, Scanner input) {
        int korrekt = 0;  // Zähler für richtige Antworten
        int falsch = 0;   // Zähler für falsche Antworten

        try {
            // Datei mit Fragen öffnen
            File file = new File("C:\\Users\\Student\\Desktop\\VS Code Projekte\\java\\aufgabe_schule\\Neuer Ordner\\" + fileName);
            Scanner reader = new Scanner(file);

            List<String> fragenBlock = new ArrayList<>();  // Fragenblock (mehrere Zeilen)
            String richtigeAntwort = "";

            // Datei Zeile für Zeile lesen
            while (reader.hasNextLine()) {
                String line = reader.nextLine();

                // Wenn Antwort gefunden wird
                if (line.startsWith("Antwort:")) {
                    richtigeAntwort = line.substring(8).trim();  // Richtige Antwort extrahieren

                    // Frage anzeigen
                    for (String frageLine : fragenBlock) {
                        System.out.println(frageLine);
                    }

                    // Benutzerantwort einlesen
                    System.out.print("Deine Antwort (1-4): ");
                    String userAntwort = input.nextLine();

                    // Antwort prüfen
                    if (userAntwort.equals(richtigeAntwort)) {
                        System.out.println("Richtig!\n");
                        korrekt++;
                    } else {
                        System.out.println("Falsch! Richtige Antwort war: " + richtigeAntwort + "\n");
                        falsch++;
                    }

                    fragenBlock.clear();  // Neue Frage vorbereiten
                } else {
                    fragenBlock.add(line);  // Zeile zur Frage hinzufügen
                }
            }

            // Ergebnis anzeigen الجواب
            System.out.println("\n--- Testergebnis ---");
            System.out.println("Richtige Antworten: " + korrekt);
            System.out.println("Falsche Antworten : " + falsch);

            // Feedback geben
            if (korrekt < 15) {
                System.out.println("\nLeider hast du weniger als 15 richtige Antworten gegeben.");
                System.out.println("Es scheint, dass du noch etwas üben musst. Schau dir diese YouTube-Videos an, um zu lernen:");
                // Hier kannst du Links einfügen
            } else {
                System.out.println("Wir schicken dich zu einem bestimmten Level.");  // Fortgeschrittenes Level
            }

            reader.close();  // Datei schließen
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen der Datei: " + e.getMessage());
        }
    }
}
