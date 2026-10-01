package practicaJSON;

public class Alumno {

    private String nombre;
    private int numero;
    private boolean profesor;

    public Alumno(String nombre, int numero, boolean profesor) {
        this.nombre = nombre;
        this.numero = numero;
        this.profesor = profesor;
    }

    public String getNombre() { return nombre; }
    public int getNumero() { return numero; }
    public boolean isProfesor() { return profesor; }


}
