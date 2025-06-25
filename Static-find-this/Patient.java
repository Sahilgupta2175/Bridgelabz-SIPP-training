/**
 * Patient class for Hospital Management System
 * Demonstrates static variables, static methods, this keyword, final variables,
 * and instanceof
 */
public class Patient {
    // Static variable shared among all patients - represents the hospital name
    private static String hospitalName = "City General Hospital";

    // Static variable to track total number of patients admitted
    private static int totalPatientsAdmitted = 0;

    // Static variable to track currently admitted patients
    private static int currentlyAdmitted = 0;

    // Instance variables
    private String name;
    private int age;
    private String ailment;

    // Final variable - patient ID cannot be changed once assigned
    private final String patientID;

    private String doctorAssigned;
    private String room;
    private boolean isAdmitted;
    private String admissionDate;
    private double billAmount;

    /**
     * Constructor to create a new patient
     * Uses 'this' keyword to initialize instance variables when parameter names
     * match
     * 
     * @param name           Name of the patient
     * @param age            Age of the patient
     * @param ailment        Medical condition/ailment of the patient
     * @param patientID      Unique patient identifier (final - cannot be changed)
     * @param doctorAssigned Doctor assigned to the patient
     * @param room           Room number assigned to the patient
     * @param admissionDate  Date of admission
     */
    public Patient(String name, int age, String ailment, String patientID,
            String doctorAssigned, String room, String admissionDate) {
        // Using 'this' to distinguish between instance variables and parameters
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.doctorAssigned = doctorAssigned;
        this.room = room;
        this.admissionDate = admissionDate;

        // Final variable assignment - can only be done once during initialization
        this.patientID = patientID;

        // Initially, patient is admitted upon creation
        this.isAdmitted = true;
        this.billAmount = 0.0;

        // Increment static counters
        totalPatientsAdmitted++;
        currentlyAdmitted++;
    }

    /**
     * Static method to get the total number of patients admitted
     * Can be called without creating an instance of the Patient class
     * 
     * @return Total number of patients ever admitted
     */
    public static int getTotalPatients() {
        return totalPatientsAdmitted;
    }

    /**
     * Static method to display total patients count
     */
    public static void displayTotalPatients() {
        System.out.println("Total patients admitted to " + hospitalName + ": " + totalPatientsAdmitted);
        System.out.println("Currently admitted patients: " + currentlyAdmitted);
    }

    /**
     * Static method to get the hospital name
     * 
     * @return Current hospital name
     */
    public static String getHospitalName() {
        return hospitalName;
    }

    /**
     * Static method to change the hospital name
     * 
     * @param newHospitalName New name for the hospital
     */
    public static void setHospitalName(String newHospitalName) {
        hospitalName = newHospitalName;
        System.out.println("Hospital name updated to: " + hospitalName);
    }

    /**
     * Static method to get currently admitted patients count
     * 
     * @return Number of currently admitted patients
     */
    public static int getCurrentlyAdmitted() {
        return currentlyAdmitted;
    }

    /**
     * Static method to display hospital information
     */
    public static void displayHospitalInfo() {
        System.out.println("Hospital: " + hospitalName);
        System.out.println("Total Patients Ever Admitted: " + totalPatientsAdmitted);
        System.out.println("Currently Admitted: " + currentlyAdmitted);
    }

    /**
     * Method to add charges to patient's bill
     * 
     * @param description Description of the charge
     * @param amount      Amount to be added to the bill
     */
    public void addToBill(String description, double amount) {
        if (amount > 0) {
            this.billAmount += amount;
            System.out.println("Added to bill for " + this.name + ":");
            System.out.println("- " + description + ": $" + amount);
            System.out.println("Current total bill: $" + this.billAmount);
        } else {
            System.out.println("Invalid bill amount!");
        }
    }

    /**
     * Method to update patient's condition/ailment
     * 
     * @param newAilment Updated medical condition
     */
    public void updateCondition(String newAilment) {
        String previousAilment = this.ailment;
        this.ailment = newAilment;

        System.out.println("Medical condition updated for " + this.name);
        System.out.println("Previous: " + previousAilment);
        System.out.println("Current: " + this.ailment);
    }

