package ficherosBinarios.EjBinarios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejer10 {

    private static final String RUTA_FICHERO = "datos1/";
    private static final String NOMBRE_FICHERO = "nominas.bin";

    public static void main(String[] args) {

        int eliminados = 0;

        try (DataInputStream dis = new DataInputStream(new FileInputStream(RUTA_FICHERO + NOMBRE_FICHERO));
             DataOutputStream dos = new DataOutputStream(new FileOutputStream("nominas.dat"))) {

            while (true) {
                String nombre = dis.readUTF();
                int diasBaja = dis.readInt();
                double nomina = dis.readDouble();

                if (diasBaja == 0) {
                    nomina *= 1.05;
                    dos.writeUTF(nombre);
                    dos.writeInt(diasBaja);
                    dos.writeDouble(nomina);
                } else if (diasBaja >= 1 && diasBaja <= 3) {
                    dos.writeUTF(nombre);
                    dos.writeInt(diasBaja);
                    dos.writeDouble(nomina);
                } else if (diasBaja >= 4 && diasBaja <= 10) {
                    nomina *= 0.90;
                    dos.writeUTF(nombre);
                    dos.writeInt(diasBaja);
                    dos.writeDouble(nomina);
                } else if (diasBaja > 10) {
                    eliminados++;
                }
            }

        } catch (EOFException e) {

        } catch (IOException e) {
            System.err.println("Error procesando el fichero: " + e.getMessage());
            return;
        }


        try (DataInputStream dis = new DataInputStream(new FileInputStream(RUTA_FICHERO + NOMBRE_FICHERO))) {
            while (true) {
                String nombre = dis.readUTF();
                int diasBaja = dis.readInt();
                double nomina = dis.readDouble();

                System.out.printf("Empleado: %-15s | Días de baja: %2d | Nómina: %.2f €\n", nombre, diasBaja, nomina);
            }
        } catch (EOFException e) {

        } catch (IOException e) {
            System.err.println("Error al leer el fichero actualizado: " + e.getMessage());
        }

        System.out.println("\nNúmero total de empleados dados de baja (eliminados): " + eliminados);
    }
}