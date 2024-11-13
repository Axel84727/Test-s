import java.util.Scanner;

public class Ciudad {

    static String ciudad1, ciudad2, ciudad3, ciudad4;
    static Scanner tec = new Scanner(System.in);
    static String eliminar;
    int tamanio = 0;
    String ciudad[] = new String[3];
    static Ciudad c = new Ciudad();

    public static void main(String[] args) {
        c.menu();
    }

    public void menu() {
        int opcion;

        do {
            System.out.println("1- Register Cities(Registrar Ciudad)");
            System.out.println("2- listed Cities(Listar Ciudades)");
            System.out.println("3- Search Cities by Department(Buscar Ciudades por Departamento)");
            System.out.println("4- Exit(Salir)");
            System.out.println("Enter an option(Ingrese una opcion)");

            opcion = tec.nextInt();

            switch (opcion) {
                case 1:
                    c.registrarCiudad();
                    break;
                case 2:
                    c.listarCiudad();
                    break;
                case 3:
                    c.obtenerCiudadPorDepartamento();
                    break;
            }
        } while (opcion != 4);
    }

    public void listarCiudad() {
        int empieza = 1;

        System.out.println("");
        System.out.println("listed cities(Ciudades Listadas)");
        System.out.println(" " + "City" + " " + "CordX" + " " + "CordY");
        System.out.println(" " + "Ciudad" + " " + "CordX" + " " + "CordY");
        System.out.println(" " + "Department" + " " + "City" + " " + "CordX" + " " + "CordY");

        for (int casilla = 0; casilla < 3; casilla++) {
            System.out.println(empieza + "- " + ciudad[casilla]);
            empieza++;
        }

        System.out.println("");
        System.out.println("1- Return to menu(Volver al menu)");
        System.out.println("2- Delete City(Eliminar ciudad)");
        System.out.println("Enter an option(Ingrese una opcion)");

        int opcion = tec.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("");
                break;
            case 2:
                System.out.println("");
                System.out.println("Enter the name of the city you want to delete(Ingrese el nombre de la ciudad que desea eliminar)");
                eliminar = tec.next();

                if (eliminar.equals(ciudad2)) {
                    ciudad2 = null;
                    ciudad[0] = null;
                    System.out.println("City successfully eliminated(Ciudad eliminada exitosamente)");
                    System.out.println("");
                } else if (eliminar.equals(ciudad3)) {
                    ciudad3 = null;
                    ciudad[1] = null;
                    System.out.println("City successfully eliminated(Ciudad eliminada exitosamente)");
                    System.out.println("");
                } else if (eliminar.equals(ciudad4)) {
                    ciudad4 = null;
                    ciudad[2] = null;
                    System.out.println("City successfully eliminated(Ciudad eliminada exitosamente)");
                    System.out.println("");
                } else {
                    System.out.println("City not found(No se ha encontrado la ciudad)");
                }
                break;
        }

        c.menu();
    }

    public void obtenerCiudadPorDepartamento() {
        System.out.println("Enter the department to search for cities(Ingrese el departamento para buscar ciudades)");
        String departamento = tec.next();
        boolean found = false;

        for (int i = 0; i < ciudad.length; i++) {
            if (ciudad[i] != null) {
                String[] parts = ciudad[i].split(" ");
                if (parts[0].equals(departamento)) {
                    System.out.println("City found: " + ciudad[i]);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No cities found in the specified department(No se encontraron ciudades en el departamento especificado)");
        }
    }

    public void registrarCiudad() {
        if (ciudad[0] != null && ciudad[1] != null && ciudad[2] != null) {
            System.out.println("You cannot add more cities(No se puede añadir mas ciudades)");
            c.menu();
        }

        System.out.println("");
        System.out.println("Enter City(Ingrese Ciudad)");
        String ciudadName = tec.next();

        System.out.println("Enter Department(Ingrese Departamento)");
        String departamento = tec.next();

        System.out.println("Enter Cordinate x(Ingrese cordenada x)");
        double cordenadax = tec.nextDouble();

        System.out.println("Enter Cordinate y(Ingrese cordenada y)");
        double cordenaday = tec.nextDouble();

        for (int i = 0; i < ciudad.length; i++) {
            if (ciudad[i] == null) {
                ciudad[i] = departamento + " " + ciudadName + " (" + cordenadax + ", " + cordenaday + ")";
                break;
            }
        }
    }
}
