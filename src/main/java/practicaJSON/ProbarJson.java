package practicaJSON;

import jakarta.json.*;
import jakarta.json.stream.JsonGenerator;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ProbarJson {

    List<Alumno> alumnos = List.of(
            new Alumno("Ana", 1, false),
            new Alumno("Luis", 2, false),
            new Alumno("Marta", 3, true),
            new Alumno("Pedro", 4, false),
            new Alumno("Lucía", 5, false)
    );

    void main() throws IOException {

        /* EJERCICIO 1 */

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta para introducir los datos");
        String ruta = sc.nextLine();
        escribir(alumnos, ruta); //Añadiremos la lista de Alumnos a un fichero.JSON (con su respectiva ruta detras)

        /* EJERCICIO 2 */

        System.out.println("Introduce la ruta para leer el archivo");
        ruta = sc.nextLine();
        List<Alumno> alumnosNuevos; //Haremos una nueva lista para añadir a los alumnos.
        alumnosNuevos=leerAlumnos(ruta); // como leerAlumnos nos devuelve un return, podemos pasar los datos a una nueva lista e ir comprobando.
        if(alumnosNuevos != null){
            System.out.println("Alumnos Nuevos han sido importados");
        } else {
            System.out.println("Pues no");
        }
    }


    /*1. Usando JSON-P, escribe una lista de al menos cinco objetos de una clase a tu
    elección en un fichero JSON con pretty print. */

    public static void escribir(List<Alumno> alumnos, String ruta) {
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder(); //Nos creamos un arrayBuilder.

        for (Alumno a : alumnos) {
            arrayBuilder.add(Json.createObjectBuilder() //Recorremos la lista de Alumnos para añadir en el arrayBuilder Objetos creados para JSON.
                    .add("nombre", a.getNombre())
                    .add("ID", a.getNumero())
                    .add("profesor", a.isProfesor()));

        }

        Map<String, Object> config = Map.of(JsonGenerator.PRETTY_PRINTING, true);
        JsonWriterFactory writerFactory = Json.createWriterFactory(config); //Para que nos salga bonita la escritura de los objetos dentro del fichero, tendremos que hacer pretty printing.

        try (FileWriter fw = new FileWriter(ruta);
             JsonWriter jsonWriter = writerFactory.createWriter(fw)) { //Creamos un FW(le pasamos ruta), y luego creamos un JsonWriter para escribir lo que hay dentro del arraybuilder en un fichero.JSON
            jsonWriter.writeArray(arrayBuilder.build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
        /*2. Léelos de vuelta y muéstralos por pantalla.*/

    public static List<Alumno> leerAlumnos(String ruta) throws IOException {
        List<Alumno> alumnos = new ArrayList<>(); //Hacemos una lista de alumnos.
        try (FileReader fr = new FileReader(ruta); // Creamos un FR con la ruta que le hemos introducido al metodo
             JsonReader jsonReader = Json.createReader(fr)) {// Creamos un jsonReader pasandole el FR
            for (JsonValue valor : jsonReader.readArray()) { // Hacemos un for y pasamos lo que hemos leido con el jsonReader a un JsonValue (valor)
                JsonObject obj = valor.asJsonObject(); // Y ese valor lo transformamos a un Objeto.
                alumnos.add(new Alumno(obj.getString("nombre"), //Y ya teniendo este objeto, podemos añadir a nuestra lista los alumnos correspondientes con sus parametros.
                        (short) obj.getInt("ID"), obj.getBoolean("profesor")));
            }
        }
        return alumnos; //Nos devuelve la lista de alumnos
    }

    /*3. Implementa con JSON-P una nueva versión de PokemonDAO que almacene los
    datos en un fichero JSON */

    /* !!!POR HACER!!! */

}
