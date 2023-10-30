public class Arbitro extends Persona implements IPrecalentar{
    private int cantidadPD;
    private int añosTrabajados;
    public Arbitro(String nombre, String apellido, int cedula, int cantidadPD,int añosTrabajados)
    {
        super(nombre, apellido, cedula);
        this.cantidadPD = cantidadPD;
        this.añosTrabajados = añosTrabajados;
    }

    public void setCantidadPD(int cantidadPD)
    {
        this.cantidadPD = cantidadPD;
    }

    //Prima
    @Override
    public double prima()
    {

        double salarioA = super.salario;
        double aumento = 0.03;

        for (int i = 1; i < añosTrabajados; i++) {

            if(i > 5){
                aumento += 0.03;
            }
        }
        salarioA += salarioA * aumento;
        return salarioA;
    }

    public String mostrarInformacion()
    {
        String PURPLE = "\u001B[35m";
        String RESET = "\u001B[0m";
        return  PURPLE +
                "@======================@" +
                "\nNombre: " + nombre + " " +
                "\nApellido: " + apellido + " " +
                "\nCedula: " + cedula + " " +
                "\nCantidad de partidos dirigidos: " + cantidadPD + " " +
                "\nCantidad de años trabajados: " + añosTrabajados + " " +
                "\n@======================@"
                + RESET;
    }

    @Override
    public void precalentar()
    {
        String RESET = "\u001B[0m";
        String GREEN = "\u001B[32m";
        System.out.println(GREEN + "[El árbitro " + nombre +" "+ apellido + " esta precalentando durante 10 minutos]" + RESET);
    }
}
