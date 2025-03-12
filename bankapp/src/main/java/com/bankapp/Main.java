package com.bankapp;
import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Customer> customers = DatabaseManager.loadCustomers();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to the Bank System");
            System.out.println("1. Create Account");
            System.out.println("2. View Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    viewAccount();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    withdraw();
                    break;
                case 5:
                    System.out.println("Exiting the system...");
                    DatabaseManager.updateCustomerData(customers);
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private static void createAccount() {
        System.out.print("Enter customer ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        CustomerImpl newCustomer = new CustomerImpl(id, name, balance);
        customers.add(newCustomer);
        DatabaseManager.saveCustomer(newCustomer);
        System.out.println("Account created successfully.");
    }

    private static void viewAccount() {
        System.out.print("Enter customer ID: ");
        String id = scanner.nextLine();
        Customer customer = findCustomerById(id);

        if (customer != null) {
            System.out.println("Customer Name: " + customer.getName());
            System.out.println("Balance: " + customer.getAccount().getBalance());
        } else {
            System.out.println("Customer not found.");
        }
    }

    private static void deposit() {
        System.out.print("Enter customer ID: ");
        String id = scanner.nextLine();
        Customer customer = findCustomerById(id);

        if (customer != null) {
            System.out.print("Enter amount to deposit: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();  // Consume newline
            customer.getAccount().deposit(amount);
        } else {
            System.out.println("Customer not found.");
        }
    }

    private static void withdraw() {
        System.out.print("Enter customer ID: ");
        String id = scanner.nextLine();
        Customer customer = findCustomerById(id);

        if (customer != null) {
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();  // Consume newline
            customer.getAccount().withdraw(amount);
        } else {
            System.out.println("Customer not found.");
        }
    }

    private static Customer findCustomerById(String id) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(id)) {
                return customer;
            }
        }
        return null;
    }
}
