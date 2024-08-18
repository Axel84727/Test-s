#include <iostream>
#include <stdexcept> 
#include <limits>    

using namespace std;

double sumar(double a, double b) {
    return a + b;
}

double restar(double a, double b) {
    return a - b;
}

double multiplicar(double a, double b) {
    return a * b;
}

double dividir(double a, double b) {
    if (b == 0) {
        throw runtime_error("Error: No se puede dividir entre 0");
    }
    return a / b;
}

int main() {
    double a, b;
    int opcion = 0;

    while (opcion != 5) {
        cout << "1. Sumar" << endl;
        cout << "2. Restar" << endl;
        cout << "3. Multiplicar" << endl;
        cout << "4. Dividir" << endl;
        cout << "5. Salir" << endl;
        cout << "Ingresa una opción (1-5):";
        cin >> opcion;

        if (cin.fail()) {
            cin.clear(); // Limpiar el estado de error de cin
            cin.ignore(numeric_limits<streamsize>::max(), '\n'); // Ignorar entrada incorrecta
            cout << "Entrada inválida. Inténtalo de nuevo." << endl;
            continue;
        }

        if (opcion == 5) {
            cout << "Saliendo..." << endl;
            break;
        }

        if (opcion < 1 || opcion > 5) {
            cout << "Opción no válida. Inténtalo de nuevo." << endl;
            continue;
        }

        cout << "Ingresa el primer número: ";
        cin >> a;

        cout << "Ingresa el segundo número: ";
        cin >> b;

        try {
            switch (opcion) {
                case 1:
                    cout << "La suma es: " << sumar(a, b) << endl;
                    break;
                case 2:
                    cout << "La resta es: " << restar(a, b) << endl;
                    break;
                case 3:
                    cout << "La multiplicación es: " << multiplicar(a, b) << endl;
                    break;
                case 4:
                    cout << "La división es: " << dividir(a, b) << endl;
                    break;
            }
        } catch (const runtime_error& e) {
            cout << e.what() << endl;
        }
    }

    return 0;
}
