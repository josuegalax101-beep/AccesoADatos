package Actividad3.Ampliacion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class A2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el nombre del fichero: ");
        String nombreFichero = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
            String linea;
            int contador = 0;

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                contador++;

                if (contador % 24 == 0) {
                    System.out.print("-- Pulsa Intro para continuar ---");
                    sc.nextLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
    }
}
