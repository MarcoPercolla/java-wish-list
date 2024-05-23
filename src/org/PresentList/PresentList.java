package org.PresentList;



import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PresentList {

    private static final String NOME_FILE = "lista_regali.txt";

    public static void main(String[] args) {
        ArrayList<String> presents = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String present = "";
        String choice;


        loadFile(presents);

        do {
            // in java 8 .isBlank() si puo fare con .trim().isEmpty()
            while (present.trim().isEmpty()) {
                System.out.print("Inserisci il nome di un regalo: ");
                present = scanner.nextLine();

                if (present.trim().isEmpty()) {
                    System.out.println("Inserisci qualcosa prima di procedere!");
                }
            }
            presents.add(present);
            present = "";

            System.out.println("La lista contiene " + presents.size() + " regali.");

            System.out.print("Vuoi aggiungere un altro regalo? (si per continuare, qualunque cosa per concludere): ");
            choice = scanner.nextLine();
        } while (choice.equalsIgnoreCase("si"));

        Collections.sort(presents);


        saveFile(presents);

        System.out.println("Lista dei regali ordinata:");
        for (String regalo : presents) {
            System.out.println(regalo);
        }

        scanner.close();
    }

    private static void loadFile(ArrayList<String> listaRegali) {
        File file = new File(NOME_FILE);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Errore durante la creazione del file: " + e.getMessage());
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(NOME_FILE))) {
            String regalo;
            while ((regalo = br.readLine()) != null) {
                listaRegali.add(regalo);
            }
        } catch (IOException e) {
            System.out.println("Errore durante il caricamento della lista dal file: " + e.getMessage());
        }
    }

    private static void saveFile(ArrayList<String> listaRegali) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_FILE))) {
            for (String regalo : listaRegali) {
                bw.write(regalo);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio della lista su file: " + e.getMessage());
        }
    }
}
