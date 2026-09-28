package org.example;

import java.io.File;
import java.nio.file.Path;

public class ProbarFicheros2 {
    static void main() {
        /*1. Crea una clase ArchivoTXT cuyo constructor reciba un String con una ruta y lo
        guarde como Path. Debe comprobar que la ruta hace referencia a un fichero (no
        directorio) y que este existe. */

        ArchivoTXT archivo1 = new ArchivoTXT("C:\\Users\\AlumnoD\\Desktop\\prueba.txt.txt");

        ArchivoTXT archivo2 = new ArchivoTXT("C:\\Users\\AlumnoD\\Desktop\\ubu.txt");



       /* 2. Añade un metodo aVerso que lea el contenido del fichero y lo devuelva
       introduciendo un salto de línea después de cada punto. */

        archivo1.aVerso();

        /*3. Añade un metodo codifica que reciba la ruta de otro fichero (puede existir o no),
        lea el contenido del fichero original, elimine todas las vocales y escriba el
        resultado en el fichero destino. Usa Files.newBufferedReader y Files.newBufferedWriter.*/

        String ruta = "C:\\Users\\AlumnoD\\Desktop\\ubu.txt";
        archivo1.codifica(ruta);

        /*4. Añade un metodo mover que reciba otra ruta y mueva el fichero a ella. Si el
        directorio origen queda vacío, debe eliminarse también.*/



        /*5. Añade tres métodos:
        contarCaracteres: número total de caracteres.
        contarLetras: número total de letras.
        contarPuntuacion: número total de signos de puntuación.*/

        /*6. Añade un metodo contarLineas que cuente las frases del fichero (hasta cada
        punto) ayudándose de aVerso.*/

        /*7. Añade un metodo contarPalabras que cuente todas las palabras del fichero.*/

        /*8. Implementa contarVocales que escriba el número de vocales de cada palabra
        en un fichero numVocales.txt en el mismo directorio que el original. Cada número
        irá seguido de un espacio. Mayúsculas y minúsculas se contarán juntas. Modifica
        el metodo para que tenga en cuenta tildes y diéresis.*/

        /*9. Implementa frecuenciaLetras que muestre la frecuencia de aparición de cada
        letra (a-z, incluyendo mayúsculas) del fichero.*/

        /*10. Crea una clase que represente algo de tu elección (personaje, producto, etc.) con
        al menos: un String para el nombre, otro String, un entero, un double y un
        boolean. Crea varios objetos y escríbelos en un fichero .csv separado por punto y coma.
        Comprueba que se carga correctamente en una hoja de cálculo.*/

        /*11. Añade un metodo que permita escribir un nuevo objeto de esa clase al final del
        fichero CSV.*/

        /*12. Lee los objetos del fichero CSV y muéstralos por pantalla, con un texto delante
        de cada campo. Sobrescribe toString para ayudarte. ¿Qué sucede si intentas
        escribir un nuevo elemento abriendo el fichero en modo lectura?*/
    }
}
