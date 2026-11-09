# Ejemplos UD01 – Acceso a ficheros

| Fichero | Apartados del PDF | Contenido |
|---|---|---|
| Ej01_Ficheros.java | 2.4 – 2.8 | Clase File: propiedades, crear, listar, eliminar (ejercicios 3.5) |
| Ej02_PathFiles.java | 2.9 | API Path y Files |
| Ej03_Excepciones.java | 3 | throws, try-catch, finally, try-with-resources |
| Ej04_Texto.java | 4 | Archivos de texto: leer, escribir, copiar (ejercicios 4.6) |
| Ej05a_DataStreams.java | 5.3 – 5.4 | DataOutputStream / DataInputStream (ejercicios 5.8: 1 y 2) |
| Ej05b_Serializacion.java | 5.5 – 5.6 | Serializable y ObjectOutputStream (ejercicios 5.8: 3 y 4) |
| Ej06_Aleatorio.java | 6 | RandomAccessFile: leer, acceso directo, modificar, añadir |
| Ej07_XML.java | 8 | XML con DOM: crear, leer, modificar, guardar (ejercicios 8.8) |
| Ej08_JSON.java | 9 | JSON con Gson (ejercicios 9.6) |
| Ejercicio_Comun_Biblioteca/ | Todo | Proyecto Maven que integra todos los apartados |

## Ejecución

Los ejemplos Ej01–Ej07 se ejecutan directamente (Java 17 o superior):

    java Ej01_Ficheros.java

Ej08_JSON necesita la librería Gson (descargar gson-2.10.1.jar):

    java -cp gson-2.10.1.jar Ej08_JSON.java

El ejercicio común es un proyecto Maven (pom.xml incluye Gson): ábrelo en tu IDE
y ejecuta GestionBiblioteca. Los ficheros se generan en la carpeta datos/.

## Qué usa cada técnica en el ejercicio común

- File / Files: carpeta datos/ y comprobación de que el catálogo existe
- Texto: registro.txt (log de actividad, modo append)
- Acceso aleatorio: biblioteca.dat (catálogo; modificar ejemplares sin reescribir el fichero)
- Serialización: copia.bin (copia de seguridad de la lista de libros)
- XML (DOM): biblioteca.xml (exportación)
- JSON (Gson): configuracion.json (última opción del menú y total de libros)
- Excepciones: try-catch y try-with-resources en todos los accesos
