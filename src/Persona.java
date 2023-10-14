public abstract class Persona {
    protected String nombre;

    protected String apellido;

    protected int cedula;

    public Persona(String nombre, String apellido, int cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
    }
}
