import java.util.Scanner;

public class InventoryManagementSystem {
    class Item {
        String itemName;
        int itemId;
        int quantity;
        double price;
        Item next;

        public Item(String itemName, int itemId, int quantity, double price) {
            this.itemName = itemName;
            this.itemId = itemId;
            this.quantity = quantity;
            this.price = price;
            this.next = null;
        }
    }

    private Item head = null;
    private int size = 0;

    public void addItemAtBeginning(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
        } else {
            newItem.next = head;
            head = newItem;
        }
        size++;
        System.out.println("Item added at beginning successfully!");
    }

    public void addItemAtEnd(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
        } else {
            Item temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newItem;
        }
        size++;
        System.out.println("Item added at end successfully!");
    }

    public void addItemAtPosition(String itemName, int itemId, int quantity, double price, int position) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position! Position should be between 0 and " + size);
            return;
        }

        if (position == 0) {
            addItemAtBeginning(itemName, itemId, quantity, price);
            return;
        }

        Item newItem = new Item(itemName, itemId, quantity, price);
        Item temp = head;
        for (int i = 0; i < position - 1; i++) {
            temp = temp.next;
        }
        newItem.next = temp.next;
        temp.next = newItem;
        size++;
        System.out.println("Item added at position " + position + " successfully!");
    }

    public void removeItemById(int itemId) {
        if (head == null) {
            System.out.println("No items in the inventory!");
            return;
        }

        if (head.itemId == itemId) {
            head = head.next;
            size--;
            System.out.println("Item with ID " + itemId + " removed successfully!");
            return;
        }

        Item temp = head;
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Item with ID " + itemId + " not found!");
            return;
        }

        temp.next = temp.next.next;
        size--;
        System.out.println("Item with ID " + itemId + " removed successfully!");
    }

    public void updateQuantityById(int itemId, int newQuantity) {
        if (head == null) {
            System.out.println("No items in the inventory!");
            return;
        }

        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated successfully for item ID: " + itemId);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item with ID " + itemId + " not found!");
    }

    public void searchItemById(int itemId) {
        if (head == null) {
            System.out.println("No items in the inventory!");
            return;
        }

        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                System.out.println("Item found:");
                System.out.println("Name: " + temp.itemName + ", ID: " + temp.itemId +
                        ", Quantity: " + temp.quantity + ", Price: $" + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item with ID " + itemId + " not found!");
    }

    public void searchItemByName(String itemName) {
        if (head == null) {
            System.out.println("No items in the inventory!");
            return;
        }

        Item temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Item found:");
                System.out.println("Name: " + temp.itemName + ", ID: " + temp.itemId +
                        ", Quantity: " + temp.quantity + ", Price: $" + temp.price);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("Item with name '" + itemName + "' not found!");
        }
    }

    public void calculateTotalValue() {
        if (head == null) {
            System.out.println("No items in the inventory!");
            return;
        }

        double totalValue = 0;
        Item temp = head;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total inventory value: $" + totalValue);
    }

    public void sortByName(boolean ascending) {
        if (head == null || head.next == null) {
            System.out.println("Not enough items to sort!");
            return;
        }

        for (Item i = head; i != null; i = i.next) {
            for (Item j = i.next; j != null; j = j.next) {
                boolean shouldSwap = ascending ? i.itemName.compareToIgnoreCase(j.itemName) > 0
                        : i.itemName.compareToIgnoreCase(j.itemName) < 0;

                if (shouldSwap) {
                    String tempName = i.itemName;
                    int tempId = i.itemId;
                    int tempQuantity = i.quantity;
                    double tempPrice = i.price;

                    i.itemName = j.itemName;
                    i.itemId = j.itemId;
                    i.quantity = j.quantity;
                    i.price = j.price;

                    j.itemName = tempName;
                    j.itemId = tempId;
                    j.quantity = tempQuantity;
                    j.price = tempPrice;
                }
            }
        }
        System.out.println("Items sorted by name in " + (ascending ? "ascending" : "descending") + " order!");
    }

    public void sortByPrice(boolean ascending) {
        if (head == null || head.next == null) {
            System.out.println("Not enough items to sort!");
            return;
        }

        for (Item i = head; i != null; i = i.next) {
            for (Item j = i.next; j != null; j = j.next) {
                boolean shouldSwap = ascending ? i.price > j.price : i.price < j.price;

                if (shouldSwap) {
                    String tempName = i.itemName;
                    int tempId = i.itemId;
                    int tempQuantity = i.quantity;
                    double tempPrice = i.price;

                    i.itemName = j.itemName;
                    i.itemId = j.itemId;
                    i.quantity = j.quantity;
                    i.price = j.price;

                    j.itemName = tempName;
                    j.itemId = tempId;
                    j.quantity = tempQuantity;
                    j.price = tempPrice;
                }
            }
        }
        System.out.println("Items sorted by price in " + (ascending ? "ascending" : "descending") + " order!");
    }

    public void displayAllItems() {
        if (head == null) {
            System.out.println("No items in the inventory!");
            return;
        }

        System.out.println("All Items in Inventory:");
        Item temp = head;
        int count = 1;
        while (temp != null) {
            System.out.println(count + ". Name: " + temp.itemName + ", ID: " + temp.itemId +
                    ", Quantity: " + temp.quantity + ", Price: $" + temp.price);
            temp = temp.next;
            count++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryManagementSystem system = new InventoryManagementSystem();

        while (true) {
            System.out.println("\n=== Inventory Management System ===");
            System.out.println("1. Add Item at Beginning");
            System.out.println("2. Add Item at End");
            System.out.println("3. Add Item at Position");
            System.out.println("4. Remove Item by ID");
            System.out.println("5. Update Quantity by ID");
            System.out.println("6. Search Item by ID");
            System.out.println("7. Search Item by Name");
            System.out.println("8. Calculate Total Inventory Value");
            System.out.println("9. Sort by Name (Ascending)");
            System.out.println("10. Sort by Name (Descending)");
            System.out.println("11. Sort by Price (Ascending)");
            System.out.println("12. Sort by Price (Descending)");
            System.out.println("13. Display All Items");
            System.out.println("14. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name1 = scanner.nextLine();
                    System.out.print("Enter item ID: ");
                    int id1 = scanner.nextInt();
                    System.out.print("Enter quantity: ");
                    int quantity1 = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double price1 = scanner.nextDouble();
                    system.addItemAtBeginning(name1, id1, quantity1, price1);
                    break;

                case 2:
                    System.out.print("Enter item name: ");
                    String name2 = scanner.nextLine();
                    System.out.print("Enter item ID: ");
                    int id2 = scanner.nextInt();
                    System.out.print("Enter quantity: ");
                    int quantity2 = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double price2 = scanner.nextDouble();
                    system.addItemAtEnd(name2, id2, quantity2, price2);
                    break;

                case 3:
                    System.out.print("Enter item name: ");
                    String name3 = scanner.nextLine();
                    System.out.print("Enter item ID: ");
                    int id3 = scanner.nextInt();
                    System.out.print("Enter quantity: ");
                    int quantity3 = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double price3 = scanner.nextDouble();
                    System.out.print("Enter position: ");
                    int position = scanner.nextInt();
                    system.addItemAtPosition(name3, id3, quantity3, price3, position);
                    break;

                case 4:
                    System.out.print("Enter item ID to remove: ");
                    int idToRemove = scanner.nextInt();
                    system.removeItemById(idToRemove);
                    break;

                case 5:
                    System.out.print("Enter item ID: ");
                    int idToUpdate = scanner.nextInt();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    system.updateQuantityById(idToUpdate, newQuantity);
                    break;

                case 6:
                    System.out.print("Enter item ID to search: ");
                    int idToSearch = scanner.nextInt();
                    system.searchItemById(idToSearch);
                    break;

                case 7:
                    System.out.print("Enter item name to search: ");
                    String nameToSearch = scanner.nextLine();
                    system.searchItemByName(nameToSearch);
                    break;

                case 8:
                    system.calculateTotalValue();
                    break;

                case 9:
                    system.sortByName(true);
                    break;

                case 10:
                    system.sortByName(false);
                    break;

                case 11:
                    system.sortByPrice(true);
                    break;

                case 12:
                    system.sortByPrice(false);
                    break;

                case 13:
                    system.displayAllItems();
                    break;

                case 14:
                    System.out.println("Exiting Inventory Management System...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
