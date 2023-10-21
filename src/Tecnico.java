public class Tecnico extends Persona{
    private String equipo;
    public Tecnico(String nombre, String apellido, int cedula, String equipo) {
        super(nombre, apellido, cedula);
        this.equipo = equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }



    public String mostrarInformacion() {
        return  "@======================@" +
                "\nNombre: " + nombre + " " +
                "\nApellido: " + apellido + " " +
                "\nCedula: " + cedula + " " +
                "\nEquipo: " + equipo + " " +
                "\n@======================@";
    }
}
