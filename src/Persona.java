public abstract class Persona {
    protected String nombre;

    protected String apellido;

    protected int cedula;
    protected double salario=40000;

    public Persona(String nombre, String apellido, int cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
}
