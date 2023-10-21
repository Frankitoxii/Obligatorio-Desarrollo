import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class Main {
    static List<Jugador> jugadores = new ArrayList<>();
    static List<Equipo> equipos = new ArrayList<>();
    static List<Tecnico> tecnicos = new ArrayList<>();
    static List<Arbitro> arbitros = new ArrayList<>();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        while (!salir)
        {
            String[] mensajes = {
                    "+----------------------------------------------------------------+",
                    "Opciones:",
                    "0.  Salir",
                    "1.  Agregar un jugador",
                    "2.  Eliminar un jugador",
                    "3.  Modificar un jugador",
                    "4.  Mostrar informacion de los jugadores",
                    "5.  Agregar Técnico",
                    "6.  Eliminar Técnico",
                    "7.  Modificar Técnico",
                    "8.  Mostrar información de los técnicos",
                    "9.  Agregar un árbitro",
                    "10. Eliminar árbitro",
                    "11. Modificar árbitro",
                    "12. Mostrar información de los árbitros",
                    "+----------------------------------------------------------------+",
                    "Seleccione una opcion:"
            };

            for(String mensaje : mensajes)
            {
                System.out.println(mensaje);
            }

            int opcion = scanner.nextInt();

            switch (opcion)
            {
                case 0:
                    salir = true;
                    break;
                case 1:
                    agregarJugador(jugadores);
                    break;
                case 2:
                    eliminarJugadores(jugadores);
                    break;
                case 3:
                    modificarJugador(jugadores);
                    break;
                case 4:
                    mostrarJugadores(jugadores);
                    break;
                case 5:
                    agregarTecnicos(tecnicos);
                    break;
                case 6:
                    eliminarTecnicos(tecnicos);
                    break;
                case 7:
                    modificarTecnicos(tecnicos);
                    break;
                case 8:
                    mostrarTecnicos(tecnicos);
                    break;
                case 9:
                    agregarArbitros(arbitros);
                    break;
                case 10:
                    eliminarArbitros(arbitros);
                    break;
                case 11:
                    modificarArbitros(arbitros);
                    break;
                case 12:
                    mostrarArbitros(arbitros);
                    break;
            }
        }
    }


    static void agregarJugador(List<Jugador> jugadores)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el apellido:");
        String apellido = scanner.nextLine();

        System.out.println("Ingrese la cedula:");
        int cedula = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        System.out.println("Ingrese el nombre del equipo:");
        String equipo = scanner.nextLine();

        System.out.println("Ingrese la posicion:");
        String posicion = scanner.nextLine();

        System.out.println("Ingrese los minutos jugados:");
        int minutosJ = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        //Agregar el jugador a la lista
        jugadores.add(new Jugador(nombre, apellido, cedula, equipo, posicion, minutosJ));
        System.out.println("");
        System.out.println("+---------------------------+");
        System.out.println("Jugador ingresado con exito!!");
        System.out.println("+---------------------------+");

    }

    static void eliminarJugadores(List<Jugador> jugadores)
    {
        Scanner scanner = new Scanner(System.in);
        boolean jugadorEncontrado = false;

        System.out.println("Ingrese la cedula del jugador:");
        int cedula = scanner.nextInt();
        for(Jugador jugador : jugadores)
        {
            if (jugador.cedula == cedula)
            {
                jugadores.remove(jugador);
                System.out.println("+---------------------------+");
                System.out.println("Jugador eliminado con exito!!");
                System.out.println("+---------------------------+");
                jugadorEncontrado = true;
                break;
            }

        }
        if(!jugadorEncontrado)
        {
            System.out.println("+--------------------+");
            System.out.println("El jugador no existe!!");
            System.out.println("+--------------------+");
        }
    }

    static void modificarJugador(List<Jugador> jugadores)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la cedula del jugador:");
        int cedula = scanner.nextInt();

        for(Jugador jugador : jugadores)
        {
            if(jugador.cedula == cedula)
            {

                System.out.println("Ingrese los minutos jugados:");
                int minutosJ = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea

                jugador.setMinutosJ(minutosJ);
                System.out.println("Minutos jugados modificados con exito!");
                System.out.println("Ahora los minutos jugados son " + minutosJ);
                break;
            }
            else
            {
                System.out.println("Jugador no encontrado!");
            }
        }
    }

    static void mostrarJugadores(List<Jugador> jugadores)
    {
        Scanner scanner = new Scanner(System.in);
        String[] mensajes = {
                "+----------------------------------------------+",
                "Opciones:",
                "1. Mostrar informacion de todos los jugadores",
                "2. Mostrar informacion de un jugador",
                "+----------------------------------------------+",
                "Ingrese una opcion:"
        };
        for(String mensaje : mensajes)
        {
            System.out.println(mensaje);
        }
        System.out.println("Opciones:");
        int opcion = scanner.nextInt();

        boolean salir = false;

        switch (opcion)
        {
            case 0:
                salir = true;
                break;
            //Mostrar informacion de todos los jugadores
            case 1:
                for(Jugador jugador : jugadores)
                {
                    System.out.println(jugador.mostrarInformacion());
                }
                break;
            //Mostrar informacion de un solo jugador
            case 2:
                System.out.println("Ingrese la cedula del jugador:");
                int cedula = scanner.nextInt();
                for(Jugador jugador : jugadores)
                {
                    if (jugador.cedula == cedula)
                    {
                        System.out.println(jugador.mostrarInformacion());
                    }
                }
                break;

        }

    }

    static void agregarTecnicos(List<Tecnico> tecnicos)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el apellido:");
        String apellido = scanner.nextLine();

        System.out.println("Ingrese la cedula:");
        int cedula = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        System.out.println("Ingrese el nombre del equipo:");
        String equipo = scanner.nextLine();

        //Agregar el tecnico a la lista
        tecnicos.add(new Tecnico(nombre, apellido, cedula, equipo));
        System.out.println("");
        System.out.println("+---------------------------+");
        System.out.println("Tecnico ingresado con exito!!");
        System.out.println("+---------------------------+");

    }
    static void eliminarTecnicos(List<Tecnico> tecnicos)
    {
        Scanner scanner = new Scanner(System.in);
        boolean tecnicoEncontrado = false;

        System.out.println("Ingrese la cedula del técnico:");
        int cedula = scanner.nextInt();
        for(Tecnico tecnico : tecnicos)
        {
            if (tecnico.cedula == cedula)
            {
                jugadores.remove(tecnico);
                System.out.println("+---------------------------+");
                System.out.println("Técnico eliminado con exito!!");
                System.out.println("+---------------------------+");
                tecnicoEncontrado = true;
                break;
            }

        }
        if(!tecnicoEncontrado)
        {
            System.out.println("+--------------------+");
            System.out.println("El técnico no existe!!");
            System.out.println("+--------------------+");
        }
    }
    static void modificarTecnicos(List<Tecnico> tecnicos)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la cedula del técnico:");
        int cedula = scanner.nextInt();

        for(Tecnico tecnico : tecnicos)
        {
            if(tecnico.cedula == cedula)
            {

                System.out.println("Ingrese el nombre del equipo:");
                String equipo = scanner.nextLine();

                tecnico.setEquipo(equipo);
                System.out.println("Equipo modificado con éxito!");
                break;
            }
            else
            {
                System.out.println("Técnico no encontrado!");
            }
        }
    }
    static void mostrarTecnicos(List<Tecnico> tecnicos){
        for (Tecnico tecnico:tecnicos) {
            System.out.println(tecnico.mostrarInformacion());
        }
    }

    static void agregarArbitros(List<Arbitro> arbitros){

            Scanner scanner = new Scanner(System.in);

            System.out.println("Ingrese el nombre:");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese el apellido:");
            String apellido = scanner.nextLine();

            System.out.println("Ingrese la cedula:");
            int cedula = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            System.out.println("Ingrese la cantidad de partidos dirigidos:");
            int cantidadPD = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            //Agregar el jugador a la lista
            arbitros.add(new Arbitro(nombre, apellido, cedula, cantidadPD));
            System.out.println("");
            System.out.println("+---------------------------+");
            System.out.println("Árbitro ingresado con exito!!");
            System.out.println("+---------------------------+");
    }
    static void eliminarArbitros(List<Arbitro> arbitros)
    {
        Scanner scanner = new Scanner(System.in);
        boolean arbitroEncontrado = false;

        System.out.println("Ingrese la cedula del árbitro:");
        int cedula = scanner.nextInt();
        for(Arbitro arbitro : arbitros)
        {
            if (arbitro.cedula == cedula)
            {
                arbitros.remove(arbitro);
                System.out.println("+---------------------------+");
                System.out.println("Árbitro eliminado con éxito!!");
                System.out.println("+---------------------------+");
                arbitroEncontrado = true;
                break;
            }

        }
        if(!arbitroEncontrado)
        {
            System.out.println("+--------------------+");
            System.out.println("El árbitro no existe!!");
            System.out.println("+--------------------+");
        }
    }
    static void modificarArbitros(List<Arbitro> arbitros)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la cedula del arbitro:");
        int cedula = scanner.nextInt();

        for(Arbitro arbitro : arbitros)
        {
            if(arbitro.cedula == cedula)
            {

                System.out.println("Ingrese la cantidad de partidos dirigidos: ");
                int cantidadPD = scanner.nextInt();

                arbitro.setCantidadPD(cantidadPD);
                System.out.println("Cantidad de Partidos Dirigidos modificado con éxito!");
                break;
            }
            else
            {
                System.out.println("Árbitro no encontrado!");
            }
        }
    }
    static void mostrarArbitros(List<Arbitro> arbitros){
        for (Arbitro arbitro:arbitros) {
            System.out.println(arbitro.mostrarInformacion());
        }
    }






}
