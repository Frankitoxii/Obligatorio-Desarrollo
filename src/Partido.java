import java.time.LocalDate;
import java.time.LocalTime;


public class Partido {
    private int id;
    private String local;
    private String visitante;
    private int arbitro;
    private LocalDate fecha;
    private LocalTime hora;

    private int proximoId = 0;

    public Partido(String local, String visitante, int arbitro, LocalDate fecha, LocalTime hora) {
        this.local = local;
        this.visitante = visitante;
        this.arbitro = arbitro;
        this.fecha = fecha;
        this.hora = hora;
        this.id = proximoId + 1;
    }

    public int getId() {
        return id;
    }
    public String mostrarInformacion() {
        //Colores para la consola
        String RESET = "\u001B[0m";
        String PURPLE = "\u001B[35m";

        return  PURPLE +
                "@======================@" +
                "\nId: " + id + " " +
                "\nEquipo local : " + local + " " +
                "\nEquipo visitante: " + visitante + " " +
                "\nArbitro: " + arbitro + " " +
                "\nFecha: " + fecha + " " +
                "\nHora: " + hora + " " +
                "\n@======================@" + RESET;
    }
}
