import java.util.*;

class Patient {
    private String id;

    public Patient(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void printId() {
        System.out.println(id);
    }
}

public class PatientIdPrinting {
    public static void main(String[] args) {
        List<Patient> patients = Arrays.asList(
                new Patient("P001"),
                new Patient("P002"),
                new Patient("P003"));
        patients.forEach(Patient::printId);
    }
}
