
package aplication;

import Model.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Room> rooms = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Crear una habitación");
            System.out.println("2. Crear un paciente");
            System.out.println("3. Mostrar historial de pacientes por habitación");
            System.out.println("4. Generar XML");
            System.out.println("5. Salir");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    createRoom(scanner);
                    break;
                case 2:
                    createPatient(scanner);
                    break;
                case 3:
                    showPatientsByRoom(scanner);
                    break;
                case 4:
                    generateXML();
                    break;
                case 5:
                    System.out.println("Salio del menu");
                    generateXML();
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }

        } while (option != 5);
    }

    private static void createRoom() {
        System.out.println("Ingresa un número de piso (1-30):");

        System.out.println("Ingrese solo números. ");

        System.out.println("El número de piso debe estar entre 1 y 30.");

        System.out.println("Ingrese el número de habitación:");

        System.out.println("solo puede ingresar números.");

        System.out.println("Ingrese el ID de la habitación:");

        System.out.println("solo puede ingresar números. ");

        System.out.println("Ingrese el número de camas de la habitación (1-5):");

        System.out.println("Ingrese solo números. ");

        System.out.println("El número de camas debe estar entre 1 y 5. ");

        System.out.println("La habitación ya existe en ese piso, ingrese una nueva");

        System.out.println("La habitación fue creada exitosamente.");
    }
    public static void createPatient() {

        System.out.println("No hay habitaciones creadas, por favor, cree una habitación antes de añadir un paciente.");

        System.out.println("Ingrese el número de habitación:");

        System.out.println("La habitación está llena. ¿Desea desactivar/reemplazar un paciente?");

        System.out.println("Pacientes activos en la habitación:");

        System.out.println("Ingrese la posición del paciente a reemplazar:");

        System.out.println("Ingrese solo números. Volviendo al menú principal.");

        System.out.println("Posición inválida. Volviendo al menú principal.");

        System.out.println("Volviendo al menú principal.");

        System.out.println("Ingrese el nombre del paciente:");

        System.out.println("Ingrese el apellido del paciente:");

        System.out.println("Ingrese el número de teléfono del paciente:");

        System.out.println("Paciente añadido exitosamente a la habitación " );

        System.out.println("Esta habitación no existe.");

    }
}