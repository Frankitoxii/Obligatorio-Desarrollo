public abstract class Persona {
    protected String nombre;

    protected String apellido;

    protected int cedula;
    protected double salario = 40000;

    public Persona(String nombre, String apellido, int cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
    }

   public  abstract double prima();


    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getCedula() {
        return cedula;
    }



}

