package ficherosBinarios.EjBinarios;

import java.io.*;
import java.util.Scanner;

public class Ejer1 {

    private static final String RUTA_FICHERO = "datos1/";
    private static final String NOMBRE_FICHERO = "num_aleat.bin";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la cantidad de numeros que se van a guardar");
        int cantidad = sc.nextInt();

        System.out.println("Introduce el maximo");
        int max = sc.nextInt();

        System.out.println("Introduce el minimo");
        int min = sc.nextInt();

        if (max < min) {
            System.out.println("El máximo tiene que ser mayor al  mínimo");

            sc.close();
            return;
        }

        try (DataOutputStream escribirFichero =
                     new DataOutputStream(
                             new FileOutputStream(
                                     RUTA_FICHERO + NOMBRE_FICHERO, true))) {

            for (int i = 0; i < cantidad; i++) {

                int numero = (int) (Math.random() * (max - min + 1)) + min;

                escribirFichero.writeInt(numero);
            }

        } catch (IOException e) {
            System.out.println("Error al escribir fichero");
        }

        try (DataInputStream leerFichero =
                     new DataInputStream(
                             new FileInputStream(
                                     RUTA_FICHERO + NOMBRE_FICHERO))) {

            while (true) {
                try {
                    int numero = leerFichero.readInt();
                    System.out.print(numero + " ");

                } catch (EOFException e) {
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer fichero");
        }

        sc.close();
    }
}