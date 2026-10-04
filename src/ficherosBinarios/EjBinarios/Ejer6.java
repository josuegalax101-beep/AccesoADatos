package ficherosBinarios.EjBinarios;

import java.io.*;
import java.util.Scanner;

public class Ejer6 {
    private static final String RUTA_FICHERO = "datos1/";
    private static final String NOMBRE_FICHERO = "datospersonas.dat";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el número de personas que quieres meter ");
        int cantidad = sc.nextInt();
        sc.nextLine();


        try {
            DataOutputStream listaPersonas = new DataOutputStream(
                    new FileOutputStream(RUTA_FICHERO + NOMBRE_FICHERO));

            for (int i = 0; i < cantidad; i++) {
                System.out.println("\nPersona " + (i + 1));

                System.out.print("Nombre: ");
                listaPersonas.writeUTF(sc.nextLine());

                System.out.print("Apellidos: ");
                listaPersonas.writeUTF(sc.nextLine());

                System.out.print("Edad: ");
                listaPersonas.writeInt(sc.nextInt());
                sc.nextLine();

                System.out.print("Número: ");
                listaPersonas.writeUTF(sc.nextLine());

                System.out.print("Correo: ");
                listaPersonas.writeUTF(sc.nextLine());

                System.out.print("Ciudad: ");
                listaPersonas.writeUTF(sc.nextLine());

                System.out.print("Nacionalidad: ");
                listaPersonas.writeUTF(sc.nextLine());

                System.out.print("Profesión: ");
                listaPersonas.writeUTF(sc.nextLine());
            }

            listaPersonas.close();

            DataInputStream datos = new DataInputStream(
                    new FileInputStream(RUTA_FICHERO + NOMBRE_FICHERO));

            System.out.println("\nDatos del fichero:");

            for (int i = 0; i < cantidad; i++) {
                System.out.println("\nPersona " + (i + 1));
                System.out.println("Nombre: " + datos.readUTF());
                System.out.println("Apellidos: " + datos.readUTF());
                System.out.println("Edad: " + datos.readInt());
                System.out.println("Número: " + datos.readUTF());
                System.out.println("Correo: " + datos.readUTF());
                System.out.println("Ciudad: " + datos.readUTF());
                System.out.println("DNI: " + datos.readUTF());
                System.out.println("Profesión: " + datos.readUTF());
            }

            datos.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}