package aplication;

import Model.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Room> rooms = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Seleccione una opción:");
        System.out.println("1. Crear una habitación");
        System.out.println("2. Crear un paciente");
        System.out.println("3. Mostrar historial de pacientes por habitación");
        System.out.println("4. Generar XML");
        System.out.println("5. Salir");

    }
}

