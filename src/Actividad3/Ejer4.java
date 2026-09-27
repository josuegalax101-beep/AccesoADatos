package Actividad3;

import java.io.*;
import java.util.Scanner;

public class Ejer4 {

    public static void main(String[] args) {
        String nombreFichero = "datos.txt";
        int totalLineas = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
            while (br.readLine() != null) {
                totalLineas++;
            }
            System.out.println("El fichero '" + nombreFichero + "' tiene " + totalLineas + " líneas en total.");
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }


        Scanner sc = new Scanner(System.in);
        String palabra;

        System.out.println("Introduce una palabra para buscarla: ");
        palabra = sc.nextLine().toLowerCase();

        int numeroDeLinea = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {

            String linea;
            while ((linea = br.readLine()) != null) {

                if (linea.toLowerCase().contains(palabra)) {
                    numeroDeLinea++;
                }
            }
            System.out.println("Número de líneas que contienen '" + palabra + "': " + numeroDeLinea);

        } catch (IOException e) {
            System.out.println("Erro al leer el fichero: " + e.getMessage());
        }

        /*

        String destino = "copia.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero));
             BufferedWriter bw = new BufferedWriter(new FileWriter(destino))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                bw.write(linea);
                bw.newLine();
            }

            System.out.println("Fichero copiado '" + destino + "'.");

        } catch (IOException e) {
            System.out.println("Error al copia el archivo: " + e.getMessage());
        }
    }*/


        String destino = "copia.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero));
             BufferedWriter bw = new BufferedWriter(new FileWriter(destino))) {

            String linea;
            int lineasCopiadas = 0;

            while ((linea = br.readLine()) != null) {

                if (!linea.trim().isEmpty()) {
                    bw.write(linea);
                    bw.newLine();
                    lineasCopiadas++;
                }
            }

            System.out.println("Se han copiado " + lineasCopiadas + " líneas y se han omitido las linea vacías.");

        } catch (IOException e) {
            System.err.println("Error al copiar el fichero: " + e.getMessage());
        }
    }
}












