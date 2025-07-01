class Order {
    protected String orderId;
    protected String orderDate;
    protected String customerName;
    protected double orderAmount;

    public Order(String orderId, String orderDate, String customerName, double orderAmount) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerName = customerName;
        this.orderAmount = orderAmount;
    }

    public String getOrderStatus() {
        return "Order Placed";
    }

    public void displayOrderInfo() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Customer: " + customerName);
        System.out.println("Amount: $" + orderAmount);
        System.out.println("Status: " + getOrderStatus());
    }

    public String getOrderId() {
        return orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getOrderAmount() {
        return orderAmount;
    }
}

class ShippedOrder extends Order {
    protected String trackingNumber;
    protected String shippingDate;
    protected String carrierService;

    public ShippedOrder(String orderId, String orderDate, String customerName, double orderAmount,
            String trackingNumber, String shippingDate, String carrierService) {
        super(orderId, orderDate, customerName, orderAmount);
        this.trackingNumber = trackingNumber;
        this.shippingDate = shippingDate;
        this.carrierService = carrierService;
    }

    @Override
    public String getOrderStatus() {
        return "Shipped";
    }

    @Override
    public void displayOrderInfo() {
        super.displayOrderInfo();
        System.out.println("Tracking Number: " + trackingNumber);
        System.out.println("Shipping Date: " + shippingDate);
        System.out.println("Carrier: " + carrierService);
    }

    public void trackShipment() {
        System.out.println("Tracking shipment with number: " + trackingNumber);
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public String getShippingDate() {
        return shippingDate;
    }

    public String getCarrierService() {
        return carrierService;
    }
}

class DeliveredOrder extends ShippedOrder {
    private String deliveryDate;
    private String deliveryTime;
    private String deliveredBy;
    private boolean signatureRequired;

    public DeliveredOrder(String orderId, String orderDate, String customerName, double orderAmount,
            String trackingNumber, String shippingDate, String carrierService,
            String deliveryDate, String deliveryTime, String deliveredBy, boolean signatureRequired) {
        super(orderId, orderDate, customerName, orderAmount, trackingNumber, shippingDate, carrierService);
        this.deliveryDate = deliveryDate;
        this.deliveryTime = deliveryTime;
        this.deliveredBy = deliveredBy;
        this.signatureRequired = signatureRequired;
    }

    @Override
    public String getOrderStatus() {
        return "Delivered";
    }

    @Override
    public void displayOrderInfo() {
        super.displayOrderInfo();
        System.out.println("Delivery Date: " + deliveryDate);
        System.out.println("Delivery Time: " + deliveryTime);
        System.out.println("Delivered By: " + deliveredBy);
        System.out.println("Signature Required: " + (signatureRequired ? "Yes" : "No"));
    }

    public void confirmDelivery() {
        System.out.println("Order " + orderId + " confirmed delivered on " + deliveryDate + " at " + deliveryTime);
    }

    public int calculateDeliveryDays() {
        return 5;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public String getDeliveredBy() {
        return deliveredBy;
    }

    public boolean isSignatureRequired() {
        return signatureRequired;
    }
}

public class OnlineRetailOrderManagement {
    public static void main(String[] args) {
        System.out.println("=== Online Retail Order Management System ===\n");

        Order order1 = new Order("ORD001", "2025-06-25", "John Smith", 299.99);
        ShippedOrder order2 = new ShippedOrder("ORD002", "2025-06-24", "Alice Johnson", 459.50,
                "TRK123456789", "2025-06-26", "FedEx");
        DeliveredOrder order3 = new DeliveredOrder("ORD003", "2025-06-20", "Bob Wilson", 199.99,
                "TRK987654321", "2025-06-22", "UPS",
                "2025-06-28", "14:30", "Mike Delivery", true);

        System.out.println("1. Basic Order Information:");
        order1.displayOrderInfo();
        System.out.println();

        System.out.println("2. Shipped Order Information:");
        order2.displayOrderInfo();
        order2.trackShipment();
        System.out.println();

        System.out.println("3. Delivered Order Information:");
        order3.displayOrderInfo();
        order3.confirmDelivery();
        System.out.println("Delivery took: " + order3.calculateDeliveryDays() + " days");
        System.out.println();

        System.out.println("4. Order Status Summary:");
        Order[] orders = { order1, order2, order3 };
        for (Order order : orders) {
            System.out.println("Order " + order.getOrderId() + " - Status: " + order.getOrderStatus());
        }

        System.out.println("\n=== End of Order Management Demo ===");
    }
}
