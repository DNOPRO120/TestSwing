package org.example.View;

import org.example.Controller.BankControlller;
import org.example.Model.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BankView extends JFrame {

    private JTextField accountNumberField, ownerField, balanceField, accountTypeField;
    private JTextArea resultArea;
    private BankControlller controller;

    public BankView(BankControlller controller) {
        this.controller = controller;

        setTitle("Bank Account Management");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        accountNumberField = new JTextField(10);
        ownerField = new JTextField(10);
        balanceField = new JTextField(10);
        accountTypeField = new JTextField(10);
        resultArea = new JTextArea(10, 40);
        JButton createButton = new JButton("Create");
        JButton readButton = new JButton("Read All");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");

        setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Account Number:"));
        inputPanel.add(accountNumberField);
        inputPanel.add(new JLabel("Owner:"));
        inputPanel.add(ownerField);
        inputPanel.add(new JLabel("Balance:"));
        inputPanel.add(balanceField);
        inputPanel.add(new JLabel("Account Type:"));
        inputPanel.add(accountTypeField);
        inputPanel.add(createButton);
        inputPanel.add(readButton);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);
        add(updateButton, BorderLayout.WEST);
        add(deleteButton, BorderLayout.EAST);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createAccount();
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateAccount();
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteAccount();
            }
        });

        readButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                readAllAccounts();
            }
        });
}
    private void createAccount() {
        String accountNumber = accountNumberField.getText();
        String owner = ownerField.getText();
        double balance = Double.parseDouble(balanceField.getText());
        String accountType = accountTypeField.getText();

        controller.createAccount(accountNumber, owner, balance, accountType);
        resultArea.setText("Account created successfully.");
    }

    private void readAllAccounts() {
        List<Account> accounts = controller.readAllAccounts();
        resultArea.setText("");
        for (Account account : accounts) {
            resultArea.append(account.toString() + "\n\n");
        }
    }

    private void updateAccount() {
        String accountNumber = accountNumberField.getText();
        double newBalance = Double.parseDouble(balanceField.getText());

        controller.updateAccountBalance(accountNumber, newBalance);
        resultArea.setText("Account balance updated successfully.");
    }

    private void deleteAccount() {
        String accountNumber = accountNumberField.getText();

        controller.deleteAccount(accountNumber);
        resultArea.setText("Account deleted successfully.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                BankControlller controlller=new BankControlller();
                BankView view=new BankView(controlller);
                view.setVisible(true);
            }
        });
    }

    }
