abstract class Patient {
    protected String patientId;
    protected String name;
    protected int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public abstract double calculateBill();

    public String getPatientDetails() {
        return "Patient ID: " + patientId + ", Name: " + name + ", Age: " + age;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface MedicalRecord {
    void addRecord(String record);

    String[] viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private String[] medicalHistory;
    private String diagnosis;
    private int recordCount;

    public InPatient(String patientId, String name, int age) {
        super(patientId, name, age);
        this.medicalHistory = new String[10];
        this.recordCount = 0;
    }

    @Override
    public double calculateBill() {
        return 5000 + (age > 60 ? 1000 : 0);
    }

    @Override
    public void addRecord(String record) {
        if (recordCount < medicalHistory.length) {
            medicalHistory[recordCount] = record;
            recordCount++;
        }
    }

    @Override
    public String[] viewRecords() {
        String[] records = new String[recordCount];
        for (int i = 0; i < recordCount; i++) {
            records[i] = medicalHistory[i];
        }
        return records;
    }

    private void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    private String getDiagnosis() {
        return diagnosis;
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private String[] medicalHistory;
    private String diagnosis;
    private int recordCount;

    public OutPatient(String patientId, String name, int age) {
        super(patientId, name, age);
        this.medicalHistory = new String[10];
        this.recordCount = 0;
    }

    @Override
    public double calculateBill() {
        return 500 + (age > 60 ? 200 : 0);
    }

    @Override
    public void addRecord(String record) {
        if (recordCount < medicalHistory.length) {
            medicalHistory[recordCount] = record;
            recordCount++;
        }
    }

    @Override
    public String[] viewRecords() {
        String[] records = new String[recordCount];
        for (int i = 0; i < recordCount; i++) {
            records[i] = medicalHistory[i];
        }
        return records;
    }

    private void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    private String getDiagnosis() {
        return diagnosis;
    }
}

public class HospitalPatientManagement {
    public static void processPatients(Patient[] patients) {
        for (Patient patient : patients) {
            System.out.println(patient.getPatientDetails());
            System.out.println("Bill Amount: $" + patient.calculateBill());

            if (patient instanceof MedicalRecord) {
                MedicalRecord record = (MedicalRecord) patient;
                record.addRecord("Initial consultation completed");
                record.addRecord("Blood tests ordered");

                System.out.println("Medical Records:");
                String[] records = record.viewRecords();
                for (String rec : records) {
                    if (rec != null) {
                        System.out.println("- " + rec);
                    }
                }
            }
            System.out.println("------------------------");
        }
    }

    public static void main(String[] args) {
        Patient[] patients = {
                new InPatient("IP001", "Alice Johnson", 45),
                new OutPatient("OP001", "Bob Smith", 65),
                new InPatient("IP002", "Carol Brown", 70),
                new OutPatient("OP002", "David Wilson", 30)
        };

        processPatients(patients);
    }
}
