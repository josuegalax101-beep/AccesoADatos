package ficherosBinarios.EjBinarios;

import java.io.*;
import java.util.Scanner;

public class Ejer2 {

    private static final String RUTA_FICHERO = "datos1/";
    private static final String NOMBRE_FICHERO = "vehiculos.dat";

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String matricula;
        String marca;
        double deposito;
        String modelo;

        System.out.println("Introduce la cantidad de coches que quieres introducir: ");
        int cantidad = sc.nextInt();
        sc.nextLine();

        try (DataOutputStream escribirFichero = new DataOutputStream(
                new FileOutputStream(RUTA_FICHERO + NOMBRE_FICHERO, true))) {

            for (int i = 0; i < cantidad; i++) {

                System.out.println("\nVehículo " + (i + 1));

                System.out.println("Matrícula:");
                matricula = sc.nextLine();

                System.out.println("Marca:");
                marca = sc.nextLine();

                System.out.println("Tamaño del depósito:");
                deposito = sc.nextDouble();
                sc.nextLine();

                System.out.println("Modelo:");
                modelo = sc.nextLine();

                escribirFichero.writeUTF(matricula);
                escribirFichero.writeUTF(marca);
                escribirFichero.writeDouble(deposito);
                escribirFichero.writeUTF(modelo);
            }

        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero");
        }
        try (DataInputStream leerFichero =
                     new DataInputStream(
                             new FileInputStream(
                                     RUTA_FICHERO + NOMBRE_FICHERO))) {

            System.out.println("\n--- Coches ---");

            while (true) {

                try {
                    matricula = leerFichero.readUTF();
                    marca = leerFichero.readUTF();
                    deposito = leerFichero.readDouble();
                    modelo = leerFichero.readUTF();

                    System.out.println(
                            matricula + " - " +
                                    marca + " - " +
                                    deposito + " - " +
                                    modelo
                    );

                } catch (EOFException e) {
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el fichero");
        }

        sc.close();
    }
}




