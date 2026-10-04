package ficherosBinarios.EjBinarios;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;

public class Ejer5 {
    private static final String RUTA_FICHERO = "datos1/";
    private static final String NOMBRE_FICHERO = "datosbeca2.bin";

    public static void main(String[] args) {
        File fichero = new File(RUTA_FICHERO + NOMBRE_FICHERO);

        if (!fichero.exists()) {
            System.out.println("El fichero " + NOMBRE_FICHERO + " no existe.");
            return;
        }

        try (DataInputStream listaBecarios = new DataInputStream(new FileInputStream(fichero))) {
            System.out.println("--- Lista de becarios y beca ---");

            while (true) {
                String nombre = listaBecarios.readUTF();
                char sexo = listaBecarios.readChar();
                int edad = listaBecarios.readInt();
                int suspensos = listaBecarios.readInt();
                boolean residenciaFamiliar = listaBecarios.readBoolean();
                double ingresos = listaBecarios.readDouble();
                boolean tieneBeca = listaBecarios.readBoolean();

                if (tieneBeca) {
                    double cuantia = calcularCuantiaBeca(ingresos, edad, suspensos, residenciaFamiliar);

                    if (cuantia > 0) {
                        System.out.printf("Becario: %-30s | Cuantía de la beca: %.2f€%n", nombre, cuantia);
                    } else {
                        System.out.printf("Becario: %-30s | No le puede tener beca por tener 2 o más suspensos.%n", nombre);
                    }
                }
            }

        } catch (EOFException e) {
            System.out.println("\nLectura de datos finalizada.");
        } catch (IOException e) {
            System.err.println("Error al leer el fichero binario: " + e.getMessage());
        }
    }

    private static double calcularCuantiaBeca(double ingresos, int edad, int suspensos, boolean residenciaFamiliar) {
        if (suspensos >= 2) {
            return 0.0;
        }

        double total = 1500.0;

        if (ingresos <= 12000.0) {
            total += 500.0;
        }

        if (edad < 23) {
            total += 200.0;
        }

        if (suspensos == 0) {
            total += 500.0;
        } else if (suspensos == 1) {
            total += 200.0;
        }

        if (!residenciaFamiliar) {
            total += 1000.0;
        }

        return total;
    }
}