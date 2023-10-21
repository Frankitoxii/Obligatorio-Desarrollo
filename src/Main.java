import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class Main {
    static List<Jugador> jugadores = new ArrayList<>();
    static List<Tecnico> tecnicos = new ArrayList<>();
    static List<Arbitro> arbitros = new ArrayList<>();
    static List<Equipo> equipos = new ArrayList<>();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        while (!salir)
        {
            String[] mensajes = {
                    "+----------------------------------------------------------------+",
                    "Opciones:",
                    "0. Salir",
                    "1. Agregar un equipo",
                    "2. Opciones de jugadores",
                    "3. Opciones de tecnicos",
                    "4. Opciones de arbritos",
                    "5. Info equipos",
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
                    agregarEquipo(equipos);
                    break;
                case 2:
                    opcionesJugador();
                    break;
                case 3:
                    opcionesTecnico();
                    break;
                case 4:
                    opcionesArbrito();
                    break;
                case 5:
                    infoEquipos();
                    break;
            }
        }
    }

    //Metodo para agregar un nuevo equipo
    static void agregarEquipo(List<Equipo> equipos)
    {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Ingrese el nombre del nuevo equipo");
    String nombreEquipo = scanner.nextLine();

    equipos.add(new Equipo(nombreEquipo));
}

          /*SIN TERMINAR*/
    static void infoEquipos()
    {
        for(Equipo equipo : equipos)
        {
            System.out.println(equipo.mostrarInformacion());
        }
    }

    //Este metodo contiene un switch con todas las opciones de los jugadores (agregar, eliminar, modificar y mostrar)
    static void opcionesJugador()
    {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            String[] mensajesJugador = {
                    "+----------------------------------------------------------------+",
                    "Opciones:",
                    "0. Salir",
                    "1. Agregar un jugador.",
                    "2. Eliminar un jugador.",
                    "3. Modificar un jugador.",
                    "4. Mostrar informacion.",
                    "+----------------------------------------------------------------+"
            };

            for (String mensaje : mensajesJugador) {
                System.out.println(mensaje);
            }

            int opcionJugador = scanner.nextInt();

            switch (opcionJugador) {
                case 0:
                    salir = true;
                    break;
                case 1:
                    agregarJugador(jugadores);
                    break;
                case 2:
                    eliminarJugador(jugadores);
                    break;
                case 3:
                    modificarJugador(jugadores);
                    break;
                case 4:
                    mostrarJugadores(jugadores);
                    break;
            }
        }
    }

    /* CRUD De Jugador */
    static void agregarJugador(List<Jugador> jugadores)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el apellido:");
        String apellido = scanner.nextLine();


        int cedula;
        //Validamos si la cedula tiene 8 digitos
        do {
            System.out.println("Ingrese la cédula (debe contener 8 dígitos, sin puntos ni guiones):");
            cedula = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea
        }
        while (String.valueOf(cedula).length() != 8);

        System.out.println("Ingrese el nombre del equipo:");
        String equipoJ = scanner.nextLine();

        // Validacion para el nombre del equipo (la lista de equipos debe tener almenos uno para que esto funcione)
        /*for(Equipo equipo : equipos)
        {
            if (!equipo.getNombre().equals(equipoJ))
            {
                System.out.println("Este equipo no existe");
            }
        }*/

        System.out.println("Ingrese la posición:");
        String posicion = scanner.nextLine();

        System.out.println("Ingrese los minutos jugados:");
        int minutosJ = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        // Agregar el jugador a la lista
        jugadores.add(new Jugador(nombre, apellido, cedula, equipoJ, posicion, minutosJ));
        System.out.println("");
        System.out.println("+---------------------------+");
        System.out.println("Jugador ingresado con éxito!!");
        System.out.println("+---------------------------+");

        equipos.add(new Equipo(jugadores));
        System.out.println();
        System.out.println("+---------------------------+");
        System.out.println("Jugador agregado con éxito al equipo!!");
        System.out.println("+---------------------------+");
    }


    static void eliminarJugador(List<Jugador> jugadores)
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



    //Este metodo contiene un switch con todas las opciones de los tecnicos (agregar, eliminar, modificar y mostrar)
    static void opcionesTecnico()
    {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            String[] mensajesTecnico = {
                    "+----------------------------------------------------------------+",
                    "Opciones:",
                    "0. Salir",
                    "1. Agregar un tecnico.",
                    "2. Eliminar un tecnico.",
                    "3. Modificar un tecnico.",
                    "4. Mostrar informacion.",
                    "+----------------------------------------------------------------+"
            };

            for (String mensaje : mensajesTecnico) {
                System.out.println(mensaje);
            }

            int opcionTecnico = scanner.nextInt();

            switch (opcionTecnico) {
                case 0:
                    salir = true;
                    break;
                case 1:
                   agregarTecnico(tecnicos);
                    break;
                case 2:
                    eliminarTecnico(tecnicos);
                    break;
                case 3:
                  modificarTecnico(tecnicos);
                    break;
                case 4:
                    mostrarTecnicos(tecnicos);
                    break;
            }
        }
    }

    /* CRUD De Tecnico */
    static void agregarTecnico(List<Tecnico> tecnicos)
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

    static void eliminarTecnico(List<Tecnico> tecnicos)
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

    static void modificarTecnico(List<Tecnico> tecnicos)
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



    //Este metodo contiene un switch con todas las opciones de los arbritos (agregar, eliminar, modificar y mostrar)
    static void opcionesArbrito()
    {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            String[] mensajesArbrito = {
                    "+----------------------------------------------------------------+",
                    "Opciones:",
                    "0. Salir",
                    "1. Agregar un arbrito.",
                    "2. Eliminar un arbrito.",
                    "3. Modificar un arbrito.",
                    "4. Mostrar informacion.",
                    "+----------------------------------------------------------------+"
            };

            for (String mensaje : mensajesArbrito) {
                System.out.println(mensaje);
            }

            int opcionTecnico = scanner.nextInt();

            switch (opcionTecnico) {
                case 0:
                    salir = true;
                    break;
                case 1:
                   agregarArbitro(arbitros);
                    break;
                case 2:
                   eliminarArbitro(arbitros);
                    break;
                case 3:
                  modificarArbitro(arbitros);
                    break;
                case 4:
                  mostrarArbitros(arbitros);
                    break;
            }
        }

    }

    /* CRUD De Arbrito */
    static void agregarArbitro(List<Arbitro> arbitros)
    {
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

    static void eliminarArbitro(List<Arbitro> arbitros)
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

    static void modificarArbitro(List<Arbitro> arbitros)
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

    static void mostrarArbitros(List<Arbitro> arbitros)
    {
        for (Arbitro arbitro:arbitros) {
            System.out.println(arbitro.mostrarInformacion());
        }
    }






}
