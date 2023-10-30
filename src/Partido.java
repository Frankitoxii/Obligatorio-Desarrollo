import java.time.LocalDate;
import java.time.LocalTime;


public class Partido {
    private int id;
    private Equipo local;
    private Equipo visitante;
    private int arbitro;
    private LocalDate fecha;
    private LocalTime hora;

    public Partido(int id,Equipo local, Equipo visitante, int arbitro, LocalDate fecha, LocalTime hora) {
        this.id=id;
        this.local = local;
        this.visitante = visitante;
        this.arbitro = arbitro;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }
    public String mostrarInformacion() {
        return  "@======================@" +
                "\nId: " + id + " " +
                "\nEquipo local : " + local.getNombre() + " " +
                "\nEquipo visitante: " + visitante.getNombre() + " " +
                "\nArbitro: " + arbitro + " " +
                "\nFecha: " + fecha + " " +
                "\nHora: " + hora + " " +
                "\n@======================@";
    }
}
