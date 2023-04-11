package aplication;

public class Main {

	public static void main(String[] args) {
		
		
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

	}

}
