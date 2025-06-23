public class Q3_InventoryTracker {

    static class Item {
        String itemCode;
        String itemName;
        double price;

        public Item(String itemCode, String itemName, double price) {
            this.itemCode = itemCode;
            this.itemName = itemName;
            this.price = price;
        }

        public double totalCost(int quantity) {
            return price * quantity;
        }

        public void displayItemDetails(int quantity) {
            System.out.println("Item Code   : " + itemCode);
            System.out.println("Item Name   : " + itemName);
            System.out.println("Unit Price  : ₹" + price);
            System.out.println("Quantity    : " + quantity);
            System.out.println("Total Cost  : ₹" + totalCost(quantity));
        }
    }

    public static void main(String[] args) {
        Item item = new Item("I102", "USB Cable", 199.0);
        item.displayItemDetails(3);
    }
}
