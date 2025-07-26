import java.util.*;
import java.io.*;

class Contact implements Serializable {
    private String name;
    private String phone;
    private String email;
    private String address;

    public Contact(String name, String phone, String email, String address) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phone + ", Email: " + email + ", Address: " + address;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Contact contact = (Contact) obj;
        return Objects.equals(name, contact.name) && Objects.equals(phone, contact.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone);
    }
}

class AddressBookManager<T extends Contact> {
    private HashMap<String, T> contacts;
    private final String fileName;

    public AddressBookManager(String fileName) {
        this.contacts = new HashMap<>();
        this.fileName = fileName;
        loadFromFile();
    }

    public void addContact(T contact) {
        contacts.put(contact.getName().toLowerCase(), contact);
        System.out.println("Contact added successfully: " + contact.getName());
        saveToFile();
    }

    public boolean removeContact(String name) {
        T removed = contacts.remove(name.toLowerCase());
        if (removed != null) {
            System.out.println("Contact removed: " + removed.getName());
            saveToFile();
            return true;
        }
        System.out.println("Contact not found: " + name);
        return false;
    }

    public T searchByName(String name) {
        return contacts.get(name.toLowerCase());
    }

    public List<T> searchByPhone(String phone) {
        List<T> results = new ArrayList<>();
        for (T contact : contacts.values()) {
            if (contact.getPhone().contains(phone)) {
                results.add(contact);
            }
        }
        return results;
    }

    public void listAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        System.out.println("All Contacts:");
        for (T contact : contacts.values()) {
            System.out.println(contact);
        }
    }

    public void listContactsSortedByName() {
        List<T> contactList = new ArrayList<>(contacts.values());
        contactList.sort(Comparator.comparing(Contact::getName));

        System.out.println("Contacts sorted by name:");
        for (T contact : contactList) {
            System.out.println(contact);
        }
    }

    public void listContactsSortedByPhone() {
        List<T> contactList = new ArrayList<>(contacts.values());
        contactList.sort(Comparator.comparing(Contact::getPhone));

        System.out.println("Contacts sorted by phone:");
        for (T contact : contactList) {
            System.out.println(contact);
        }
    }

    public boolean hasRelationship(String name1, String name2) {
        T contact1 = searchByName(name1);
        T contact2 = searchByName(name2);

        if (contact1 != null && contact2 != null) {
            return contact1.getAddress().equalsIgnoreCase(contact2.getAddress());
        }
        return false;
    }

    public List<T> getContactsWithSameAddress(String address) {
        List<T> results = new ArrayList<>();
        for (T contact : contacts.values()) {
            if (contact.getAddress().equalsIgnoreCase(address)) {
                results.add(contact);
            }
        }
        return results;
    }

    public void updateContact(String name, String newPhone, String newEmail, String newAddress) {
        T contact = searchByName(name);
        if (contact != null) {
            if (newPhone != null)
                contact.setPhone(newPhone);
            if (newEmail != null)
                contact.setEmail(newEmail);
            if (newAddress != null)
                contact.setAddress(newAddress);
            System.out.println("Contact updated: " + contact.getName());
            saveToFile();
        } else {
            System.out.println("Contact not found: " + name);
        }
    }

    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(contacts);
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            contacts = (HashMap<String, T>) ois.readObject();
            System.out.println("Contacts loaded from file: " + contacts.size() + " contacts");
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Starting with empty address book.");
            contacts = new HashMap<>();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading from file: " + e.getMessage());
            contacts = new HashMap<>();
        }
    }

    public void exportToTextFile(String textFileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(textFileName))) {
            writer.println("Address Book Contacts");
            writer.println("=====================");
            for (T contact : contacts.values()) {
                writer.println(contact);
                writer.println();
            }
            System.out.println("Contacts exported to: " + textFileName);
        } catch (IOException e) {
            System.out.println("Error exporting to text file: " + e.getMessage());
        }
    }

    public void importFromCSV(String csvFileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    Contact contact = new Contact(parts[0].trim(), parts[1].trim(),
                            parts[2].trim(), parts[3].trim());
                    addContact((T) contact);
                }
            }
            System.out.println("Contacts imported from CSV file.");
        } catch (IOException e) {
            System.out.println("Error importing from CSV: " + e.getMessage());
        }
    }

    public int getContactCount() {
        return contacts.size();
    }

    public void clearAllContacts() {
        contacts.clear();
        saveToFile();
        System.out.println("All contacts cleared.");
    }
}

