public class ParcelTracker {
    static class Order {
        Packed packed;
        Shipped shipped;
        InTransit transit;
        Delivered delivered;

        Order next;

        public Order(Packed packed, Shipped shipped, InTransit transit, Delivered delivered) {
            this.packed = new Packed(packed.isPacked);
            this.shipped = new Shipped(shipped.isShipped);
            this.transit = new InTransit(transit.isTransit);
            this.delivered = new Delivered(delivered.isDelivered);

            this.next = null;
        }
    }

    static Order head = null;
    static Order tail = null;

    static class Packed {
        boolean isPacked;
        Packed next;

        public Packed(boolean isPacked) {
            this.isPacked = isPacked;
            this.next = null;
        }
    }

    static class Shipped {
        boolean isShipped;
        Shipped next;

        public Shipped(boolean isShipped) {
            this.isShipped = isShipped;
            this.next = null;
        }
    }

    static class InTransit {
        boolean isTransit;
        InTransit next;

        public InTransit(boolean isTransit) {
            this.isTransit = isTransit;
            this.next = null;
        }
    }

    static class Delivered {
        boolean isDelivered;
        Delivered next;

        public Delivered(boolean isDelivered) {
            this.isDelivered = isDelivered;
            this.next = null;
        }
    }

    public static void addLast(Packed pStatus, Shipped sStatus, InTransit tStatus, Delivered dStatus) {
        Order status = new Order(pStatus, sStatus, tStatus, dStatus);

        if (head == null) {
            head = tail = status;
        } else {
            tail.next = status;
            tail = status;
        }
    }

    public static void displayStatus() {
        Order temp = head;

        while (temp != null) {
            if (temp.packed.isPacked) {
                System.out.print("Packed -> ");
            } else {
                System.out.println("Under Packing process");
                return;
            }

            if (temp.shipped.isShipped) {
                System.out.print("Shipped -> ");
            } else {
                System.out.println("Under Shipping process");
                return;
            }

            if (temp.transit.isTransit) {
                System.out.print("Transited -> ");
            } else {
                System.out.println("Under in Transit process");
                return;
            }

            if (temp.delivered.isDelivered) {
                System.out.print("Delivered ");
            } else {
                System.out.println("Under Delivering process");
                return;
            }

            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        addLast(new Packed(true), new Shipped(true), new InTransit(false), new Delivered(false));
        displayStatus();
    }
}