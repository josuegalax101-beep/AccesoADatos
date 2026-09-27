package Actividad3.Ampliacion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class A1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fichero = "frases.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero, true))) {
            System.out.println("Introduce frases para añadir:");
            String frase;

            while (!(frase = sc.nextLine()).isEmpty()) {
                bw.write(frase);
                bw.newLine();
            }
            System.out.println("Frases guardadas en " + fichero);
        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }
}
