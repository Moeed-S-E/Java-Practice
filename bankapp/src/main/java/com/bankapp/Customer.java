package com.bankapp;

public interface Customer {
    String getCustomerId();
    String getName();
    BankAccount getAccount();
    void setAccount(BankAccount account);
}

