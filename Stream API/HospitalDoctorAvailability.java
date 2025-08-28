import java.util.*;
import java.util.stream.Collectors;

class Doctor {
    String name;
    String specialty;
    boolean availableOnWeekend;

    Doctor(String name, String specialty, boolean availableOnWeekend) {
        this.name = name;
        this.specialty = specialty;
        this.availableOnWeekend = availableOnWeekend;
    }

    public String toString() {
        return name + " (" + specialty + ", Weekend: " + availableOnWeekend + ")";
    }
}

public class HospitalDoctorAvailability {
    public static void main(String[] args) {
        List<Doctor> doctors = Arrays.asList(
                new Doctor("Dr. Smith", "Cardiology", true),
                new Doctor("Dr. Lee", "Neurology", false),
                new Doctor("Dr. Patel", "Orthopedics", true),
                new Doctor("Dr. Gupta", "Dermatology", true),
                new Doctor("Dr. Brown", "Pediatrics", false));
        List<Doctor> available = doctors.stream()
                .filter(d -> d.availableOnWeekend)
                .sorted(Comparator.comparing(d -> d.specialty))
                .collect(Collectors.toList());
        available.forEach(System.out::println);
    }
}
