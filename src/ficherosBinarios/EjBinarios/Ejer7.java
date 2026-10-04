package ficherosBinarios.EjBinarios;

import java.io.*;

public class Ejer7 {
    private static final String RUTA_FICHERO = "datos1/";

    public static void main(String[] args) {

        try {
            DataInputStream dis = new DataInputStream(
                    new FileInputStream(RUTA_FICHERO + "muchosdatos.bin"));

            DataOutputStream menores = new DataOutputStream(
                    new FileOutputStream(RUTA_FICHERO + "menores.dat"));

            DataOutputStream adultos = new DataOutputStream(
                    new FileOutputStream(RUTA_FICHERO + "adultos.dat"));

            DataOutputStream mayores = new DataOutputStream(
                    new FileOutputStream(RUTA_FICHERO + "mayores.dat"));

            try {
                while (true) {
                    String nombre = dis.readUTF();
                    String apellidos = dis.readUTF();
                    int edad = dis.readInt();
                    String telefono = dis.readUTF();
                    String email = dis.readUTF();
                    String ciudad = dis.readUTF();
                    String nacionalidad = dis.readUTF();
                    String profesion = dis.readUTF();

                    if (edad < 18) {
                        menores.writeUTF(nombre);
                        menores.writeUTF(apellidos);
                        menores.writeInt(edad);
                        menores.writeUTF(telefono);
                        menores.writeUTF(email);
                        menores.writeUTF(ciudad);
                        menores.writeUTF(nacionalidad);
                        menores.writeUTF(profesion);
                    } else if (edad <= 65) {
                        adultos.writeUTF(nombre);
                        adultos.writeUTF(apellidos);
                        adultos.writeInt(edad);
                        adultos.writeUTF(telefono);
                        adultos.writeUTF(email);
                        adultos.writeUTF(ciudad);
                        adultos.writeUTF(nacionalidad);
                        adultos.writeUTF(profesion);
                    } else {
                        mayores.writeUTF(nombre);
                        mayores.writeUTF(apellidos);
                        mayores.writeInt(edad);
                        mayores.writeUTF(telefono);
                        mayores.writeUTF(email);
                        mayores.writeUTF(ciudad);
                        mayores.writeUTF(nacionalidad);
                        mayores.writeUTF(profesion);
                    }
                }
            } catch (EOFException e) {
            }

            dis.close();
            menores.close();
            adultos.close();
            mayores.close();

            System.out.println("Menores:");
            DataInputStream disMenores = new DataInputStream(
                    new FileInputStream(RUTA_FICHERO + "menores.dat"));

            try {
                while (true) {
                    System.out.println("Nombre: " + disMenores.readUTF());
                    System.out.println("Apellidos: " + disMenores.readUTF());
                    System.out.println("Edad: " + disMenores.readInt());
                    System.out.println("Teléfono: " + disMenores.readUTF());
                    System.out.println("Email: " + disMenores.readUTF());
                    System.out.println("Ciudad: " + disMenores.readUTF());
                    System.out.println("Nacionalidad: " + disMenores.readUTF());
                    System.out.println("Profesión: " + disMenores.readUTF());
                    System.out.println();
                }
            } catch (EOFException e) {
            }

            disMenores.close();

            System.out.println("ADULTOS:");
            DataInputStream disAdultos = new DataInputStream(
                    new FileInputStream(RUTA_FICHERO + "adultos.dat"));

            try {
                while (true) {
                    System.out.println("Nombre: " + disAdultos.readUTF());
                    System.out.println("Apellidos: " + disAdultos.readUTF());
                    System.out.println("Edad: " + disAdultos.readInt());
                    System.out.println("Teléfono: " + disAdultos.readUTF());
                    System.out.println("Email: " + disAdultos.readUTF());
                    System.out.println("Ciudad: " + disAdultos.readUTF());
                    System.out.println("Nacionalidad: " + disAdultos.readUTF());
                    System.out.println("Profesión: " + disAdultos.readUTF());
                    System.out.println();
                }
            } catch (EOFException e) {
            }

            disAdultos.close();

            System.out.println("MAYORES DE 65:");
            DataInputStream disMayores = new DataInputStream(
                    new FileInputStream(RUTA_FICHERO + "mayores.dat"));

            try {
                while (true) {
                    System.out.println("Nombre: " + disMayores.readUTF());
                    System.out.println("Apellidos: " + disMayores.readUTF());
                    System.out.println("Edad: " + disMayores.readInt());
                    System.out.println("Teléfono: " + disMayores.readUTF());
                    System.out.println("Email: " + disMayores.readUTF());
                    System.out.println("Ciudad: " + disMayores.readUTF());
                    System.out.println("Nacionalidad: " + disMayores.readUTF());
                    System.out.println("Profesión: " + disMayores.readUTF());
                    System.out.println();
                }
            } catch (EOFException e) {
            }

            disMayores.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}