public class AddressBookManagementSystem {
    public static void main(String[] args) {
        AddressBookManager<Contact> addressBook = new AddressBookManager<>("contacts.dat");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Address Book Management System ===");
            System.out.println("1. Add Contact");
            System.out.println("2. Remove Contact");
            System.out.println("3. Search by Name");
            System.out.println("4. Search by Phone");
            System.out.println("5. List All Contacts");
            System.out.println("6. List Contacts Sorted by Name");
            System.out.println("7. List Contacts Sorted by Phone");
            System.out.println("8. Check Relationship (Same Address)");
            System.out.println("9. Update Contact");
            System.out.println("10. Export to Text File");
            System.out.println("11. Import from CSV");
            System.out.println("12. Clear All Contacts");
            System.out.println("13. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();

                    Contact contact = new Contact(name, phone, email, address);
                    addressBook.addContact(contact);
                    break;

                case 2:
                    System.out.print("Enter name to remove: ");
                    String removeName = scanner.nextLine();
                    addressBook.removeContact(removeName);
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    Contact found = addressBook.searchByName(searchName);
                    if (found != null) {
                        System.out.println("Contact found: " + found);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter phone number to search: ");
                    String searchPhone = scanner.nextLine();
                    List<Contact> phoneResults = addressBook.searchByPhone(searchPhone);
                    if (phoneResults.isEmpty()) {
                        System.out.println("No contacts found with that phone number.");
                    } else {
                        System.out.println("Contacts found:");
                        for (Contact c : phoneResults) {
                            System.out.println(c);
                        }
                    }
                    break;

                case 5:
                    addressBook.listAllContacts();
                    break;

                case 6:
                    addressBook.listContactsSortedByName();
                    break;

                case 7:
                    addressBook.listContactsSortedByPhone();
                    break;

                case 8:
                    System.out.print("Enter first person's name: ");
                    String person1 = scanner.nextLine();
                    System.out.print("Enter second person's name: ");
                    String person2 = scanner.nextLine();

                    if (addressBook.hasRelationship(person1, person2)) {
                        System.out.println(person1 + " and " + person2 + " have the same address.");
                    } else {
                        System.out.println(person1 + " and " + person2 + " do not have the same address.");
                    }
                    break;

                case 9:
                    System.out.print("Enter name to update: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter new phone (or press Enter to skip): ");
                    String newPhone = scanner.nextLine();
                    System.out.print("Enter new email (or press Enter to skip): ");
                    String newEmail = scanner.nextLine();
                    System.out.print("Enter new address (or press Enter to skip): ");
                    String newAddress = scanner.nextLine();

                    addressBook.updateContact(updateName,
                            newPhone.isEmpty() ? null : newPhone,
                            newEmail.isEmpty() ? null : newEmail,
                            newAddress.isEmpty() ? null : newAddress);
                    break;

                case 10:
                    System.out.print("Enter text file name: ");
                    String textFile = scanner.nextLine();
                    addressBook.exportToTextFile(textFile);
                    break;

                case 11:
                    System.out.print("Enter CSV file name: ");
                    String csvFile = scanner.nextLine();
                    addressBook.importFromCSV(csvFile);
                    break;

                case 12:
                    System.out.print("Are you sure you want to clear all contacts? (y/n): ");
                    String confirm = scanner.nextLine();
                    if (confirm.equalsIgnoreCase("y")) {
                        addressBook.clearAllContacts();
                    }
                    break;

                case 13:
                    System.out.println("Thank you for using Address Book Management System!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            scanner.close();
        }
    }
}
