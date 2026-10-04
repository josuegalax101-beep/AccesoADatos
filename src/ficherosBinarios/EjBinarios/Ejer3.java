package ficherosBinarios.EjBinarios;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ejer3 {
    private static final String RUTA_FICHERO = "datos1/";
    private static final String NOMBRE_FICHERO = "datosbeca.bin";

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        File carpeta = new File(RUTA_FICHERO);
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(RUTA_FICHERO + NOMBRE_FICHERO))) {


            System.out.print("Introduce el nombre y apellidos: ");
            String nombre = sc.nextLine();


            char sexo;
            do {
                System.out.print("Introduce el sexo (H/M): ");
                sexo = sc.nextLine().trim().toUpperCase().charAt(0);
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

            boolean residenciaFamiliar = pedirBooleano("¿Vive en residencia familiar? (SI/NO): ");


            double ingresos;
            do {
                System.out.print("Introduce los ingresos anuales de la familia: ");
                while (!sc.hasNextDouble()) {
                    System.out.print("Por favor, introduce una cifra válida: ");
                    sc.next();
                }
                ingresos = sc.nextDouble();
            } while (ingresos < 0);


            boolean tieneBeca = pedirBooleano("¿Tiene beca? (SI/NO): ");

            dos.writeUTF(nombre);
            dos.writeChar(sexo);
            dos.writeInt(edad);
            dos.writeInt(suspensos);
            dos.writeBoolean(residenciaFamiliar);
            dos.writeDouble(ingresos);
            dos.writeBoolean(tieneBeca);

            System.out.println("Los datos del becario se han guardado correctamente en " + RUTA_FICHERO + NOMBRE_FICHERO);

        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero binario: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    private static boolean pedirBooleano(String mensaje) {
        String respuesta;
        do {
            System.out.print(mensaje);
            respuesta = sc.next().trim().toUpperCase();
        } while (!respuesta.equals("SI") && !respuesta.equals("NO"));

        return respuesta.equals("SI");
    }
}