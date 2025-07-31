package queue;

import java.util.*;

class Patient {
    private String name;
    private int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    public String getName() {
        return name;
    }

    public int getSeverity() {
        return severity;
    }

    @Override
    public String toString() {
        return String.format("Patient{name='%s', severity=%d}", name, severity);
    }
}

public class HospitalTriageSystem {
    private PriorityQueue<Patient> triageQueue;

    public HospitalTriageSystem() {
        triageQueue = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.getSeverity(), p1.getSeverity()));
    }

    public void addPatient(Patient patient) {
        triageQueue.offer(patient);
    }

    public Patient treatNextPatient() {
        return triageQueue.poll();
    }

    public boolean hasPatients() {
        return !triageQueue.isEmpty();
    }

    public static void main(String[] args) {
        HospitalTriageSystem triage = new HospitalTriageSystem();

        triage.addPatient(new Patient("John", 3));
        triage.addPatient(new Patient("Alice", 5));
        triage.addPatient(new Patient("Bob", 2));
        triage.addPatient(new Patient("Carol", 4));

        System.out.println("Treatment order:");
        while (triage.hasPatients()) {
            Patient patient = triage.treatNextPatient();
            System.out.println("Treating: " + patient);
        }
    }
}
