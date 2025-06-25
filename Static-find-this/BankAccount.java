/**
 * BankAccount class demonstrates the usage of static variables, static methods,
 * this keyword, final variables, and instanceof operator
 */
public class BankAccount {
    // Static variable shared across all instances - represents the bank name
    private static String bankName = "Global Trust Bank";

    // Static variable to keep track of total number of accounts created
    private static int totalAccounts = 0;

    // Instance variables
    private String accountHolderName;

    // Final variable - account number cannot be changed once assigned
    private final String accountNumber;

    private double balance;

    /**
     * Constructor to initialize a new bank account
     * Uses 'this' keyword to resolve ambiguity when parameter names match instance
     * variables
     * 
     * @param accountHolderName Name of the account holder
     * @param accountNumber     Unique account number for the account
     * @param initialBalance    Initial balance to be deposited
     */
    public BankAccount(String accountHolderName, String accountNumber, double initialBalance) {
        // Using 'this' to distinguish between instance variable and parameter
        this.accountHolderName = accountHolderName;

        // Final variable assignment - can only be done once
        this.accountNumber = accountNumber;

        this.balance = initialBalance;

        // Increment the static counter whenever a new account is created
        totalAccounts++;
    }

    /**
     * Static method to get the total number of accounts created
     * Can be called without creating an instance of the class
     * 
     * @return Total number of bank accounts created
     */
    public static int getTotalAccounts() {
        return totalAccounts;
    }

    /**
     * Static method to get the bank name
     * 
     * @return Name of the bank
     */
    public static String getBankName() {
        return bankName;
    }

    /**
     * Method to deposit money into the account
     * 
     * @param amount Amount to be deposited
     */
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Amount deposited successfully. New balance: $" + this.balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    /**
     * Method to withdraw money from the account
     * 
     * @param amount Amount to be withdrawn
     */
    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            System.out.println("Amount withdrawn successfully. Remaining balance: $" + this.balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds!");
        }
    }

    /**
     * Method to display account details
     * This method is called only after instanceof verification
     */
    public void displayAccountDetails() {
        System.out.println("\n=== Account Details ===");
        System.out.println("Bank Name: " + bankName);
        System.out.println("Account Holder: " + this.accountHolderName);
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Current Balance: $" + this.balance);
        System.out.println("========================");
    }

    /**
     * Static method to display account details with instanceof check
     * Demonstrates the use of instanceof operator for type checking
     * 
     * @param obj Object to be checked and displayed
     */
    public static void displayAccountInfo(Object obj) {
        // Using instanceof to check if the object is of BankAccount type
        if (obj instanceof BankAccount) {
            System.out.println("Valid BankAccount object detected!");
            BankAccount account = (BankAccount) obj; // Safe casting after instanceof check
            account.displayAccountDetails();
        } else {
            System.out.println("Error: Object is not an instance of BankAccount class!");
        }
    }

    /**
     * Getter methods
     */
    public String getAccountHolderName() {
        return this.accountHolderName;
    }

    public String getAccountNumber() {
        return this.accountNumber; // Final variable - read-only access
    }

    public double getBalance() {
        return this.balance;
    }

    /**
     * Main method to demonstrate the BankAccount class functionality
     */
    public static void main(String[] args) {
        System.out.println("=== Bank Account System Demo ===\n");

        // Display initial bank information
        System.out.println("Bank Name: " + BankAccount.getBankName());
        System.out.println("Initial Total Accounts: " + BankAccount.getTotalAccounts());

        // Create bank account instances
        BankAccount account1 = new BankAccount("John Doe", "ACC001", 1500.0);
        BankAccount account2 = new BankAccount("Jane Smith", "ACC002", 2500.0);
        BankAccount account3 = new BankAccount("Bob Johnson", "ACC003", 1000.0);

        // Display total accounts after creation
        System.out.println("\nAfter creating accounts:");
        System.out.println("Total Accounts: " + BankAccount.getTotalAccounts());

        // Perform some banking operations
        System.out.println("\n=== Banking Operations ===");
        account1.deposit(500.0);
        account1.withdraw(200.0);

        account2.deposit(1000.0);
        account2.withdraw(3000.0); // This should fail due to insufficient funds

        // Demonstrate instanceof usage with valid BankAccount objects
        System.out.println("\n=== Instanceof Demonstration ===");
        BankAccount.displayAccountInfo(account1);
        BankAccount.displayAccountInfo(account2);
        BankAccount.displayAccountInfo(account3);

        // Demonstrate instanceof with invalid object
        String invalidObject = "This is not a BankAccount";
        BankAccount.displayAccountInfo(invalidObject);

        // Final demonstration - trying to modify final variable (this would cause
        // compile error)
        // account1.accountNumber = "NEW_ACC001"; // Uncommenting this line will cause
        // compilation error

        System.out.println("\nFinal Total Accounts: " + BankAccount.getTotalAccounts());
    }
}
