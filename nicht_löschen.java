import java.util.Scanner;
import java.io.*;
import java.util.*;

public class LearningPathProgram {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean weiterlernen = true;

        System.out.println("Willkommen zum Lernprogramm!");

        while (weiterlernen) {
            System.out.println("Welche Programmiersprache möchtest du lernen?");
            System.out.println("1- Python, 2- Java, 3 - HTML, 4 - C++, 5 - PHP , 6 - MySQL");
            int wählen = input.nextInt();
            input.nextLine();  // Leeren des Puffers (بعد إدخال الرقم، يتم مسح السطر الجديد الذي يتم إدخاله)

            String erfa = "";
            System.out.println("Hast du bereits Vorkenntnisse? 1 - Ja, 2 - Nein:");
            erfa = input.nextLine();  // استخدم nextLine للحصول على الإجابة بشكل صحيح

            if (erfa.equalsIgnoreCase("ja") || erfa.equalsIgnoreCase("1")) {
                System.out.println("Möchtest du einen Übungstest machen? 1 - Ja, 2 - Nein:");
                String test = input.nextLine();

                if (test.equals("1")) {
                    String fileName = "";
                    switch (wählen) {
                        case 1:
                            fileName = "python_test.txt";
                            break;
                        case 2:
                            fileName = "java_test.txt";
                            break;
                        case 3:
                            fileName = "html_test.txt";
                            break;
                        case 4:
                            fileName = "cpp_test.txt";
                            break;
                        case 5:
                            fileName = "php_test.txt";
                            break;
                        case 6:
                            fileName = "mysql_test.txt";
                            break;
                        default:
                            System.out.println("Ungültige Auswahl. Bitte wähle eine Zahl von 1 bis 6.");
                            break;
                    }

                    if (!fileName.isEmpty()) {
                        try {
                            // تأكد من مسار الملف صحيح
                            File file = new File("C:\\Users\\Student\\Desktop\\VS Code Projekte\\java\\aufgabe_schule\\Neuer Ordner\\" + fileName);
                        
                            Scanner fileScanner = new Scanner(file);
                            String sätze = "";
                            while (fileScanner.hasNextLine()) {
                                sätze += fileScanner.nextLine() + "\n";  // إضافة السطر الجديد بين الأسطر
                            }
                            System.out.println(sätze);  // عرض الأسئلة
                            fileScanner.close();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                            System.out.println("Fehler: Datei nicht gefunden.");
                        }
                    }
                }

            } else if (erfa.equalsIgnoreCase("nein") || erfa.equalsIgnoreCase("2")) {
                System.out.println("Du wirst von Anfang an beginnen.");
            } else {
                System.out.println("Deine Eingabe konnte nicht bearbeitet werden.");
                continue;
            }

            System.out.println("Möchtest du weiterlernen? (ja/nein)");
            String antwort = input.nextLine();
            if (!antwort.equalsIgnoreCase("ja")) {
                weiterlernen = false;
                System.out.println("Danke fürs Lernen! Viel Erfolg weiterhin!");
            }
        }
    }
}
