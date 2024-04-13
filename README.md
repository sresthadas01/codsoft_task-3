# codsoft_task-3

TASK 3
(ATM INTERFACE)
1.	Create a class to represent the ATM machine.
2.	Design the user interface for the ATM, including options such as withdrawing, depositing, and checking the balance.
3.	Implement methods for each option, such as withdraw(amount), deposit(amount), and checkBalance().
4.	Create a class to represent the user's bank account, which stores the account balance.
5.	Connect the ATM class with the user's bank account class to access and modify the account balance.
6.	Validate user input to ensure it is within acceptable limits (e.g., sufficient balance for withdrawals).
7.	Display appropriate messages to the user based on their chosen options and the success or failure of their transactions.

# ans:

	import java.util.*;
	class bankaccount {
    private double Balance;
    public bankaccount(double balance) 
    {
        this.Balance = balance;
    }
    public boolean withdraw(double amount) 
    {
        if (amount <= Balance) 
        {
            Balance -= amount;
            System.out.println("Withdrawal is done. Now your account balance: " + Balance);
            return true;
        }
        else 
        {
            System.out.println("Not enough money. Withdrawal is not done. Try again....");
            return false;
        }
    }
    public void deposit(double amount) 
    {
        Balance += amount;
        System.out.println("Deposit is done. Now your account balance: " + Balance);
    }
    public double checkbalance() 
    {
        return Balance;
    }
	}
	class ATM {
    private bankaccount account;
    public ATM(bankaccount account) {
        this.account = account;
    }
    public void options() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
    }
    public void option(int option) {
        Scanner inputoption = new Scanner(System.in);
        switch (option) {
            case 1:
                System.out.print("Enter withdrawal amount: ");
                double withdrawalamount = inputoption.nextDouble();
                account.withdraw(withdrawalamount);
                break;
            case 2:
                System.out.print("Enter deposit amount: ");
                double depositamount = inputoption.nextDouble();
                account.deposit(depositamount);
                break;
            case 3:
                System.out.println("Your current balance is: " + account.checkbalance());
                break;
            default:
                System.out.println("Sorry You Choose wrong option. Please select correct option.");
        }
    }
    public static void main(String[] args) {
        bankaccount useraccount = new bankaccount(100.00);
        ATM atm = new ATM(useraccount);
        Scanner input = new Scanner(System.in);
        while (true) {
            atm.options();
            System.out.print("Enter your option: ");
            int choice = input.nextInt();
            atm.option(choice);
        }
    }
	}

 # instruction:

	1. copy full code.
	2. save the code: ATM.java
	3. combine the code: javac ATM.java
	4. run the code: java ATM
