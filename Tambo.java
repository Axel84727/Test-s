import java.util.Scanner;

public class Tambo {
    static Tambo t = new Tambo();
    int opcion;
    static String tambos1, tambos2, tambos3;
    String tambo[] = new String[3];
    Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        t.menu();
    }

    public void menu() {
        do {
            System.out.println("1- Register Tambos(Registrar Tambos)");
            System.out.println("2- listed Tambos(Listar Tambos)");
            System.out.println("3- Exit(Salir)");
            System.out.println("Enter an option(Ingrese una opcion)");

            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    t.registrarTambo();
                    break;
                case 2:
                    t.listarTambo();
                    break;
            }
        } while (opcion != 3);
    }

    public void listarTambo() {
        int contador = 1;
        System.out.println("Registered tambos(Tambos Registrados)");

        for (int casilla = 0; casilla < 3; casilla++) {
            System.out.println(contador + "- " + tambo[casilla]);
            contador++;
        }
        System.out.println("");

        System.out.println("1- Return to menu(Volver al menu)");
        System.out.println("2- Delete Tambo(Tambo)");
        System.out.println("Enter an option(Ingrese una opcion)");
        int opcion2 = teclado.nextInt();

        switch (opcion2) {
            case 1:
                t.menu();
                break;
            case 2:
                System.out.println("");
                System.out.println("Enter the name of the city you want to delete(Ingrese el nombre de la ciudad que desea eliminar)");
                String eliminar = teclado.next();
                if (eliminar.equals(tambos1)) {
                    tambos1 = null;
                    tambo[0] = null;
                    System.out.println("Tambo successfully eliminated(Tambo eliminado exitosamente)");
                    System.out.println("");
                } else if (eliminar.equals(tambos2)) {
                    tambos2 = null;
                    tambo[1] = null;
                    System.out.println("Tambo successfully eliminated(Tambo eliminado exitosamente)");
                    System.out.println("");
                } else if (eliminar.equals(tambos3)) {
                    tambos3 = null;
                    tambo[2] = null;
                    System.out.println("Tambo successfully eliminated(Tambo eliminado exitosamente)");
                    System.out.println("");
                } else {
                    System.out.println("Tambo not found(No se ha encontrado el Tambo)");
                }
                break;
        }
        t.menu();
    }

    public void registrarTambo() {
        double cordx, cordy;
        String tambos;
        String espacialidad;
        if (tambo[0] != null && tambo[1] != null && tambo[2] != null) {
            System.out.println("You cannot add more tambos(No se puede añadir mas tambos)");
            t.menu();
        }
        System.out.print("Enter x coordinates of your tambo(Ingrese cordenadas x de su tambo)");
        cordx = teclado.nextDouble();
        System.out.print("Enter y coordinates of your tambo(Ingrese cordenadas y de su tambo)");
        cordy = teclado.nextDouble();
        System.out.println("Enter name the tambo(Ingrese nombre del tambo)");
        tambos = teclado.next();
        if (tambos1 == null) {
            tambos1 = tambos;
        } else if (tambos2 == null) {
            tambos2 = tambos;
        } else if (tambos3 == null) {
            tambos3 = tambos;
        }
        System.out.println("Enter the especiality the tambo(Ingrese la especidalidad del tambo)");
        espacialidad = teclado.next();
        if (tambo[0] == null) {
            tambo[0] = tambos1 + " " + espacialidad + " " + cordx + " " + cordy;
        } else if (tambo[1] == null) {
            tambo[1] = tambos2 + " " + espacialidad + " " + cordx + " " + cordy;
        } else if (tambo[2] == null) {
            tambo[2] = tambos3 + " " + espacialidad + " " + cordx + " " + cordy;
        }
        t.menu();
    }
}
