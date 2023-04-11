package aplication;

public class Main {

	public static void main(String[] args) {
		
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

	}

}
