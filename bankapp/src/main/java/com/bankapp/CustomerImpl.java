package com.bankapp;

public class CustomerImpl implements Customer {
    private String customerId;
    private String name;
    private BankAccount account;

    public CustomerImpl(String customerId, String name, double initialBalance) {
        this.customerId = customerId;
        this.name = name;
        this.account = new Account(initialBalance);
    }

    @Override
    public String getCustomerId() {
        return customerId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BankAccount getAccount() {
        return account;
    }

    @Override
    public void setAccount(BankAccount account) {
        this.account = account;
    }
}
