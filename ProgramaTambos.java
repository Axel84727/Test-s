import java.util.Scanner;
public class ProgramaTambos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1- Manage Cities (Gestionar Ciudades)");
            System.out.println("2- Manage Pasteurization Centers (Gestionar Centros de Pasteurización)");
            System.out.println("3- Manage Owners (Gestionar Propietarios)");
            System.out.println("4- Manage Tambos (Gestionar Tambos)");
            System.out.println("5- Exit (Salir)");
            System.out.println("Enter an option (Ingrese una opción)");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Ciudad.main(null);
                    break;
                case 2:
                    Pasteurizacion.main(null);
                    break;
                case 3:
                    Propietario.main(null);
                    break;
                case 4:
                    Tambo.main(null);
                    break;
            }
        } while (opcion != 5);

    
    }
}