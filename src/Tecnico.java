public class Tecnico extends Persona{
    private String equipo;
    private int partidosG;

    public Tecnico(String nombre, String apellido, int cedula,int partidosG, String equipo) {
        super(nombre, apellido, cedula);
        this.partidosG = partidosG;
        this.equipo = equipo;
    }

    public int getPartidosG() {
        return partidosG;
    }


    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    @Override
    public double prima()
    {
        return super.salario + super.salario * 0.1;
    }
    public String mostrarInformacion()
    {
        //Colores para la consola
        String RESET = "\u001B[0m";
        String PURPLE = "\u001B[35m";

        return PURPLE +
                "@======================@" +
                "\nNombre: " + nombre + " " +
                "\nApellido: " + apellido + " " +
                "\nCedula: " + cedula + " " +
                "\nPartidos ganados: "  + partidosG + " " +
                "\nEquipo: " + equipo + " " +
                "\n@======================@" +
                " " +
                RESET;
    }
}
