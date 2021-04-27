package ee.bcs.valiit.tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lesson4 {
    // Store account nr as a key and account balance as value
    private static Map<String, Double> accountBalanceMap = new HashMap<>();
    //private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nInsert command:");
            System.out.println("\t1. CreateAccount");
            System.out.println("\t2. GetBalance");
            System.out.println("\t3. DepositMoney");
            System.out.println("\t4. WithdrawMoney");
            System.out.println("\t5. TransferMoney");
            System.out.println("\t6. Exit");
            int line = scanner.nextInt();
            scanner.nextLine();
            if (line == 6) {
                break;
            }
            // TODO 1
            // Add command: "createAccount ${accountNr}"
            // this has to store accountNr with 0 balance
            else if (line == 1) {
                System.out.print("Please enter account nr: ");
                String accountNr = scanner.nextLine();
                System.out.print("Please enter initial amount: ");
                Double balance = scanner.nextDouble();
                scanner.nextLine(); //vajalik, et liikuda edasi
                accountBalanceMap.put(accountNr, balance);
            }
            // TODO 2
            // Add command: "getBalance ${accountNr}"
            // this has to display account balance of specific acount
            else if (line == 2) {
                System.out.print("Please enter account nr: ");
                String accountNr = scanner.nextLine();
                System.out.print("Account balance is: " + accountBalanceMap.get(accountNr));
            }
            // TODO 3
            // Add command: "depositMoney ${accountNr} ${amount}
            // this has to add specified amount of money to account
            // You have to check that amount is positive number
            else if (line == 3) {
                System.out.print("Please enter account nr: ");
                String accountNr = scanner.nextLine();
                System.out.print("Please enter deposit amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                //boolean isDouble = scanner.hasNextDouble();
                if (amount > 0) {
                    double newBalance = accountBalanceMap.get(accountNr) + amount;
                    System.out.print("Account balance is now: " + newBalance);
                    accountBalanceMap.put(accountNr, newBalance);
                } else {
                    System.out.println("Try again");
                }
            }
            // TODO 4
            // Add command: "withdrawMoney ${accountNr} ${amount}
            // This has to remove specified amount of money from account
            // You have to check that amount is positive number
            // You may not allow this transaction if account balance would become negative
            else if (line == 4) {
                System.out.print("Please enter account nr: ");
                String accountNr = scanner.nextLine();
                System.out.print("Please enter withdraw amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                if (amount > 0) {
                    if ((accountBalanceMap.get(accountNr)) >= amount) {
                        double newBalance = accountBalanceMap.get(accountNr) - amount;
                        System.out.print("Account balance is now: " + (newBalance));
                        accountBalanceMap.put(accountNr, newBalance);
                    } else {
                        System.out.println("Not enough money for withdraw");
                    }
                } else {
                    System.out.println("Try again");
                }
            }
            // TODO 5
            // Add command: "transfer ${fromAccount} ${toAccount} ${amount}
            // This has to remove specified amount from fromAccount and add it to toAccount
            // Your application needs to check that toAccount is positive
            // And from account has enough money to do that transaction
            else if (line == 5) {
                System.out.print("Please enter accountFrom nr: ");
                String accountFrom = scanner.nextLine();
                System.out.print("Please enter transfer amount: ");
                double transferAmount = scanner.nextDouble();
                scanner.nextLine();
                if (transferAmount > 0) {
                    if (transferAmount <= accountBalanceMap.get(accountFrom)) {
                        System.out.print("Please enter toAccount nr: ");
                        String accountTo = scanner.nextLine();
                        double newFromBalance = accountBalanceMap.get(accountFrom) - transferAmount;
                        double newToBalance = accountBalanceMap.get(accountTo) + transferAmount;
                        System.out.println("Your fromAccount balance is now: " + newFromBalance);
                        accountBalanceMap.put(accountFrom, newFromBalance);
                        System.out.println("Your toAccount balance is now: " + newToBalance);
                        accountBalanceMap.put(accountTo, newToBalance);
                    } else {
                        System.out.println("Not enough money to transfer");
                    }
                } else {
                    System.out.println("Try again");
                }

            } else {
                System.out.println("Unknown command");
            }
        }
    }
}
