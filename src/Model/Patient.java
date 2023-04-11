package Model;
public class Patient {
    private String name;
    private String lastName;
    private String phoneNumber;
    private Status status;

    public Patient(String name, String lastName, String phoneNumber, Status status) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }
}
