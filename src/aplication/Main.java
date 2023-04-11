package aplication;

import Model.Patient;
import Model.Room;
import Model.Status;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
    
    private static void createRoom(Scanner scanner) {
    	System.out.println("Ingresa un número de piso (1-30):");
        int floor;
        try {
            floor = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Ingrese solo números. ");
            scanner.next(); 
            return;
        }
        
        if (floor < 1 || floor > 30) {
            System.out.println("El número de piso debe estar entre 1 y 30.");
            return;
        }

        System.out.println("Ingrese el número de habitación:");
        int number;
        try {
            number = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("solo puede ingresar números.");
            scanner.next(); 
            return;
        }

        System.out.println("Ingrese el ID de la habitación:");
        int id;
        try {
            id = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("solo puede ingresar números. ");
            scanner.next(); 
            return;
        }

        System.out.println("Ingrese el número de camas de la habitación (1-5):");
        int beds;
        try {
            beds = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Ingrese solo números. ");
            scanner.next(); 
            return;
        }
        
        if (beds < 1 || beds > 5) {
            System.out.println("El número de camas debe estar entre 1 y 5. ");
            return;
        }

        boolean roomExists = rooms.stream().anyMatch(room -> room.getNumber() == number && room.getFloor() == floor);
        if (roomExists) {
            System.out.println("La habitación ya existe en ese piso, ingrese una nueva");
            return;
        }

        Room room = new Room(floor, number, id, beds);
        rooms.add(room);
        System.out.println("La habitación fue creada exitosamente.");
    }


    public static void createPatient(Scanner scanner) {
        if (rooms.isEmpty()) {
            System.out.println("No hay habitaciones creadas, por favor, cree una habitación antes de añadir un paciente.");
            return;
        }
        
         
        System.out.println("Ingrese el número de habitación:");
        
        int roomNumber = scanner.nextInt();
        scanner.nextLine();
        
        boolean roomFound = false;
        for (Room room : rooms) {
            if (room.getNumber() == roomNumber) {
                roomFound = true;
                if (room.getPatients().size() >= room.getBeds()) {
                    System.out.println("La habitación está llena. ¿Desea desactivar/reemplazar un paciente? (si/no)");
                    String answer = scanner.nextLine().toLowerCase();
                    if (answer.equals("si")) {
                        System.out.println("Pacientes activos en la habitación:");
                        List<Patient> patients = room.getPatients();
                        for (int i = 0; i < patients.size(); i++) {
                            if (patients.get(i).getStatus() == Status.ACTIVE) {
                                System.out.println((i + 1) + ". " + patients.get(i).getName());
                            }
                        }
                        System.out.println("Ingrese la posición del paciente a reemplazar:");
                        int position;
                        try {
                            position = scanner.nextInt();
                            scanner.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println("Ingrese solo números. Volviendo al menú principal.");
                            return;
                        }
                        if (position < 1 || position > patients.size()) {
                            System.out.println("Posición inválida. Volviendo al menú principal.");
                            return;
                        }
                        Patient patientToReplace = patients.get(position - 1);
                        patientToReplace.setStatus(Status.INACTIVE);
                    } else {
                        System.out.println("Volviendo al menú principal.");
                        return;
                    }
                }
                System.out.println("Ingrese el nombre del paciente:");
                String name = scanner.nextLine();

                System.out.println("Ingrese el apellido del paciente:");
                String lastName = scanner.nextLine();

                System.out.println("Ingrese el número de teléfono del paciente:");
                String phoneNumber = scanner.nextLine();

                Patient patient = new Patient(name, lastName, phoneNumber, Status.ACTIVE);
                room.addPatient(patient);
                System.out.println("Paciente añadido exitosamente a la habitación " + roomNumber + ".");
                break;
            }
        }
        if (!roomFound) {
            System.out.println("Esta habitación no existe.");
        }
    }



    private static void generateXML() {
        XStream xstream = new XStream(new StaxDriver());
        xstream.alias("rooms", List.class);
        xstream.alias("room", Room.class);
        xstream.alias("patient", Patient.class);
        String xml = xstream.toXML(rooms);
        try {
            FileWriter writer = new FileWriter("src/resources/rooms.xml");
            writer.write(xml);
            writer.close();
            System.out.println("Archivo XML generado exitosamente en la ruta: src/resources/rooms.xml");
        } catch (IOException e) {
            System.out.println("Error al generar el archivo XML: " + e.getMessage());
        }
    }


    private static void showPatientsByRoom(Scanner scanner) {
        System.out.println("Ingrese el número de habitación:");
        int roomNumber = scanner.nextInt();
        scanner.nextLine();
        boolean roomFound = false;
        for (Room room : rooms) {
            if (room.getNumber() == roomNumber) {
                roomFound = true;
                List<Patient> patients = room.getPatients();
                System.out.printf("Historial de pacientes de la habitación %d:\n", roomNumber);
                for (Patient patient : patients) {
                    System.out.printf("%s %s - Teléfono: %s - Estado: %s\n",
                            patient.getName(), patient.getLastName(), patient.getPhoneNumber(), patient.getStatus());
                }
                break;
            }
        }
        if (!roomFound) {
            System.out.println("La habitación no existe.");
        }
}
}

