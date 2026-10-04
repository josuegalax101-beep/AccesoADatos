package ficherosBinarios.EjBinarios;

import java.io.*;
import java.util.Scanner;

public class Ejer4 {
    private static final String RUTA_FICHERO = "datos1/";
    private static final String NOMBRE_FICHERO = "datosbeca2.bin";

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        try (DataOutputStream escribirFichero = new DataOutputStream(new FileOutputStream(RUTA_FICHERO + NOMBRE_FICHERO, true))) {

            System.out.print("Introduce el número de Becarios que quieres almacenar: ");
            int becarios = Integer.parseInt(sc.nextLine());

            for (int i = 1; i <= becarios; i++) {
                System.out.println("\n--- Becario " + i + " ---");

                System.out.print("Introduce el nombre y apellidos: ");
                String nombre = sc.nextLine();

                char sexo;
                do {
                    System.out.print("Introduce el sexo (H/M): ");
                    String entradaSexo = sc.nextLine().trim().toUpperCase();
                    sexo = entradaSexo.isEmpty() ? ' ' : entradaSexo.charAt(0);
                } while (sexo != 'H' && sexo != 'M');

                int edad;
                do {
                    System.out.print("Introduce la edad (20-60): ");
                    while (!sc.hasNextInt()) {
                        System.out.print("Por favor, introduce un número entero para la edad: ");
                        sc.next();
                    }
                    edad = sc.nextInt();
                } while (edad < 20 || edad > 60);

                int suspensos;
                do {
                    System.out.print("Introduce el número de suspensos (0-4): ");
                    while (!sc.hasNextInt()) {
                        System.out.print("Por favor, introduce un número entero para los suspensos: ");
                        sc.next();
                    }
                    suspensos = sc.nextInt();
                } while (suspensos < 0 || suspensos > 4);

                sc.nextLine();

                boolean residenciaFamiliar = pedirBooleano("¿Vive en residencia familiar? (SI/NO): ");

                double ingresos;
                do {
                    System.out.print("Introduce los ingresos anuales de la familia: ");
                    while (!sc.hasNextDouble()) {
                        System.out.print("Por favor, introduce una cifra válida para los ingresos: ");
                        sc.next();
                    }
                    ingresos = sc.nextDouble();
                } while (ingresos < 0);

                sc.nextLine();

                boolean tieneBeca = pedirBooleano("¿Tiene beca? (SI/NO): ");


                escribirFichero.writeUTF(nombre);
                escribirFichero.writeChar(sexo);
                escribirFichero.writeInt(edad);
                escribirFichero.writeInt(suspensos);
                escribirFichero.writeBoolean(residenciaFamiliar);
                escribirFichero.writeDouble(ingresos);
                escribirFichero.writeBoolean(tieneBeca);

                System.out.println("Los datos del becario " + i + " se han guardado correctamente.");

            }


        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero binario: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error: Debes introducir un número entero válido.");

        }
        int contador = 1;

        try (DataInputStream leerFichero = new DataInputStream(new FileInputStream(RUTA_FICHERO +NOMBRE_FICHERO))) {
            while (true) {
                String nombre = leerFichero.readUTF();
                char sexo = leerFichero.readChar();
                int edad = leerFichero.readInt();
                int suspensos = leerFichero.readInt();
                boolean residenciaFamiliar = leerFichero.readBoolean();
                double ingresos = leerFichero.readDouble();
                boolean tieneBeca = leerFichero.readBoolean();

                System.out.println("\nBecario #" + contador);
                System.out.println("  Nombre: " + nombre);
                System.out.println("  Sexo: " + sexo);
                System.out.println("  Edad: " + edad);
                System.out.println("  Suspensos: " + suspensos);
                System.out.println("  Residencia: " + residenciaFamiliar);
                System.out.println("  Ingresos: " + ingresos);
                System.out.println("  Beca: " + tieneBeca);

                contador++;
            }
        } catch (EOFException e) {
            System.out.println("\n--- Fin de la lectura del archivo ---");
        } catch (IOException e) {
            System.err.println("Error al leer el fichero binario: " + e.getMessage());
        }
    }


    private static boolean pedirBooleano(String mensaje) {
        String respuesta;
        do {
            System.out.print(mensaje);
            respuesta = sc.nextLine().trim().toUpperCase();
        } while (!respuesta.equals("SI") && !respuesta.equals("NO"));

        return respuesta.equals("SI");
    }
}