    /**
     * Method to transfer patient to a different room
     * 
     * @param newRoom New room number
     */
    public void transferToRoom(String newRoom) {
        if (this.isAdmitted) {
            String previousRoom = this.room;
            this.room = newRoom;

            System.out.println("Patient " + this.name + " transferred:");
            System.out.println("From room: " + previousRoom + " To room: " + this.room);

            // Add transfer fee
            addToBill("Room transfer fee", 50.0);
        } else {
            System.out.println("Cannot transfer: Patient is not currently admitted!");
        }
    }

    /**
     * Method to discharge the patient
     * 
     * @return Final bill amount
     */
    public double dischargePatient() {
        if (this.isAdmitted) {
            this.isAdmitted = false;
            currentlyAdmitted--; // Decrease currently admitted count

            System.out.println("Patient " + this.name + " has been discharged.");
            System.out.println("Room " + this.room + " is now available.");
            System.out.println("Final bill amount: $" + this.billAmount);

            return this.billAmount;
        } else {
            System.out.println("Patient " + this.name + " is already discharged!");
            return 0.0;
        }
    }

    /**
     * Method to readmit the patient
     * 
     * @param newRoom         Room for readmission
     * @param newDoctor       Doctor for readmission
     * @param readmissionDate Date of readmission
     */
    public void readmitPatient(String newRoom, String newDoctor, String readmissionDate) {
        if (!this.isAdmitted) {
            this.isAdmitted = true;
            this.room = newRoom;
            this.doctorAssigned = newDoctor;
            this.admissionDate = readmissionDate;
            currentlyAdmitted++; // Increase currently admitted count

            System.out.println("Patient " + this.name + " has been readmitted.");
            System.out.println("New room: " + this.room);
            System.out.println("Assigned doctor: " + this.doctorAssigned);

            // Add readmission fee
            addToBill("Readmission fee", 100.0);
        } else {
            System.out.println("Patient " + this.name + " is already admitted!");
        }
    }

    /**
     * Method to calculate total days in hospital (simplified calculation)
     * 
     * @param currentDate Current date for calculation
     * @return Estimated days in hospital
     */
    public int calculateDaysInHospital(String currentDate) {
        // Simplified calculation - in real scenario, would parse dates properly
        // For demo purposes, returning a random number based on patient ID
        return Math.abs(this.patientID.hashCode() % 10) + 1;
    }

    /**
     * Method to display detailed patient information
     * This method is called only after instanceof verification
     */
    public void displayPatientDetails() {
        System.out.println("\n=== Patient Details ===");
        System.out.println("Hospital: " + hospitalName);
        System.out.println("Patient ID: " + this.patientID);
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Ailment: " + this.ailment);
        System.out.println("Assigned Doctor: " + this.doctorAssigned);
        System.out.println("Room: " + this.room);
        System.out.println("Admission Date: " + this.admissionDate);
        System.out.println("Admission Status: " + (this.isAdmitted ? "Admitted" : "Discharged"));
        System.out.println("Current Bill: $" + this.billAmount);
        System.out.println("=======================");
    }

    /**
     * Static method to safely display patient information using instanceof
     * Demonstrates type checking before casting and method invocation
     * 
     * @param obj Object to be verified and displayed
     */
    public static void displayPatientInfo(Object obj) {
        // Using instanceof to check if an object is an instance of the Patient class
        if (obj instanceof Patient) {
            System.out.println("Valid Patient object detected!");
            Patient patient = (Patient) obj; // Safe casting after instanceof check
            patient.displayPatientDetails();
        } else {
            System.out.println("Error: Object is not an instance of Patient class!");
            System.out.println("Cannot display patient details for: " + obj.getClass().getSimpleName());
        }
    }

