import java.util.List;
import java.util.Scanner;

public class Jugador extends Persona implements IPrecalentar{
    private String equipo;

    private String posicion;

    private int minutosJ;

    public Jugador(String nombre, String apellido, int cedula, String equipo, String posicion, int minutosJ)
    {
        super(nombre, apellido, cedula);
        this.equipo = equipo;
        this.posicion = posicion;
        this.minutosJ = minutosJ;
    }

    //Gets
    public String getEquipo() {
        return equipo;
    }

    public String getPosicion() {
        return posicion;
    }

    //Sets
    public void setMinutosJ(int minutosJ) {
        this.minutosJ = minutosJ;
    }

    //Prima
    @Override
    public double prima()
    {
        return super.salario + super.salario * 0.2;
    }

    public String mostrarInformacion()
    {
        //Colores para la consola
        String RESET = "\u001B[0m";
        String PURPLE = "\u001B[35m";

        return  PURPLE + "@======================@" +
                "\nNombre: " + nombre + " " +
                "\nApellido: " + apellido + " " +
                "\nCedula: " + cedula + " " +
                "\nEquipo: " + equipo + " " +
                "\nPosicion: " + posicion + " " +
                "\nMinutos jugados: " + minutosJ + " " +
                "\n@======================@" + RESET;
    }

    @Override
    public void precalentar()
    {
        //Colores para la consola
        String GREEN = "\u001B[32m";
        String RESET = "\u001B[0m";

        System.out.println(GREEN + "[El jugador " + nombre +" "+ apellido + " esta precalentando durante 15 minutos]" + RESET);
    }
}
