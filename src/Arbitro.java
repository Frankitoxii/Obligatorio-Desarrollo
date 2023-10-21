public class Arbitro extends Persona{
    private int cantidadPD;
    private int añosTrabajados;
    public Arbitro(String nombre, String apellido, int cedula, int cantidadPD) {
        super(nombre, apellido, cedula);
        this.cantidadPD = cantidadPD;
    }

    public void setCantidadPD(int cantidadPD) {
        this.cantidadPD = cantidadPD;
    }

    public double prima(){
        int contador = 0;
        if(añosTrabajados>5) {
            for (int i = 5; i < añosTrabajados; i++) {
                añosTrabajados += 0.03;
                contador++;
            }
        }
    }
    public String mostrarInformacion() {
        return  "@======================@" +
                "\nNombre: " + nombre + " " +
                "\nApellido: " + apellido + " " +
                "\nCedula: " + cedula + " " +
                "\nCantidad de partidos dirigidos: " + cantidadPD + " " +
                "\n@======================@";
    }

}
