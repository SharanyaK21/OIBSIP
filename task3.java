import java.util.*;

class BankAccount{
    String name;
    String username;
    String password;
    String accountNo;
    float balance=1000000f;
    int transactions=0;
    String transactionHistory="";


    public void register(){
        Scanner sa=new Scanner(System.in);
        System.out.println("\nEnter your name:");
        this.name=sa.nextLine();
        System.out.println("\nEnter your username:");
        this.username=sa.nextLine();
        System.out.println("\nEnter password:");
        this.password=sa.nextLine();
        System.out.println("\nEnter your account number:");
        this.accountNo=sa.nextLine();
        System.out.println("\nRegistration successful!!! kindly login");
    }

public boolean login(){
    boolean isLogin=false;
    Scanner sa=new Scanner(System.in);
    while(!isLogin){
        System.out.println("\nEnter your username:");
        String UserName=sa.nextLine();
        if(UserName.equals(username)){
            while(!isLogin){
                System.out.println("\nEnter your password:");
                String PassWord=sa.nextLine();
                if(PassWord.equals(password)){
                    System.out.println("\nLogin successful!!!");
                    isLogin=true;
                }
                else{
                    System.out.println("\nIncorrect password entered");
                }
            }
        }
        else{
            System.out.println("\nUsername not found");
        }
    }
    return isLogin;
}

    public void withdraw(){
        System.out.println("\nEnter amount to withdraw:");
        Scanner sa=new Scanner(System.in);
        float amount=sa.nextFloat();
        try{
            if(balance >= amount){
                transactions++;
                balance -=amount;
                System.out.println("\nWithdraw successful!!!");
                String str=amount + "Rs withdrawed\n";
                transactionHistory=transactionHistory.concat(str);
            }
            else{
                System.out.println("\nInsufficient balance!!!");
            }
        }
        catch(Exception e){
        }
    }

public void deposit(){
    System.out.println("\nEnter amount to deposit:");
    Scanner sa=new Scanner(System.in);
    float amount =sa.nextFloat();
    try{
        if(amount<=1000000f){
            transactions++;
            balance+=amount;
            System.out.println("\nSuccessfully deposited!!!");
            String str=amount + "Rs deposited\n";
            transactionHistory=transactionHistory.concat(str);
        }
        else{
            System.out.println("\nSorry...Limit is 1000000.00");
        }
    }
    catch(Exception e){
    }
}

    public void transfer(){
        Scanner sa=new Scanner(System.in);
        System.out.println("\nEnter receipent's name:");
        String receipent=sa.nextLine();
        System.out.println("\nEnter amount to transfer:");
        float amount=sa.nextFloat();
        try{
            if(balance>=amount){
                if(amount<=50000f){
                    transactions++;
                    balance-=amount;
                    System.out.println("\nSuccessfully transfered to"+receipent);
                    String str=amount + "Rs transfered to" + receipent+"\n";
                    transactionHistory=transactionHistory.concat(str);
                }
                else{
                    System.out.println("\nSorry...Limit is 50000.00");
                }
            }
            else{
                System.out.println("\nInsufficient balance!!!");
            }
        }
        catch(Exception e){
        }
    }

    public void checkBalance(){
        System.out.println("\n" + balance +"Rs");
    }

    public void transHistory(){
        if(transactions==0){
            System.out.println("\nEmpty");
        }
        else{
            System.out.println("\n"+transactionHistory);
        }
    }
}
public class AtmInterface{
    public static int takeIntegerInput(int limit){
        int input=0;
        boolean flag=false;
        while(!flag){
            try{
                Scanner sa=new Scanner(System.in);
                input = sa.nextInt();
                flag=true;
                if(flag&&input > limit || input< 1){
                    System.out.println("Choose the number between 1 to "+limit);
                    flag=false;
                }
            }
            catch(Exception e){
                System.out.println("\nEnter only integer value");
                flag=false;
            }
        };
        return input;
    }

    public static void main(String[] args){
        System.out.println("\n*****Welcome to SBI ATM System****\n");
        System.out.println("1.Register \n2.Exit");
        System.out.println("\nEnter your choice:");
        int choice=takeIntegerInput(2);
        
        if(choice==1){
            BankAccount b=new BankAccount();
            b.register();
            while(true){
                System.out.println("\n 1.Login \n2.Exit");
                System.out.println("\nEnter your choice:");
                int ch=takeIntegerInput(2);
                if(ch==1){
                    if(b.login()){
                        System.out.println("******Welcome back\t"+ b.name+"*********\n");
                        boolean isFinished=false;
                        while(!isFinished){
                            System.out.println("\n 1.Withdraw \n 2.Deposit \n 3.Transfer \n 4.Check balance \n 5. transaction history \n 6.Exit");
                            System.out.println("\nEnter your choice:");
                            int c=takeIntegerInput(6);
                            switch(c){
                                case 1:
                                b.withdraw();
                                break;
                                case 2:
                                b.deposit();
                                break;
                                case 3:
                                b.transfer();
                                break;
                                case 4:
                                b.checkBalance();
                                break;
                                case 5:
                                b.transHistory();
                                break;
                                case 6:
                                isFinished=true;
                                break;
                            }
                        }
                    }
                }
                else{
                    System.exit(0);
                }
            }
        }
        else{
            System.exit(0);
        }
    }
}
