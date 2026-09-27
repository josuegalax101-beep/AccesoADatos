package Actividad3.Ampliacion;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class A5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el nombre del fichero: ");
        String nombreFichero = sc.nextLine();


        int numLineas = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
            while (br.readLine() != null) {
                numLineas++;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero " + e.getMessage());

        }

        String[] lineas = new String[numLineas];
        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
            for (int i = 0; i < numLineas; i++) {
                lineas[i] = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error al introducir las líneas: " + e.getMessage());

        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("salida.txt", true))) {
            for (int i = numLineas - 1; i >= 0; i--) {
                bw.write(lineas[i]);
                bw.newLine();
            }
            System.out.println("Fichero 'salida.txt' creado.");
        } catch (IOException e) {
            System.out.println("Error al escribir el nuevo fichero " + e.getMessage());
        }
        System.out.println("-------------------------------------------");

        try (BufferedReader br = new BufferedReader(new FileReader("salida.txt"))) {
            String linea;


            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
    }
}

