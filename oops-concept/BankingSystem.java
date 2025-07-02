abstract class BankAccount {
    protected String accountNumber;
    protected String holderName;
    protected double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public abstract double calculateInterest();

    public String getAccountNumber() {
        return accountNumber;
    }

    private void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    private void setBalance(double balance) {
        this.balance = balance;
    }
}

interface Loanable {
    void applyForLoan();

    boolean calculateLoanEligibility();
}

class SavingsAccount extends BankAccount implements Loanable {
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * 0.04;
    }

    @Override
    public void applyForLoan() {
        if (calculateLoanEligibility()) {
            System.out.println("Loan application approved for Savings Account");
        } else {
            System.out.println("Loan application rejected for Savings Account");
        }
    }

    @Override
    public boolean calculateLoanEligibility() {
        return balance >= 10000;
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * 0.02;
    }

    @Override
    public void applyForLoan() {
        if (calculateLoanEligibility()) {
            System.out.println("Loan application approved for Current Account");
        } else {
            System.out.println("Loan application rejected for Current Account");
        }
    }

    @Override
    public boolean calculateLoanEligibility() {
        return balance >= 50000;
    }
}

public class BankingSystem {
    public static void processAccounts(BankAccount[] accounts) {
        for (BankAccount account : accounts) {
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Account Holder: " + account.getHolderName());
            System.out.println("Balance: $" + account.getBalance());
            System.out.println("Interest: $" + account.calculateInterest());

            if (account instanceof Loanable) {
                ((Loanable) account).applyForLoan();
            }
            System.out.println("------------------------");
        }
    }

    public static void main(String[] args) {
        BankAccount[] accounts = {
                new SavingsAccount("SAV001", "John Doe", 15000),
                new CurrentAccount("CUR001", "Jane Smith", 75000),
                new SavingsAccount("SAV002", "Bob Johnson", 5000)
        };

        processAccounts(accounts);

        System.out.println("\nPerforming transactions:");
        accounts[0].deposit(2000);
        accounts[1].withdraw(5000);
        accounts[2].deposit(1000);

        System.out.println("\nUpdated account details:");
        processAccounts(accounts);
    }
}
