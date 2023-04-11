package Model;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private int floor;
    private int number;
    private int id;
    private int beds;
    private List<Patient> patients;

    public Room(int floor, int number, int id, int beds) {
        this.floor = floor;
        this.number = number;
        this.id = id;
        this.beds = beds;
        this.patients = new ArrayList<>();
    }

    public int getFloor() {
        return floor;
    }

    public int getNumber() {
        return number;
    }

    public int getId() {
        return id;
    }

    public int getBeds() {
        return beds;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }
}

