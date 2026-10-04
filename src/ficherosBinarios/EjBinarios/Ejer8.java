package ficherosBinarios.EjBinarios;

import java.io.*;
import java.util.Scanner;

public class Ejer8 {

    private static final String RUTA_FICHERO = "datos1/";
    private static final String NOMBRE_FICHERO = "Septemp.dat";
    private static final String FICHERO_TEMPERATURAS =
            RUTA_FICHERO + "temperaturas.txt";

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Introduce un día de septiembre: ");
        int dia = sc.nextInt();

        if (dia < 1 || dia > 30) {
            System.out.println("El día debe estar entre 1 y 30.");
            return;
        }

        File ficheroTexto = new File(FICHERO_TEMPERATURAS);
        File ficheroBinario = new File(RUTA_FICHERO + NOMBRE_FICHERO);

        try (
                BufferedReader br = new BufferedReader(
                        new FileReader(ficheroTexto));

                DataOutputStream dos = new DataOutputStream(
                        new FileOutputStream(ficheroBinario, true))
        ) {

            String linea;

            while ((linea = br.readLine()) != null) {
                try {

                    String limpia = linea.replaceAll("[^0-9.\\s,:]", "").replace(":", " ").replace(",", " ");
                    String[] datos = limpia.trim().split("\\s+");

                    if (datos.length < 3) continue;

                    int diaFichero = Integer.parseInt(datos[0]);
                    int hora = Integer.parseInt(datos[1]);
                    double temperatura = Double.parseDouble(datos[datos.length - 1]);

                    if (diaFichero == dia) {
                        dos.writeInt(diaFichero);
                        dos.writeInt(hora);
                        dos.writeDouble(temperatura);
                    }
                } catch (NumberFormatException e) {

                }
            }

            System.out.println("Fichero " + NOMBRE_FICHERO
                    + " creado correctamente.");

        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero.");
        } catch (IOException e) {
            System.out.println("Error de entrada/salida: "
                    + e.getMessage());
        }
    }
}