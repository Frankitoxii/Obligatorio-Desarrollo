import java.util.List;
import java.util.Scanner;

public class Jugador extends Persona{
    private String equipo;

    private String posicion;

    private int minutosJ;

    public Jugador(String nombre, String apellido, int cedula, String equipo, String posicion, int minutosJ) {
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

    public int getMinutosJ() {
        return minutosJ;
    }

    //Sets
    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public void setMinutosJ(int minutosJ) {
        this.minutosJ = minutosJ;
    }



    public String mostrarInformacion() {
        return  "@======================@" +
                "\nNombre: " + nombre + " " +
                "\nApellido: " + apellido + " " +
                "\nCedula: " + cedula + " " +
                "\nEquipo: " + equipo + " " +
                "\nPosicion: " + posicion + " " +
                "\nMinutos jugados: " + minutosJ + " " +
                "\n@======================@";
    }


}
