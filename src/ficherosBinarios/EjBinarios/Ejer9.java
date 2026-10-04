package ficherosBinarios.EjBinarios;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.EOFException;
import java.io.IOException;

public class Ejer9 {
    private static final String RUTA_FICHERO = "datos1/";
    private static final String NOMBRE_FICHERO = "Septemp.dat";

    public static void main(String[] args) {
        double temperaturaMaxima = Double.NEGATIVE_INFINITY;
        double temperaturaMinima = Double.POSITIVE_INFINITY;
        double sumaTemperatura = 0;
        int contadorHoras = 0;

        int horaMasCalurosa = -1;
        int horaMasFria = -1;

        try (DataInputStream dis = new DataInputStream(new FileInputStream(RUTA_FICHERO + NOMBRE_FICHERO))) {
            while (true) {
                double temp = dis.readDouble();
                int hora = contadorHoras;

                if (temp > temperaturaMaxima) {
                    temperaturaMaxima = temp;
                    horaMasCalurosa = hora;
                }

                if (temp < temperaturaMinima) {
                    temperaturaMinima = temp;
                    horaMasFria = hora;
                }

                sumaTemperatura += temp;
                contadorHoras++;
            }
        } catch (EOFException e) {

        } catch (IOException e) {
            System.err.println("Error al leer el fichero: " + e.getMessage());
            return;
        }

        if (contadorHoras > 0) {
            double mediaTemp = sumaTemperatura / contadorHoras;

            System.out.printf("Temperatura máxima: %.2f ºC , Hora: %02d:00 \n", temperaturaMaxima, horaMasCalurosa);
            System.out.printf("Temperatura mínima: %.2f ºC , Hora: %02d:00 \n", temperaturaMinima, horaMasFria);
            System.out.printf("Temperatura media del día: %.2f ºC\n", mediaTemp);
        } else {
            System.out.println("No se encontraron registros de temperatura.");
        }
    }
}