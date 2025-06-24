public class Q3_Person {
    private String name;
    private int age;
    private String address;

    public Q3_Person() {
        this.name = "Unknown";
        this.age = 0;
        this.address = "Unknown";
    }

    public Q3_Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Q3_Person(Q3_Person otherPerson) {
        this.name = otherPerson.name;
        this.age = otherPerson.age;
        this.address = otherPerson.address;
    }

    public void displayDetails() {
        System.out.println("Person Details:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
    }

    public static void main(String[] args) {
        Q3_Person person1 = new Q3_Person("John Smith", 30, "123 Main St");
        person1.displayDetails();

        System.out.println("\n");

        Q3_Person person2 = new Q3_Person(person1);
        person2.displayDetails();

        System.out.println("\nDemonstrating independent objects:");
        person2 = new Q3_Person(person1);
        person2.name = "Jane Doe";

        System.out.println("Original Person:");
        person1.displayDetails();
        System.out.println("\nCopied Person (after modification):");
        person2.displayDetails();
    }
}
