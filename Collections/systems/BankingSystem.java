package systems;

import java.util.*;

class Customer {
    private String accountNumber;
    private String name;
    private double balance;

    public Customer(String accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return String.format("Customer{account='%s', name='%s', balance=%.2f}",
                accountNumber, name, balance);
    }
}

class WithdrawalRequest {
    private String accountNumber;
    private double amount;

    public WithdrawalRequest(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("WithdrawalRequest{account='%s', amount=%.2f}",
                accountNumber, amount);
    }
}

public class BankingSystem {
    private HashMap<String, Customer> accounts;
    private TreeMap<Double, List<Customer>> customersByBalance;
    private Queue<WithdrawalRequest> withdrawalQueue;

    public BankingSystem() {
        accounts = new HashMap<>();
        customersByBalance = new TreeMap<>(Collections.reverseOrder());
        withdrawalQueue = new LinkedList<>();
    }

    public void addCustomer(Customer customer) {
        accounts.put(customer.getAccountNumber(), customer);
        updateCustomersByBalance(customer);
    }

    private void updateCustomersByBalance(Customer customer) {
        customersByBalance.values().forEach(list -> list.remove(customer));

        double balance = customer.getBalance();
        customersByBalance.putIfAbsent(balance, new ArrayList<>());
        customersByBalance.get(balance).add(customer);

        customersByBalance.entrySet().removeIf(entry -> entry.getValue().isEmpty());
    }

    public void deposit(String accountNumber, double amount) {
        Customer customer = accounts.get(accountNumber);
        if (customer != null) {
            customer.setBalance(customer.getBalance() + amount);
            updateCustomersByBalance(customer);
            System.out.printf("Deposited $%.2f to account %s%n", amount, accountNumber);
        } else {
            System.out.println("Account not found: " + accountNumber);
        }
    }

    public void requestWithdrawal(String accountNumber, double amount) {
        withdrawalQueue.offer(new WithdrawalRequest(accountNumber, amount));
        System.out.printf("Withdrawal request queued: $%.2f from account %s%n", amount, accountNumber);
    }

    public void processWithdrawals() {
        System.out.println("Processing withdrawal requests:");

        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest request = withdrawalQueue.poll();
            Customer customer = accounts.get(request.getAccountNumber());

            if (customer != null) {
                if (customer.getBalance() >= request.getAmount()) {
                    customer.setBalance(customer.getBalance() - request.getAmount());
                    updateCustomersByBalance(customer);
                    System.out.printf("Processed: Withdrew $%.2f from account %s%n",
                            request.getAmount(), request.getAccountNumber());
                } else {
                    System.out.printf("Insufficient funds: Account %s, requested $%.2f, balance $%.2f%n",
                            request.getAccountNumber(), request.getAmount(), customer.getBalance());
                }
            } else {
                System.out.println("Account not found: " + request.getAccountNumber());
            }
        }
    }

    public void displayCustomersSortedByBalance() {
        System.out.println("Customers sorted by balance (highest first):");
        for (Map.Entry<Double, List<Customer>> entry : customersByBalance.entrySet()) {
            for (Customer customer : entry.getValue()) {
                System.out.println(customer);
            }
        }
    }

    public Customer getCustomer(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        bank.addCustomer(new Customer("ACC001", "John Doe", 5000.0));
        bank.addCustomer(new Customer("ACC002", "Jane Smith", 7500.0));
        bank.addCustomer(new Customer("ACC003", "Bob Johnson", 3000.0));
        bank.addCustomer(new Customer("ACC004", "Alice Brown", 10000.0));

        bank.displayCustomersSortedByBalance();
        System.out.println();

        bank.deposit("ACC001", 1000.0);
        bank.requestWithdrawal("ACC002", 2000.0);
        bank.requestWithdrawal("ACC003", 5000.0);
        bank.requestWithdrawal("ACC004", 500.0);

        System.out.println();
        bank.processWithdrawals();

        System.out.println();
        bank.displayCustomersSortedByBalance();
    }
}
