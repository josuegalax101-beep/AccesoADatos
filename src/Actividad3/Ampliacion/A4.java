package Actividad3.Ampliacion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class A4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el nombre del fichero: ");
        String nombreFichero = sc.nextLine();


        int numLineas = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
            while (br.readLine() != null) {
                numLineas++;

            }
            System.out.println("El fichero tiene " + numLineas + " lineas.");
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());

        }


        String[] lineas = new String[numLineas];
        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
            for (int i = 0; i < numLineas; i++) {
                lineas[i] = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error al volver a abrir el fichero: " + e.getMessage());

        }


        System.out.println("\n--- Orden invertido ---");
        for (int i = numLineas - 1; i >= 0; i--) {
            System.out.println(lineas[i]);
        }
    }
}
