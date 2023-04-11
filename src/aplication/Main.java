package aplication;

public class Main {

	public static void main(String[] args) {
		
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


	}

}
