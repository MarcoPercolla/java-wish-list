package org.PresentList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PresentList {
    public static void main(String[] args) {
        ArrayList<String> presents = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String present = "";
        String choice;

        do {
            //in java 8 .isBlank() si puo fare con .trim.isEmpty()
            while (present.isEmpty() || present.isBlank()) {
                System.out.print("Inserisci il nome di un regalo: ");
                present = scanner.nextLine();
            
                
                System.out.println("inserisci qualcosa prima di procedere!");;
            }
            presents.add(present);
            present="";

            System.out.println("La lista contiene " + presents.size() + " regali.");

            System.out.print("Vuoi aggiungere un altro regalo? \n (si per continuare, qualunque cosa per concludere): ");
            choice = scanner.nextLine();
        } while (choice.equalsIgnoreCase("si"));


        Collections.sort(presents);


        System.out.println("Lista dei regali:");
        for (String regalo : presents) {
            System.out.println(regalo);
        }

        scanner.close();
    }
}