    /**
     * Static method to safely perform patient operations using instanceof
     * 
     * @param obj       Object to be verified before performing operations
     * @param operation Operation to perform
     * @param parameter Additional parameter for operations
     * @return true if operation successful, false otherwise
     */
    public static boolean performPatientOperation(Object obj, String operation, String parameter) {
        if (obj instanceof Patient) {
            Patient patient = (Patient) obj;

            switch (operation.toLowerCase()) {
                case "discharge":
                    patient.dischargePatient();
                    return true;
                case "transfer":
                    if (parameter != null && !parameter.trim().isEmpty()) {
                        patient.transferToRoom(parameter);
                        return true;
                    } else {
                        System.out.println("Room number required for transfer!");
                        return false;
                    }
                case "update_condition":
                    if (parameter != null && !parameter.trim().isEmpty()) {
                        patient.updateCondition(parameter);
                        return true;
                    } else {
                        System.out.println("New condition required for update!");
                        return false;
                    }
                default:
                    System.out.println("Unknown operation: " + operation);
                    return false;
            }
        } else {
            System.out.println("Cannot perform patient operation: Object is not a Patient instance!");
            return false;
        }
    }

    /**
     * Method to check if patient requires emergency care
     * 
     * @return true if emergency care needed, false otherwise
     */
    public boolean requiresEmergencyCare() {
        String[] emergencyConditions = { "Heart Attack", "Stroke", "Severe Injury", "Respiratory Failure" };

        for (String condition : emergencyConditions) {
            if (this.ailment.toLowerCase().contains(condition.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Getter methods for accessing private fields
     */
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getAilment() {
        return this.ailment;
    }

    public String getPatientID() {
        return this.patientID; // Final variable - read-only access
    }

    public String getDoctorAssigned() {
        return this.doctorAssigned;
    }

    public String getRoom() {
        return this.room;
    }

    public boolean isAdmitted() {
        return this.isAdmitted;
    }

    public String getAdmissionDate() {
        return this.admissionDate;
    }

    public double getBillAmount() {
        return this.billAmount;
    }

    /**
     * Setter methods (excluding final variable 'patientID')
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Invalid age!");
        }
    }

    public void setDoctorAssigned(String doctorAssigned) {
        this.doctorAssigned = doctorAssigned;
    }

    /**
     * Main method to demonstrate the Patient class functionality
     */
    public static void main(String[] args) {
        System.out.println("=== Hospital Management System Demo ===\n");

        // Display initial hospital information
        Patient.displayHospitalInfo();

        // Create patient instances
        Patient patient1 = new Patient("John Smith", 45, "Pneumonia", "PAT001",
                "Dr. Johnson", "101", "2024-01-15");
        Patient patient2 = new Patient("Mary Wilson", 32, "Broken Leg", "PAT002",
                "Dr. Brown", "205", "2024-01-16");
        Patient patient3 = new Patient("Robert Davis", 67, "Heart Attack", "PAT003",
                "Dr. Lee", "ICU-1", "2024-01-17");
        Patient patient4 = new Patient("Lisa Anderson", 28, "Appendicitis", "PAT004",
                "Dr. Martinez", "302", "2024-01-18");
        Patient patient5 = new Patient("David Miller", 55, "Diabetes", "PAT005",
                "Dr. Garcia", "203", "2024-01-19");

        // Display updated patient statistics
        System.out.println("\nAfter patient admissions:");
        Patient.displayTotalPatients();

        // Demonstrate patient operations
        System.out.println("\n=== Patient Operations ===");

        // Add medical charges to bills
        patient1.addToBill("Room charges (5 days)", 500.0);
        patient1.addToBill("Medication", 150.0);
        patient1.addToBill("X-ray", 100.0);

        patient2.addToBill("Surgery", 2000.0);
        patient2.addToBill("Physical therapy", 300.0);

        patient3.addToBill("ICU charges", 1500.0);
        patient3.addToBill("Emergency treatment", 800.0);

        // Update medical conditions
        System.out.println("\n--- Medical Updates ---");
        patient1.updateCondition("Pneumonia - Improving");
        patient2.updateCondition("Broken Leg - Healing Well");

        // Transfer patients to different rooms
        System.out.println("\n--- Room Transfers ---");
        patient1.transferToRoom("102");
        patient5.transferToRoom("204");

        // Demonstrate instanceof usage with valid Patient objects
        System.out.println("\n=== Instanceof Demonstration ===");
        Patient.displayPatientInfo(patient1);
        Patient.displayPatientInfo(patient2);
        Patient.displayPatientInfo(patient3);
        Patient.displayPatientInfo(patient4);
        Patient.displayPatientInfo(patient5);

        // Demonstrate instanceof with invalid objects
        String invalidObject1 = "Not a Patient";
        Double invalidObject2 = 98.6; // Temperature reading
        Patient.displayPatientInfo(invalidObject1);
        Patient.displayPatientInfo(invalidObject2);

        // Demonstrate instanceof in patient operations
        System.out.println("\n=== Instanceof in Patient Operations ===");
        Patient.performPatientOperation(patient1, "update_condition", "Pneumonia - Fully Recovered");
        Patient.performPatientOperation(patient2, "transfer", "201");
        Patient.performPatientOperation("Invalid Object", "discharge", null);

        // Discharge some patients
        System.out.println("\n=== Patient Discharges ===");
        patient1.dischargePatient();
        patient4.dischargePatient();

        // Show updated statistics after discharges
        System.out.println("\nAfter discharges:");
        Patient.displayTotalPatients();

        // Readmit a patient
        System.out.println("\n=== Patient Readmission ===");
        patient1.readmitPatient("105", "Dr. Thompson", "2024-01-25");

        // Demonstrate hospital name change
        System.out.println("\n=== Hospital Name Change Demo ===");
        Patient.setHospitalName("Metropolitan Medical Center");
        Patient.displayHospitalInfo();

        // Display a patient to show updated hospital name
        Patient.displayPatientInfo(patient1);

        // Final variable demonstration
        System.out.println("\n=== Final Variable Demo ===");
        System.out.println("Patient ID (final variable): " + patient1.getPatientID());
        // patient1.patientID = "NEW_PAT001"; // Uncommenting this would cause
        // compilation error

        // Emergency care assessment
        System.out.println("\n=== Emergency Care Assessment ===");
        Patient[] allPatients = { patient1, patient2, patient3, patient4, patient5 };

        for (Patient patient : allPatients) {
            String emergencyStatus = patient.requiresEmergencyCare() ? "EMERGENCY" : "REGULAR";
            System.out.println(patient.getName() + " (" + patient.getAilment() + "): " + emergencyStatus);
        }

        // Doctor-wise patient distribution
        System.out.println("\n=== Doctor-wise Patient Distribution ===");
        String[] doctors = { "Dr. Johnson", "Dr. Brown", "Dr. Lee", "Dr. Martinez", "Dr. Garcia", "Dr. Thompson" };

        for (String doctor : doctors) {
            System.out.print(doctor + ": ");
            int count = 0;
            for (Patient patient : allPatients) {
                if (patient.getDoctorAssigned().equals(doctor)) {
                    System.out.print(patient.getName() + " ");
                    count++;
                }
            }
            System.out.println("(Total: " + count + ")");
        }

        // Calculate total hospital revenue
        System.out.println("\n=== Hospital Revenue Report ===");
        double totalRevenue = 0;
        for (Patient patient : allPatients) {
            totalRevenue += patient.getBillAmount();
        }
        System.out.println("Total hospital revenue: $" + totalRevenue);

        // Age group analysis
        System.out.println("\n=== Age Group Analysis ===");
        int children = 0, adults = 0, seniors = 0;

        for (Patient patient : allPatients) {
            int age = patient.getAge();
            if (age < 18) {
                children++;
            } else if (age < 65) {
                adults++;
            } else {
                seniors++;
            }
        }

        System.out.println("Children (< 18): " + children);
        System.out.println("Adults (18-64): " + adults);
        System.out.println("Seniors (65+): " + seniors);

        // Final statistics
        System.out.println("\n=== Final Hospital Statistics ===");
        System.out.println("Hospital: " + Patient.getHospitalName());
        Patient.displayTotalPatients();
        System.out.println("Total revenue generated: $" + totalRevenue);
        System.out.println("Average bill per patient: $" + String.format("%.2f", totalRevenue / allPatients.length));
    }
}
