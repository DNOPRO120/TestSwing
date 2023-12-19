package org.example.Controller;

import org.example.Model.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BankControlller {
    private Connection connection;
    public BankControlller() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/BankDB",
                    "root",
                    "");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void createAccount(String accountNumber, String owner, double balance, String accountType) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO account VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, accountNumber);
            statement.setString(2, owner);
            statement.setDouble(3, balance);
            statement.setDate(4, new Date(new java.util.Date().getTime()));  // Opening date
            statement.setString(5, accountType);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Account> readAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM account");

            while (resultSet.next()) {
                String accountNumber = resultSet.getString("accountnumber");
                String owner = resultSet.getString("owner");
                double balance = resultSet.getDouble("balance");
                Date openingDate = resultSet.getDate("openingdate");
                String accountType = resultSet.getString("accounttype");

                Account account = new Account(accountNumber, owner, balance, openingDate, accountType);
                accounts.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public void updateAccountBalance(String accountNumber, double newBalance) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE account SET balance = ? WHERE accountnumber = ?");
            statement.setDouble(1, newBalance);
            statement.setString(2, accountNumber);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAccount(String accountNumber) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM account WHERE accountnumber = ?");
            statement.setString(1, accountNumber);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
