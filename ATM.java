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
