import java.util.Scanner;

public class Propietario {

    String name, lastName;
    Scanner tec = new Scanner(System.in);

    String[] propietario = new String[3];

    static Propietario b1 = new Propietario();

    String id, id1, id2, id3;

    public static void main(String[] args) {
        b1.menu();
    }

    public void menu() {

        int opcion;

        do {

            System.out.println("1- Register Owner's(Registrar Propietarios)");
            System.out.println("2- listed Owner's(Listar Propietarios)");
            System.out.println("3- Exit(Salir)");

            System.out.println("Enter an option(Ingrese una opcion)");

            opcion = tec.nextInt();

            switch (opcion) {

                case 1:
                    b1.registrarPropietario();
                    break;

                case 2:
                    b1.listarPropietario();
                    break;
            }
        } while (opcion != 3);

    }

    public void registrarPropietario() {

        if (propietario[0] != null && propietario[1] != null && propietario[2] != null) {
            System.out.println("You cannot add more owner's(No se puede añadir mas propietarios)");
            b1.menu();
        }

        System.out.println("Enter owner's first name (Ingrese el primer nombre del propietario):");
        name = tec.next();

        System.out.println("Enter owner's last name (Ingrese el apellido del propietario):");
        lastName = tec.next();

        System.out.println("Enter ID (Cedula or Rut) (Ingrese el ID (Cedula o Rut)):");
        id = tec.next();

        if (id1 == null) {
            id1 = id;
        } else if (id2 == null) {
            id2 = id;
        } else if (id3 == null) {
            id3 = id;
        }

        if (propietario[0] == null) {
            propietario[0] = (name + " " + lastName + " " + id + " ");
        } else if (propietario[1] == null) {
            propietario[1] = (name + " " + lastName + " " + id + " ");
        } else if (propietario[2] == null) {
            propietario[2] = (name + " " + lastName + " " + id + " ");
        }

        b1.menu();
    }

    public void listarPropietario() {

        int empieza = 1;

        for (int casilla = 0; casilla < 3; casilla++) {
            System.out.println(empieza + "- " + propietario[casilla]);
            empieza++;
        }

        System.out.println("");

        System.out.println("1- Return to menu(Volver al menu)");
        System.out.println("2- Delete Owner(Eliminar Propietario)");
        System.out.println("Enter an option(Ingrese una opcion)");
        int opcion = tec.nextInt();

        switch (opcion) {

            case 1:
                System.out.println("");
                break;

            case 2:
                System.out.println("");
                System.out.println("Enter the ID or RUT of the owner what do you want to delete(Ingresar la cédula o el RUT del propietario que desea eliminar)");
                String eliminar = tec.next();

                if (eliminar.equals(id1)) {
                    id1 = null;
                    propietario[0] = null;
                    System.out.println("Owner successfully eliminated(Propietario eliminada exitosamente)");
                    System.out.println("");

                } else if (eliminar.equals(id2)) {
                    id2 = null;
                    propietario[1] = null;
                    System.out.println("Owner successfully eliminated(Propietario eliminada exitosamente)");
                    System.out.println("");

                } else if (eliminar.equals(id3)) {
                    id3 = null;
                    propietario[2] = null;
                    System.out.println("Owner successfully eliminated(Propietario eliminada exitosamente)");
                    System.out.println("");

                } else {
                    System.out.println("Owner not found(No se ha encontrado al propietario)");
                }
                break;
        }

        b1.menu();

    }

    public void obtenerPropietarioPorId(String id) {
        boolean found = false;

        if (id1 != null && id1.equals(id)) {
            System.out.println("Propietario: " + propietario[0]);
            found = true;
        }
        if (id2 != null && id2.equals(id)) {
            System.out.println("Propietario: " + propietario[1]);
            found = true;
        }
        if (id3 != null && id3.equals(id)) {
            System.out.println("Propietario: " + propietario[2]);
            found = true;
        }

        if (!found) {
            System.out.println("No se encontró un propietario con el ID especificado.");
        }
    }
}