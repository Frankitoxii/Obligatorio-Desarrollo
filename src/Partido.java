import java.time.LocalDate;
import java.time.LocalTime;


public class Partido {
    private Equipo local;
    private Equipo visitante;
    private Arbitro arbitro;
    private LocalDate fecha;
    private LocalTime hora;

    public Partido(Equipo local, Equipo visitante, Arbitro arbitro, LocalDate fecha, LocalTime hora) {
        this.local = local;
        this.visitante = visitante;
        this.arbitro = arbitro;
        this.fecha = fecha;
        this.hora = hora;
    }

    public void precalentamiento(){
        System.out.println("Los jugadores están precalentando(15 mins)");
        System.out.println("El árbitro está precalentando(10 mins)");
    }
}
