import java.util.*;
import java.util.stream.*;

class Invoice {
    private String transactionId;

    public Invoice(String transactionId) {
        this.transactionId = transactionId;
    }

    public String toString() {
        return "Invoice for: " + transactionId;
    }
}

public class InvoiceObjectCreation {
    public static void main(String[] args) {
        List<String> transactionIds = Arrays.asList("TXN1001", "TXN1002", "TXN1003");
        List<Invoice> invoices = transactionIds.stream()
                .map(Invoice::new)
                .collect(Collectors.toList());
        System.out.println(invoices);
    }
}
