package com.bankapp;
import java.io.*;
import java.util.*;

public class DatabaseManager {

    private static final String DATABASE_FILE = "customers.csv";

    // Save customer information to CSV file
    public static void saveCustomer(Customer customer) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATABASE_FILE, true))) {
            writer.write(customer.getCustomerId() + "," + customer.getName() + "," + customer.getAccount().getBalance());
            writer.newLine();
            System.out.println("Customer data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving customer data: " + e.getMessage());
        }
    }

    // Load customer data from CSV file
    public static List<Customer> loadCustomers() {
        List<Customer> customers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DATABASE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String customerId = data[0];
                String name = data[1];
                double balance = Double.parseDouble(data[2]);
                CustomerImpl customer = new CustomerImpl(customerId, name, balance);
                customers.add(customer);
            }
        } catch (IOException e) {
            System.out.println("Error loading customer data: " + e.getMessage());
        }
        return customers;
    }

    // Update customer data in the CSV file (if required)
    public static void updateCustomerData(List<Customer> customers) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATABASE_FILE))) {
            for (Customer customer : customers) {
                writer.write(customer.getCustomerId() + "," + customer.getName() + "," + customer.getAccount().getBalance());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error updating customer data: " + e.getMessage());
        }
    }
}
