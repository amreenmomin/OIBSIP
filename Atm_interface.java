import java.util.Scanner;

class Bank_Account {
    int balance;
    int prevTransaction;
    String customerName;
    String customerId;
    int flag = 0;

    Bank_Account(String cName, String cId) {
        customerName = cName;
        customerId = cId;
    }

    public final void clrscr() {
        try {
            try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } 
    } catch (final Exception es) {
        
    }

    }

    void checkId() {
        clrscr();
        System.out.println("Welcome " + customerName);
        System.out.println();
        System.out.print("Please enter the Customer ID or PIN: ");
        Scanner id = new Scanner(System.in);
        String chk = id.nextLine();
        if (chk.equals(customerId)) {
            clrscr();
            showMenu();
        } else {
            
            System.out.println("Wrong Login!!");
            

            if (flag < 3) {
                flag++;
                checkId();
            }
        }
    }

    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            prevTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (this.balance > amount) {
            balance = balance - amount;
            prevTransaction = -amount;
        } else {
            clrscr();
            
            System.out.println("Insufficient Balance!");
          
        }
    }

    void getPrevTransaction() {
        if (prevTransaction > 0) {
            System.out.println("Deposited: " + prevTransaction);
        } else if (prevTransaction < 0) {
            System.out.println("Withdraw: " + Math.abs(prevTransaction));
        } else {
            System.out.println("No Transaction Occured ");
        }
    }

    public void transfer(double amount, Bank_Account acc) {
        if (this.balance < amount) {
            clrscr();
            
            System.out.println("Insufficient Balance!");
           
        } else {
            this.balance -= amount;
            acc.balance += amount;
            System.out.println("Account of " + this.customerName + " becomes $" + this.balance);
            System.out.println("Account of " + acc.customerName + " becomes $" + acc.balance);
            System.out.println("\n");
        }
    }

    private void showMenu() {
        char option;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is  " + customerId);
        do {
            System.out.println("A. Check Balance");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. Previous Transaction");
            System.out.println("E. Transfer");
            System.out.println("F. Exit");

            
            System.out.println("Enter the option");
           
            option = sc.next().charAt(0);
            option = Character.toUpperCase(option);
           

            switch (option) {
                case 'A':
                    clrscr();
                    
                    System.out.println("Balance:" + balance);
         
                    break;

                case 'B':
                    clrscr();
                    
                    System.out.println("Enter the amount to deposit");
                  
                    int amount = sc.nextInt();
                    deposit(amount);
                   
                    break;
                
                case 'C':
                    clrscr();
                   
                    System.out.println("Enter the amount to withdraw");
                    
                    int amount2 = sc.nextInt();
                    withdraw(amount2);
                    break;

                case 'D':
                    clrscr();
                   
                    getPrevTransaction();
                    break;

                case 'E':
                    clrscr();
                    System.out.println("To whom");
                    Bank_Account bb = new Bank_Account("Sim", "1002");
                    System.out.println(bb.customerName);
                    System.out.println("Amount to Transfer");
                    double am = sc.nextDouble();
                    transfer(am, bb);
                    break;

                case 'F':
                    clrscr();
                    break;
                
                default:
                    clrscr();
                    System.out.println("Invalid Option!!! Please Enter Again");
            }

        } while (option != 'F');
        System.out.println("Thank You");

    }
}

public class Atm_interface {
    public static void main(String[] args) {
        Bank_Account b = new Bank_Account("Amreen", "1001");
        b.checkId();
    }

}

