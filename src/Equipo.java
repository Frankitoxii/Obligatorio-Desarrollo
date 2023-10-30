import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private String nombre;
    private Tecnico tecnico;

    private List<Jugador> jugadores;



    public Equipo(String nombre,Tecnico tecnico, List<Jugador> jugadores) {
        this.nombre = nombre;
        this.tecnico = tecnico;
        this.jugadores = jugadores;
    }

    public Equipo(String nombre)
    {
        this.nombre = nombre;
        this.jugadores = new ArrayList<>();
    }


    public String getNombre() {
        return nombre;
    }


    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public void agregarTecnico(Tecnico tecnico)
    {
       this.tecnico = tecnico;
    }

    public void mostrarInformacion()
    {
        //Colores para la consola
        String RESET = "\u001B[0m";
        String PURPLE = "\u001B[35m";
        System.out.println(PURPLE + "@=================================================@");
        System.out.println("Nombre del equipo: " + nombre);
        System.out.println("Jugadores: ");
        for (Jugador jugador : jugadores) {
            System.out.println("Nombre: " + jugador.getNombre() + " Apellido: " + jugador.getApellido() + " Posicion: " + jugador.getPosicion());
        }
        System.out.printf(" ");
        System.out.println("Tecnico:");
        System.out.println("Nombre " + this.tecnico.getNombre() + " Apellido" +this.tecnico.getApellido());
        System.out.println("@=================================================@" + RESET);
    }
}


