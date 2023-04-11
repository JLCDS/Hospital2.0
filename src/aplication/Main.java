package aplication;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Seleccione una opcion:");
            System.out.println("1. Crear una habitacion");
            System.out.println("2. Crear un paciente");
            System.out.println("3. Mostrar historial de pacientes por habitacion");
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
                    System.out.println("Opcion invalida");
                    break;
            }

        } while (option != 5);
    }

	}


