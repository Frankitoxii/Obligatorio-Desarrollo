import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //Listas
    static List<Jugador> jugadores = new ArrayList<>();
    static List<Tecnico> tecnicos = new ArrayList<>();
    static List<Arbitro> arbitros = new ArrayList<>();
    static List<Equipo> equipos = new ArrayList<>();
    static List<Partido> partidos = new ArrayList<>();

    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        //Codigos de colores para la consola
        String RESET = "\u001B[0m";
        String BLUE = "\u001B[34m";

        while (!salir) {
            String[] mensajes = {
                    "+--------[Opciones]--------+",
                    "0. Salir",
                    "1. Agregar un equipo",
                    "2. Opciones de jugadores",
                    "3. Opciones de tecnicos",
                    "4. Opciones de árbitros",
                    "5. Opciones de partidos",
                    "6. Info equipos",
                    "+--------------------------+",
                    ">>Seleccione una opcion:"
            };

            for (String mensaje : mensajes) {
                System.out.println(BLUE + mensaje + RESET);
            }

            //Escaner para la opcion seleccionada
            int opcion = scanner.nextInt();

            //Opciones
            switch (opcion) {
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
                    opcionesArbitro();
                    break;
                case 5:
                    opcionesPartido();
                    break;
                case 6:
                    infoEquipos();
                    break;
            }
        }
    }

    //Metodo para agregar un nuevo equipo
    static void agregarEquipo(List<Equipo> equipos) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del nuevo equipo:");
        String nombreEquipo = scanner.nextLine();

        //Validamos si ese equipo ya existe
        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equals(nombreEquipo)) {
                //Mensaje en color rojo
                String RESET = "\u001B[0m";
                String RED = "\u001B[31m";
                System.out.println(RED + "[Error, el equipo ya existe]" + RESET);
                return;
            }
        }

        //Mensaje en color verde
        String RESET = "\u001B[0m";
        String GREEN = "\u001B[32m";
        System.out.println(" ");
        System.out.println(GREEN + "[Equipo creado con exito]" + RESET);
        System.out.println(" ");
        equipos.add(new Equipo(nombreEquipo));
    }

    //Metodo para mostrar informacion de los equipos
    static void infoEquipos() {
        for (Equipo equipo : equipos) {
            equipo.mostrarInformacion();
        }
    }


    //Este metodo contiene un switch con todas las opciones de los jugadores (agregar, eliminar, modificar y mostrar)
    static void opcionesJugador()
    {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        //Colores para la consola
        String CYAN = "\u001B[36m";
        String RESET = "\u001B[0m";

        while (!salir) {
            String[] mensajesJugador = {
                    " ",
                    "+-----[Opciones de jugador]-----+",
                    "0. Salir",
                    "1. Agregar un jugador",
                    "2. Eliminar un jugador",
                    "3. Modificar un jugador",
                    "4. Mostrar informacion",
                    "5. Precalentamiento",
                    "6. Salario",
                    "+------------------------------+",
                    ">>Seleccione una opcion:"
            };

            for (String mensaje : mensajesJugador) {
                System.out.println(CYAN + mensaje + RESET);
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
                case 5:
                    precalentamientoJugador();
                    break;
                case 6:
                    salarioJugador();
                    break;
            }
        }
    }

    static void precalentamientoJugador()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cedula del jugador");
        int cedula = scanner.nextInt();
        scanner.nextLine();
        for(Jugador jugador: jugadores) {
            if (jugador.getCedula() == cedula) {
                jugador.precalentar();
            }
        }
    }

    /* CRUD De Jugador */
    static void agregarJugador(List<Jugador> jugadores)
    {
        //Colores para la consola
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String RESET = "\u001B[0m";

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

        //Validamos si la cedula ya esta en uso
        for (Jugador jugador : jugadores) {
            if (jugador.cedula == cedula) {
                System.out.println(" ");
                System.out.println(RED + "[Esta cedula ya esta en uso]" + RESET);
                return;
            }
        }

        System.out.println("Ingrese el nombre del equipo:");
        String equipoJ = scanner.nextLine();

        // Buscar el equipo en la lista de equipos
        Equipo equipoSeleccionado = null;
        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equals(equipoJ)) {
                equipoSeleccionado = equipo;
                break;
            }
        }
        //Si el equipo no existe da un mensaje
        if (equipoSeleccionado == null) {
            System.out.println(" ");
            System.out.println(RED + "[Este equipo no existe]" + RESET);
            return;
        }


        System.out.println("Ingrese la posición:");
        String posicion = scanner.nextLine();

        System.out.println("Ingrese los minutos jugados:");
        int minutosJ = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea


        //Validamos si el equipo tiene mas de 7 jugadores
        int jugadoresEquipo = 0;
        for (Jugador jugador : jugadores) {
            if (jugador.getEquipo().equals(equipoJ)) {
                jugadoresEquipo++;
            }
        }
        if (jugadoresEquipo == 7) {
            System.out.println(RED + "[No es posible agregar mas jugadores a este equipo]" + RESET);
            return;
        }

        jugadores.add(new Jugador(nombre, apellido, cedula, equipoJ, posicion, minutosJ));
        System.out.println(" ");
        System.out.println(GREEN + "[Jugador ingresado con exito]" + RESET);

        equipoSeleccionado.agregarJugador(new Jugador(nombre, apellido, cedula, equipoJ, posicion, minutosJ));
        System.out.println(" ");
        System.out.println(GREEN + "[Jugador ingresado con exito al equipo]" + RESET);

    }

    static void eliminarJugador(List<Jugador> jugadores)
    {
        //Colores para la consola
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String RESET = "\u001B[0m";

        Scanner scanner = new Scanner(System.in);
        boolean jugadorEncontrado = false;

        System.out.println("Ingrese la cedula del jugador:");
        int cedula = scanner.nextInt();
        //Buscar si existe un jugador con la cedula ingresada
        for (Jugador jugador : jugadores) {
            if (jugador.cedula == cedula) {
                jugadores.remove(jugador);
                System.out.println(" ");
                System.out.println(GREEN + "[Jugador eliminado con exito]" + RESET);

                jugadorEncontrado = true;
                break;
            }

        }
        if (!jugadorEncontrado) {
            System.out.println(" ");
            System.out.println(RED + "[El jugador no existe]" + RESET);
        }
    }

    static void modificarJugador(List<Jugador> jugadores)
    {
        //Colores para la consola
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String RESET = "\u001B[0m";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la cedula del jugador:");
        int cedula = scanner.nextInt();

        for (Jugador jugador : jugadores) {
            if (jugador.cedula == cedula) {

                System.out.println("Ingrese los minutos jugados:");
                int minutosJ = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea

                jugador.setMinutosJ(minutosJ);
                System.out.println(GREEN + "[Minutos jugados modificados con exito]" + RESET);
                System.out.println(GREEN + "[Ahora los minutos jugados son " + minutosJ + "]" + RESET);
                break;
            } else {
                System.out.println(RED + "[Jugador no encontrado]" + RESET);
            }
        }
    }

    static void mostrarJugadores(List<Jugador> jugadores)
    {
        //Colores para la consola
        String RESET = "\u001B[0m";
        String CYAN = "\u001B[36m";
        String RED = "\u001B[31m";

        Scanner scanner = new Scanner(System.in);

        String[] mensajes = {
                "+-----------[Informacion de jugadores]-----------+",
                "0. Salir",
                "1. Mostrar informacion de todos los jugadores",
                "2. Mostrar informacion de un jugador",
                "+------------------------------------------------+",
                ">>Ingrese una opcion:"
        };

        for (String mensaje : mensajes) {
            System.out.println(CYAN + mensaje + RESET);
        }

        //Capturar la opcion
        int opcion = scanner.nextInt();

        boolean salir = false;

        switch (opcion) {
            case 0:
                salir = true;
                break;
            //Mostrar informacion de todos los jugadores
            case 1:
                for (Jugador jugador : jugadores) {
                    System.out.println(jugador.mostrarInformacion());
                }
                break;
            //Mostrar informacion de un solo jugador
            case 2:
                System.out.println("Ingrese la cedula del jugador:");
                int cedula = scanner.nextInt();
                for (Jugador jugador : jugadores) {
                    if (jugador.cedula == cedula) {
                        System.out.println(jugador.mostrarInformacion());
                    } else {
                        System.out.println(" ");
                        System.out.println(RED + "[Jugador no encontrado]" + RESET);
                    }
                }
                break;
        }

    }

    static void salarioJugador()
    {
        //Colores para la consola
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String RESET = "\u001B[0m";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa la cedula del jugador");
        int cedula = scanner.nextInt();
        scanner.nextLine();

        for (Jugador jugador : jugadores)
        {
            if (jugador.cedula == cedula)
            {
                System.out.println(GREEN + "[El salario de este jugador es de $" + jugador.prima() + "]"+  RESET);
            }
            else
            {
                System.out.println(RED + "[Este jugador no existe]" + RESET);
            }
        }
    }


    //Este metodo contiene un switch con todas las opciones de los tecnicos (agregar, eliminar, modificar y mostrar)
    static void opcionesTecnico()
    {
        //Colores para la consola
        String RESET = "\u001B[0m";
        String CYAN = "\u001B[36m";

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            String[] mensajesTecnico = {
                    "+-----[Opciones de tecnicos]-----+",
                    "0. Salir",
                    "1. Agregar un tecnico",
                    "2. Eliminar un tecnico",
                    "3. Modificar un tecnico",
                    "4. Mostrar informacion",
                    "5. Salario",
                    "+--------------------------------+",
                    ">>Seleccione una opcion:"
            };

            for (String mensaje : mensajesTecnico) {
                System.out.println(CYAN + mensaje + RESET);
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
                case 5:
                    salarioTecnico();
                    break;
            }
        }
    }

    /* CRUD De Tecnico */
    static void agregarTecnico(List<Tecnico> tecnicos)
    {
        Scanner scanner = new Scanner(System.in);

        //Colores para la consola
        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";

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

        //Validamos si la cedula ya esta en uso
        for (Tecnico tecnico : tecnicos) {
            if (tecnico.cedula == cedula) {
                System.out.println(" ");
                System.out.println(RED + "[Esta cedula ya esta en uso]" + RESET);
                System.out.println("");
                return;
            }
        }
            System.out.println("Ingrese la cantidad de partidos ganados:");
            int partidosG = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Ingrese el nombre del equipo:");
            String equipoT = scanner.nextLine();

            // Buscar el equipo en la lista de equipos
            Equipo equipoSeleccionado = null;
            for (Equipo equipo : equipos) {
                if (equipo.getNombre().equals(equipoT)) {
                    equipoSeleccionado = equipo;
                    break;
                }
            }
            //Si el equipo no existe da un mensaje
            if (equipoSeleccionado == null) {
                System.out.println(" ");
                System.out.println(RED + "[Este equipo no existe]" + RESET);
                return;
            }

            /*int tecnicosEnEquipo = 0;
            for (Tecnico tecnico : tecnicos) {
            if (tecnico.getEquipo().equals(equipoSeleccionado)) {
                tecnicosEnEquipo++;
             }
            }
            if (tecnicosEnEquipo > 0) {
                System.out.println("");
                System.out.println(RED + "[No es posible agregar mas tecnicos a este equipo]" + RESET);
                System.out.println("");
                return;
            }*/

            //Agregar el tecnico a la lista
            tecnicos.add(new Tecnico(nombre, apellido, cedula, partidosG, equipoT));
            System.out.println("");
            System.out.println(GREEN + "[Tecnico ingresado con exito]" + RESET);
            System.out.println("");

        equipoSeleccionado.agregarTecnico(new Tecnico(nombre, apellido,cedula, partidosG, equipoT));
        System.out.println(" ");
        System.out.println(GREEN + "[Tecnico ingresado con exito al equipo]" + RESET);
        }

    static void eliminarTecnico(List<Tecnico> tecnicos)
    {
        Scanner scanner = new Scanner(System.in);

        //Colores para la consola
        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";

        boolean tecnicoEncontrado = false;

        System.out.println("Ingrese la cedula del técnico:");
        int cedula = scanner.nextInt();
        for(Tecnico tecnico : tecnicos)
        {
            if (tecnico.cedula == cedula)
            {
                jugadores.remove(tecnico);
                System.out.println(" ");
                System.out.println(GREEN + "[Técnico eliminado con exito]" + RESET);
                System.out.println("");
                tecnicoEncontrado = true;
                break;
            }

        }
        if(!tecnicoEncontrado)
        {
            System.out.println(" ");
            System.out.println(RED + "[El tecnico no existe]" + RESET);
            System.out.println(" ");
        }
    }

    static void modificarTecnico(List<Tecnico> tecnicos)
    {
        //Colores para la consola
        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";
        String YELLOW = "\u001B[33m";
        String GREEN = "\u001B[32m";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la cedula del técnico:");
        int cedula = scanner.nextInt();
        scanner.nextLine();
        for(Tecnico tecnico : tecnicos)
        {
            if(tecnico.cedula == cedula)
            {
                System.out.println("Ingrese el nombre del equipo:");
                String equipoT = scanner.nextLine();

                tecnico.setEquipo(equipoT);
                System.out.println(" ");
                System.out.println(GREEN + "[Tecnico modificado con éxito]" + RESET);
                System.out.println(GREEN + "[Ahora el nuevo equipo del tecnico es " +  YELLOW + equipoT + RESET + GREEN + "]" + RESET);
                break;
            }
            else
            {
                System.out.println(RED + "[Técnico no encontrado]" + RESET);
            }
        }
    }

    static void mostrarTecnicos(List<Tecnico> tecnicos)
    {
        for (Tecnico tecnico:tecnicos) {
            System.out.println(tecnico.mostrarInformacion());
        }
    }

    static void salarioTecnico()
    {
        //Colores para la consola
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String RESET = "\u001B[0m";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa la cedula del tecnico");
        int cedula = scanner.nextInt();
        scanner.nextLine();

        for (Tecnico tecnico : tecnicos)
        {
            if (tecnico.cedula == cedula)
            {
                if(tecnico.getPartidosG() > 3)
                {
                    System.out.println(GREEN + "[El salario de este tecnico es de $" + tecnico.prima() + "]"+  RESET);
                }
              else
                {
                    System.out.println(RED + "[Este tecnico no tiene mas de 3 partidos ganados]" + RESET);
                }
            }
            else
            {
                System.out.println(RED + "[Este tecnico no existe]" + RESET);
            }
        }
    }

    //Este metodo contiene un switch con todas las opciones de los arbitros (agregar, eliminar, modificar y mostrar)
    static void opcionesArbitro()
    {
        //Colores para la consola
        String RESET = "\u001B[0m";
        String CYAN = "\u001B[36m";

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            String[] mensajesArbitro = {
                    "+-------[Opciones arbitros]-------+",
                    "0. Salir",
                    "1. Agregar un árbitro",
                    "2. Eliminar un árbitro",
                    "3. Modificar un árbitro",
                    "4. Mostrar informacion",
                    "5. Precalentamiento",
                    "6. Salario arbitro",
                    "+----------- --------------------+"
            };

            for (String mensaje : mensajesArbitro) {
                System.out.println(CYAN + mensaje + RESET);
            }

            int opcionArbitro = scanner.nextInt();

            switch (opcionArbitro) {
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
                case 5:
                    precalentamientoArbitro();
                    break;
                case 6 :
                    salarioArbitro();
                    break;

            }
        }

    }

    static void precalentamientoArbitro()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cedula del arbitro");
        int cedula = scanner.nextInt();
        scanner.nextLine();

        for(Arbitro arbitro:arbitros) {
            if (arbitro.getCedula() == cedula) {
                arbitro.precalentar();
            }
        }
    }

    /* CRUD De Arbrito */
    static void agregarArbitro(List<Arbitro> arbitros)
    {
        //Colores para la consola
        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";

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

        //Validamos si la cedula ya esta en uso
        for (Arbitro arbitro : arbitros) {
            if (arbitro.cedula == cedula) {
                System.out.println(" ");
                System.out.println(RED + "[Esta cedula ya esta en uso]" + RESET);
                return;
            }
        }

        System.out.println("Ingrese la cantidad de partidos dirigidos:");
        int cantidadPD = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        System.out.println("Ingrese la cantidad de años trabajados:");
        int cantidadAT = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        //Agregar el arbitro a la lista
        arbitros.add(new Arbitro(nombre, apellido, cedula, cantidadPD,cantidadAT));
        System.out.println(" ");
        System.out.println(GREEN + "[Árbitro ingresado con exito]" + RESET);
        System.out.println(" ");
    }

    static void eliminarArbitro(List<Arbitro> arbitros)
    {
        //Colores para la consola
        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";

        Scanner scanner = new Scanner(System.in);
        boolean arbitroEncontrado = false;

        System.out.println("Ingrese la cedula del árbitro:");
        int cedula = scanner.nextInt();
        for(Arbitro arbitro : arbitros)
        {
            if (arbitro.cedula == cedula)
            {
                arbitros.remove(arbitro);
                System.out.println(" ");
                System.out.println(GREEN + "[Árbitro eliminado con éxito]" + RESET);
                System.out.println(" ");
                arbitroEncontrado = true;
                break;
            }

        }
        if(!arbitroEncontrado)
        {
            System.out.println(" ");
            System.out.println(RED + "[El árbitro no existe]" + RESET);
            System.out.println(" ");
        }
    }

    static void modificarArbitro(List<Arbitro> arbitros)
    {
        //Colores para la consola
        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";

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
                System.out.println(GREEN + "[Cantidad de Partidos Dirigidos modificado con éxito]" + RESET);
                break;
            }
            else
            {
                System.out.println(RED + "[Árbitro no encontrado]" + RESET);
            }
        }
    }

    static void mostrarArbitros(List<Arbitro> arbitros)
    {
        for (Arbitro arbitro:arbitros) {
            System.out.println(arbitro.mostrarInformacion());
        }
    }

    static void salarioArbitro()
    {
        //Colores para la consola
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String RESET = "\u001B[0m";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cedula del arbitro");
        int cedula = scanner.nextInt();
        scanner.nextLine();
        for(Arbitro arbitro:arbitros) {
            if (arbitro.getCedula() == cedula) {
                System.out.println(" ");
                System.out.println(GREEN + "[El salario de este arbitro es de $" + arbitro.prima() + "]"+  RESET);
            }
            else
            {
                System.out.println(RED + "[Este arbitro no existe]" + RESET);
            }
        }
    }

    //Este metodo contiene un switch con todas las opciones de los partidos (agregar, eliminar, modificar y mostrar)
    static void opcionesPartido()
    {
        //Colores para la consola
        String RESET = "\u001B[0m";
        String CYAN = "\u001B[36m";

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            String[] mensajesPartido = {
                    "+------[Opciones de partidos]------+",
                    "0. Salir",
                    "1. Agregar un partido",
                    "2. Eliminar un partido",
                    "3. Mostrar informacion",
                    "+--------------------------------- +"
            };

            for (String mensaje : mensajesPartido) {
                System.out.println(CYAN + mensaje + RESET);
            }

            int opcionPartido = scanner.nextInt();

            switch (opcionPartido) {
                case 0:
                    salir = true;
                    break;
                case 1:
                    agregarPartido(partidos);
                    break;
                case 2:
                    eliminarPartido(partidos);
                    break;
                case 3:
                    mostrarPartido(partidos);
                    break;
            }
        }

    }

    static void agregarPartido(List<Partido> partidos)
    {
        //Colores para la consola
        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el equipo local:");
        String local = scanner.nextLine();

        for(Equipo equipo:equipos){
            if(equipo.getNombre().equals(local))
            {
               break;
            }
            else
            {
                System.out.println(" ");
                System.out.println(RED + "[Este equipo no existe]" + RESET);
                return;
            }
        }

        System.out.println("Ingrese el equipo visitante:");
        String visitante = scanner.nextLine();

        /*for(Equipo equipoB:equipos){
            if(equipoB.getNombre().equals(visitante))
            {
              break;
            }
            else
            {
                System.out.println(" ");
                System.out.println(RED + "[Este equipo no existe]" + RESET);
                return;
            }
        }*/

        System.out.println("Ingrese la cedula del árbitro:");
        int arbitro = scanner.nextInt();
        scanner.nextLine();

        boolean arbitroEncontrado = false;

        for (Arbitro arbitroa : arbitros) {
            if (arbitroa.getCedula() == arbitro) {
                if (arbitroEncontrado) {
                    System.out.println(RED + "[Este árbitro ya fue asignado a este partido]" + RESET);
                    return;
                }

                arbitroEncontrado = true;
            }
        }

        if (!arbitroEncontrado) {
            System.out.println(RED + "[Este árbitro no existe]" + RESET);
            return;
        }

        System.out.println("Ingrese la fecha del partido(Dia-Mes-Año):");
        String fecha = scanner.next();
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaParseada = LocalDate.parse(fecha,formatoFecha);


        System.out.println("Ingrese la hora del partido(Hora:Minuto): ");
        String hora = scanner.next();
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime horaParseada =LocalTime.parse(hora,formatoHora);


        //Agregar el partido a la lista
        partidos.add(new Partido(visitante,local,arbitro,fechaParseada,horaParseada));
        System.out.println("");
        System.out.println(GREEN + "[Partido ingresado con exito]" + RESET);
    }

    static void eliminarPartido(List<Partido> partidos)
    {
        //Colores para la consola
        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";

        Scanner scanner = new Scanner(System.in);
        boolean partidoEncontrado = false;

        System.out.println("Ingrese la id del partido:");
        int id = scanner.nextInt();
        for(Partido partido : partidos)
        {
            if (partido.getId() == id)
            {
                partidos.remove(partido);
                System.out.println(" ");
                System.out.println(GREEN + "[Partido eliminado con éxito]" + RESET);
                partidoEncontrado = true;
                break;
            }

        }
        if(!partidoEncontrado)
        {
            System.out.println(" ");
            System.out.println(RED + "[El partido no existe]" + RESET);
        }
    }

    static void mostrarPartido(List<Partido> partidos)
    {
        for (Partido partido:partidos) {
            System.out.println(partido.mostrarInformacion());
        }
    }
}
