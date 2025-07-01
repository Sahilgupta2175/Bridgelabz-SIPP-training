interface Worker {
    void performDuties();
    void clockIn();
    void clockOut();
}

class Person {
    protected String name;
    protected String id;
    protected int age;
    protected String phoneNumber;

    public Person(String name, String id, int age, String phoneNumber) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public void displayPersonInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Age: " + age);
        System.out.println("Phone: " + phoneNumber);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

class Chef extends Person implements Worker {
    private String speciality;
    private int experienceYears;
    private String kitchenSection;

    public Chef(String name, String id, int age, String phoneNumber, String speciality, 
               int experienceYears, String kitchenSection) {
        super(name, id, age, phoneNumber);
        this.speciality = speciality;
        this.experienceYears = experienceYears;
        this.kitchenSection = kitchenSection;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is preparing " + speciality + " dishes in " + kitchenSection);
    }

    @Override
    public void clockIn() {
        System.out.println("Chef " + name + " clocked in for " + kitchenSection + " duty");
    }

    @Override
    public void clockOut() {
        System.out.println("Chef " + name + " clocked out after kitchen duty");
    }

    @Override
    public void displayPersonInfo() {
        super.displayPersonInfo();
        System.out.println("Role: Chef");
        System.out.println("Speciality: " + speciality);
        System.out.println("Experience: " + experienceYears + " years");
        System.out.println("Kitchen Section: " + kitchenSection);
    }

    public void cookDish(String dish) {
        System.out.println(name + " is cooking " + dish);
    }

    public void manageKitchen() {
        System.out.println(name + " is managing the " + kitchenSection + " section");
    }

    public String getSpeciality() {
        return speciality;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public String getKitchenSection() {
        return kitchenSection;
    }
}

class Waiter extends Person implements Worker {
    private int tablesAssigned;
    private double tipEarnings;
    private String workShift;

    public Waiter(String name, String id, int age, String phoneNumber, int tablesAssigned, 
                 double tipEarnings, String workShift) {
        super(name, id, age, phoneNumber);
        this.tablesAssigned = tablesAssigned;
        this.tipEarnings = tipEarnings;
        this.workShift = workShift;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is serving " + tablesAssigned + " tables during " + workShift + " shift");
    }

    @Override
    public void clockIn() {
        System.out.println("Waiter " + name + " clocked in for " + workShift + " shift");
    }

    @Override
    public void clockOut() {
        System.out.println("Waiter " + name + " clocked out with $" + tipEarnings + " in tips");
    }

    @Override
    public void displayPersonInfo() {
        super.displayPersonInfo();
        System.out.println("Role: Waiter");
        System.out.println("Tables Assigned: " + tablesAssigned);
        System.out.println("Tip Earnings: $" + tipEarnings);
        System.out.println("Work Shift: " + workShift);
    }

    public void takeOrder(String customerName) {
        System.out.println(name + " is taking order from " + customerName);
    }

    public void serveFood(int tableNumber) {
        System.out.println(name + " is serving food to table " + tableNumber);
    }

    public int getTablesAssigned() {
        return tablesAssigned;
    }

    public double getTipEarnings() {
        return tipEarnings;
    }

    public String getWorkShift() {
        return workShift;
    }
}

public class RestaurantManagementSystem {
    public static void main(String[] args) {
        System.out.println("=== Restaurant Management System ===\n");

        Chef chef1 = new Chef("Marco Antonio", "C001", 35, "555-0101", "Italian", 12, "Main Kitchen");
        Chef chef2 = new Chef("Sarah Kim", "C002", 28, "555-0102", "Desserts", 6, "Pastry Section");
        Waiter waiter1 = new Waiter("John Smith", "W001", 22, "555-0201", 8, 120.50, "Evening");
        Waiter waiter2 = new Waiter("Emily Davis", "W002", 25, "555-0202", 6, 95.75, "Morning");

        System.out.println("1. Chef Information:");
        chef1.displayPersonInfo();
        chef1.clockIn();
        chef1.performDuties();
        chef1.cookDish("Pasta Carbonara");
        chef1.manageKitchen();
        System.out.println();

        chef2.displayPersonInfo();
        chef2.clockIn();
        chef2.performDuties();
        chef2.cookDish("Tiramisu");
        System.out.println();

        System.out.println("2. Waiter Information:");
        waiter1.displayPersonInfo();
        waiter1.clockIn();
        waiter1.performDuties();
        waiter1.takeOrder("Customer A");
        waiter1.serveFood(5);
        System.out.println();

        waiter2.displayPersonInfo();
        waiter2.clockIn();
        waiter2.performDuties();
        waiter2.takeOrder("Customer B");
        System.out.println();

        System.out.println("3. Worker Interface Demonstration:");
        Worker[] workers = {chef1, chef2, waiter1, waiter2};
        for (Worker worker : workers) {
            worker.performDuties();
        }
        System.out.println();

        System.out.println("4. End of Shift:");
        for (Worker worker : workers) {
            worker.clockOut();
        }

        System.out.println("\n=== End of Restaurant Management Demo ===");
    }
}
