public class Q12_BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    public Q12_BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;

        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
            System.out.println("Warning: Initial balance cannot be negative. Setting balance to 0.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of $" + amount + " successful.");
        } else {
            System.out.println("Error: Deposit amount must be positive.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " successful.");
            return true;
        } else if (amount <= 0) {
            System.out.println("Error: Withdrawal amount must be positive.");
            return false;
        } else {
            System.out.println("Error: Insufficient funds.");
            return false;
        }
    }

    public void displayDetails() {
        System.out.println("Account Details:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }
}

class Q12_SavingsAccount extends Q12_BankAccount {
    private double interestRate;

    public Q12_SavingsAccount(String accountNumber, String accountHolder, double initialBalance, double interestRate) {
        super(accountNumber, accountHolder, initialBalance);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
        System.out.println("Interest added: $" + interest);
    }

    public void demonstrateAccess() {
        System.out.println("Accessing Public Member (Account Number): " + accountNumber);
        System.out.println("Accessing Protected Member (Account Holder): " + accountHolder);
        System.out.println("Accessing Private Member via getter: $" + getBalance());
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Interest Rate: " + interestRate + "%");
    }

    public static void main(String[] args) {
        Q12_BankAccount account = new Q12_BankAccount("123456789", "John Smith", 1000.0);
        System.out.println("Regular Bank Account:");
        account.displayDetails();

        System.out.println("\nPerforming Transactions:");
        account.deposit(500.0);
        account.withdraw(200.0);
        System.out.println("Updated Balance: $" + account.getBalance());

        System.out.println("\nSavings Account:");
        Q12_SavingsAccount savingsAccount = new Q12_SavingsAccount("987654321",
                "Jane Doe",
                2000.0,
                2.5);
        savingsAccount.displayDetails();

        System.out.println("\nAdding Interest:");
        savingsAccount.addInterest();
        savingsAccount.displayDetails();

        System.out.println("\nDemonstrating Access to Members in Savings Account:");
        savingsAccount.demonstrateAccess();
    }
}
