import java.util.HashMap;

public class BankAccount {
    private double balance;
    private int accountNumber;
    private String accountHolderName;
    private static int nextAccountNumber = 1000;
    private static HashMap<Integer, BankAccount> bankAccounts = new HashMap<Integer, BankAccount>();
    

    public BankAccount(double balance, String accountHolderName){
        this.balance = balance;
        this.accountHolderName = accountHolderName;
        this.accountNumber = nextAccountNumber++;
        bankAccounts.put(this.accountNumber, this);
    }

    public void transfer(double amount, int accountNumber)
    {   
        BankAccount account = getAccountByNumber(accountNumber);
        if(account == null){
            System.out.println("Dont Find account");
            return;
        }
        if(amount > 0 && balance >= amount){
            balance -= amount;
            account.balance += amount;
            checkBalance();
            return;
        }
        System.out.println("You need transfer amount more than 0 or you dont have this amount");
    }

    public BankAccount getAccountByNumber(int accountNumber){
        return bankAccounts.get(accountNumber);
    }   
    
    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Depositing: $" + amount);
            checkBalance();
            return;
        }
        System.out.println("You need deposit amount more than 0");
    }

    public void withdraw(double amount){
        if(amount > 0 && balance >= amount){
            balance -= amount;
            System.out.println("Withdrawing: $" + amount);
            checkBalance();
            return;
        }
        System.out.println("You need withdrawn amount more than 0 or Account balance is not enough");
    }

    public void checkBalance(){
        System.out.println("Your balance is $" + balance);
    }   


    public static void main(String[] args) {
        BankAccount firstAccount = new BankAccount(1000, "Dagoberto");
        System.out.println("Hello " + firstAccount.accountHolderName);
        BankAccount secondAccount = new BankAccount(300, "Amado");
        System.out.println("Hello " + secondAccount.accountHolderName);
        firstAccount.deposit(100);
        firstAccount.withdraw(1000);
        firstAccount.transfer(100, secondAccount.accountNumber);
        secondAccount.checkBalance();
    }
}

