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

    public Equipo(String nombre, List<Jugador> jugadores)
    {
        this.nombre = nombre;
        this.jugadores = jugadores;
    }
    public Equipo(String nombre)
    {
        this.nombre = nombre;
    }

    public Equipo(List<Jugador> jugadores)
    {
        this.jugadores = jugadores;
    }
    public String getNombre() {
        return nombre;
    }

    public Tecnico getTecnico()
    {
        return tecnico;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void mostrarInformacion()
    {
        System.out.println("Nombre del equipo: " + nombre);
        for(Jugador jugador : jugadores)
        {
            System.out.println(jugador.nombre);
        }

    }
}


