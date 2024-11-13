import java.util.Scanner;

public class Pasteurizacion {

    Scanner tec = new Scanner(System.in);
    static Pasteurizacion p = new Pasteurizacion();
    String center1, center2, center3;
    String pasteurizacion1[] = new String[3];

    public static void main(String[] args) {
        p.menu();
    }

    public void menu() {
        int opcion;

        do {
            System.out.println("1- Register pasteurization center(Registrar centro de pasteurizacion)");
            System.out.println("2- listed pasteurization center(Listar centros de pasteurizacion)");
            System.out.println("3- List tambos by city(Listar tambos por ciudad)");
            System.out.println("4- Exit(Salir)");
            System.out.println("Enter an option(Ingrese una opcion)");
            opcion = tec.nextInt();

            switch (opcion) {
                case 1:
                    p.registrarPasteurizacion();
                    break;

                case 2:
                    p.listarPasteurizacion();
                    break;

                case 3:
                    System.out.println("Enter the city name (Ingrese el nombre de la ciudad):");
                    String ciudad = tec.next();
                    p.listarTambosPorCiudad(ciudad);
                    break;
            }
        } while (opcion != 4);
    }

    public void registrarPasteurizacion() {
        if (pasteurizacion1[0] != null && pasteurizacion1[1] != null && pasteurizacion1[2] != null) {
            System.out.println("You cannot add more centers(No se puede añadir mas centros)");
        }

        System.out.println("Enter pasteurization center name (Ingrese el nombre del centro de pasteurización):");
        String centerName = tec.next();

        if (center1 == null) {
            center1 = centerName;
        } else if (center2 == null) {
            center2 = centerName;
        } else if (center3 == null) {
            center3 = centerName;
        }

        System.out.println("Enter center owner's name (Ingrese el nombre del propietario del centro):");
        String ownerName = tec.next();

        System.out.println("Enter center city (Ingrese la ciudad del centro):");
        String centerCity = tec.next();

        System.out.println("Enter center capacity (Ingrese la capacidad del centro):");
        double capacity = tec.nextDouble();

        if (pasteurizacion1[0] == null) {
            pasteurizacion1[0] = ownerName + " " + center1 + " " + capacity + " " + centerCity;
        } else if (pasteurizacion1[1] == null) {
            pasteurizacion1[1] = ownerName + " " + center2 + " " + capacity + " " + centerCity;
        } else if (pasteurizacion1[2] == null) {
            pasteurizacion1[2] = ownerName + " " + center3 + " " + capacity + " " + centerCity;
        }

        p.menu();
    }

    public void listarPasteurizacion() {
        int empieza = 1;

        System.out.println("Pasteurization Centers:");
        System.out.println(" " + "NameOwner" + " " + "Centername" + " " + " " + "City" + " " + "Capacity");

        for (int casilla = 0; casilla < 3; casilla++) {
            System.out.println(empieza + "- " + pasteurizacion1[casilla]);
            empieza++;
        }

        System.out.println("");
        System.out.println("1- Return to menu(Volver al menu)");
        System.out.println("2- Delete center(Eliminar centro)");
        System.out.println("Enter an option(Ingrese una opcion)");

        int opcion = tec.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("");
                break;

            case 2:
                System.out.println("");
                System.out.println("Enter the name of the center you want to delete(Ingrese el nombre del centro que desea eliminar)");
                String eliminar = tec.next();

                if (eliminar.equals(center1)) {
                    center1 = null;
                    pasteurizacion1[0] = null;
                    System.out.println("Center successfully eliminated(Ciudad eliminada exitosamente)");
                    System.out.println("");
                } else if (eliminar.equals(center2)) {
                    center2 = null;
                    pasteurizacion1[1] = null;
                    System.out.println("Center successfully eliminated(Ciudad eliminada exitosamente)");
                    System.out.println("");
                } else if (eliminar.equals(center3)) {
                    center3 = null;
                    pasteurizacion1[2] = null;
                    System.out.println("Center successfully eliminated(Ciudad eliminada exitosamente)");
                    System.out.println("");
                } else {
                    System.out.println("Center not found(No se ha encontrado el centro)");
                }
                break;
        }

        p.menu();
    }

    public void listarTambosPorCiudad(String ciudad) {
        System.out.println("Tambos en la ciudad de " + ciudad + ":");
        boolean found = false;

        if (pasteurizacion1[0] != null && pasteurizacion1[0].contains(ciudad)) {
            System.out.println(pasteurizacion1[0]);
            found = true;
        }
        if (pasteurizacion1[1] != null && pasteurizacion1[1].contains(ciudad)) {
            System.out.println(pasteurizacion1[1]);
            found = true;
        }
        if (pasteurizacion1[2] != null && pasteurizacion1[2].contains(ciudad)) {
            System.out.println(pasteurizacion1[2]);
            found = true;
        }

        if (!found) {
            System.out.println("No se encontraron tambos en la ciudad especificada.");
        }
    }
}