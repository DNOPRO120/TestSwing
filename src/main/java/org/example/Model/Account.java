package org.example.Model;

import java.util.Date;

public class Account {
    private String accountNumber;
    private String owner;
    private double balance;
    private Date openingDate;
    private String accountType;

    public Account(String accountNumber, String owner, double balance, Date openingDate, String accountType) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
        this.openingDate = openingDate;
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", owner='" + owner + '\'' +
                ", balance=" + balance +
                ", openingDate=" + openingDate +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}
