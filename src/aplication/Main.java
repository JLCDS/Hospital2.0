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


        System.out.println("Seleccione una opción:");
        System.out.println("1. Crear una habitación");
        System.out.println("2. Crear un paciente");
        System.out.println("3. Mostrar historial de pacientes por habitación");
        System.out.println("4. Generar XML");
        System.out.println("5. Salir");


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
}

