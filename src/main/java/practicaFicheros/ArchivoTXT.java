package practicaFicheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class ArchivoTXT {
    private Path ruta;

    public ArchivoTXT (String camino) {
        if (Files.exists(Path.of(camino)) && !Files.isDirectory(Path.of(camino))) {
            this.ruta = Path.of(camino);
            System.out.println("Es un fichero");
        } else {
            System.out.println("No es un fichero");
        }
    }

    public void aVerso() {
        String linea;
        String[] partes;

        try (BufferedReader lector = Files.newBufferedReader(this.ruta)) {
            while ((linea = lector.readLine()) != null) {
                partes=linea.split("\\.");
                if (partes.length>0) {
                    for (int i = 0; i < partes.length; i++) {
                        System.out.println(partes[i]);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public void codifica(String ficheroDestino) {
        int letra;

        try (FileReader lector = new FileReader(this.ruta.toFile()); BufferedWriter escritor = Files.newBufferedWriter(Path.of(ficheroDestino))) {
            while ((letra = lector.read()) != -1) {
                // Convertimos el entero a char para mostrar la letra
                char valor = (char) letra ;
                if (valor=='a' || valor=='e' || valor=='i' || valor=='o' || valor=='u') {
                    escritor.write(' ');
                } else {
                    escritor.write(valor);
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void mover(String moverFichero) throws IOException {
        try {
            Files.move(this.ruta, Path.of(moverFichero));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if(isEmpty(this.ruta.getParent())){

        }
    }

}
