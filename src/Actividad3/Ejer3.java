package Actividad3;

import java.io.File;
import java.io.IOException;

public class Ejer3 {

    public static void main(String[] args) throws IOException {

        File directorio = new File("copias");

        if (directorio.exists()) {
            System.out.println("El directorio ya existe");
        } else {
            if (directorio.mkdir()) {
                System.out.println("Directorio creado correctamente");
            } else {
                System.out.println("No se pudo crear el directorio");
            }
        }

        File fichero = new File("copias/config.txt");

        if (fichero.exists()) {
            System.out.println("El fichero ya existe");
        } else {
            if (fichero.createNewFile()) {
                System.out.println("El fichero creado correctamente");
            } else {
                System.out.println("No se pudo crear el fichero");
            }
        }


        String[] contenido = directorio.list();
        if (contenido != null) {
            for (String nombre : contenido) {
                File elementos = new File(directorio, nombre);

                if (elementos.isDirectory()) {
                    System.out.println("Directorios: " + nombre);
                } else {
                    System.out.println("Fichero: " + nombre);
                }
            }
        }

        if (fichero.delete()) {
            System.out.println("El fichero eliminado correctamente");
        } else {
            System.out.println("No se pudo eliminar el  fichero");
        }
        if (directorio.delete()) {
            System.out.println("Directorio  eliminado correctamente");
        } else {
            System.out.println("No se pudo eliminar el directorio");

        }
    }

}
