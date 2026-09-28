package practicaFicheros;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class ProbarFicheros {

    /* 1. Crea un metodo listarDirectorio(Path directorio) que muestre por pan-
    talla el contenido del directorio indicado, comprobando primero que la ruta co-
    rresponde a un directorio. */

    public void listarDirectorio(Path directorio){
        if (Files.isDirectory(directorio)){
            try (var stream = Files.list(directorio)) {
                stream.forEach(System.out::println);
            } catch (IOException e) {
                System.out.println("ERROR" + e.getMessage());
            }
        }
    }

    /* 2. Crea un metodo existeFichero(Path directorio, String nombre) que de-
    vuelva true si el fichero existe en el directorio indicado. */

    public boolean existeFichero (Path directorio, String nombre) {

         Path fichero = directorio.resolve(nombre);
         boolean resul=false;
        if (Files.exists(fichero)) {
            resul=true;
        }
        return resul;
    }

    /* 3. Crea un metodo generarArchivo(Path directorio) que cree en la ruta indi-
    cada un fichero .txt con tu nombre y apellido. ¿Qué ocurre si el directorio no
    existe? Modifica el metodo para que lo cree si es necesario. */

    public void generarArchivo(Path directorio) throws IOException {
        Files.createDirectories(directorio); /* No hace falta poner un if/else, porque si no existe el directorio, con esta sentencia se crea automaticamente, y0 si esta creado ya, no le hace falta utilizarlo */
        Path direc = directorio.resolve("DDRyMGM.txt");
        Files.createFile(direc);
    }

    /* 4. Crea un metodo renombrarArchivo(Path fichero, String nuevoNombre) que
    renombre el fichero indicado. Pruébalo con el fichero del ejercicio anterior. */

    public void renombrarArchivo(Path fichero, String nuevoNombre) throws IOException {
        Path fich = fichero.resolve("DDRyMGM.txt");
        Files.move(fich, fichero.resolve(nuevoNombre), StandardCopyOption.REPLACE_EXISTING);

    }

    /*5. Crea un metodo eliminarDirectorio(Path directorio) que elimine el direc-
    torio indicado si está vacío o contiene solo ficheros, e informe de que no pueden
    hacerlo si contiene subdirectorios.*/

    public void eliminarDirectorio(Path directorio) {
        if (!Files.isDirectory(directorio)) {
            System.out.println("No existe este directorio");
        } else {

            List<Path> listaFicheros = new ArrayList<>();
            boolean fich = true;
            try (var stream = Files.list(directorio)) {
                for (Path e : listaFicheros) {
                    listaFicheros=stream.toList();
                    if (Files.isDirectory(e)){
                        fich = false;
                    }
                }
                if(listaFicheros.isEmpty() || fich) {
                    Files.deleteIfExists(directorio);
                }

            } catch (IOException e) {
                System.out.println("ERROR" + e.getMessage());
            }


        }
    }

}
