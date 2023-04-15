package ATM;
import java.util.*;

public class userinfo {
    protected String userid;
    protected String userpin;
    protected int balance=30000;
    private int withdraw;
    private int deposit;
    Map<Integer,String> m=new HashMap<>();
   Scanner sc=new Scanner(System.in);

    public void enterDetails(){

        System.out.println("Enter Your UserId");
        userid=sc.next();
        System.out.println("Enter Your UserPin");
        userpin=sc.next();
    }

    public void Withdraw(){
        System.out.println("Enter amount you want to withdraw:");
        withdraw=sc.nextInt();
        if(withdraw<=balance){
            balance=balance-withdraw;
            System.out.println("Please collect your cash");
            m.put(withdraw,"Rs Withdraw");
        }
        else{
            System.out.println("Insufficient Balance");
        }
    }

    public void Deposit(){
        System.out.println("Enter amount you want to Deposit:");
        withdraw=sc.nextInt();
        balance=balance+deposit;
        m.put(deposit,"Rs Deposited");
    }

    public void Balance(){
        System.out.println("Remaining Balance:"+balance+"Rs");
        
    }

    public void transfer(userinfo u,int x){
        u.balance=u.balance-x;
             balance=balance+x;
             System.out.println("Amount transered successfully!!");
             m.put(x,"Rs Transfered");
    }

    public void transaction_history(){
        System.out.println("-----------------------------------------------------");
        for(Map.Entry<Integer,String> s:m.entrySet()){
            System.out.println(s.getKey()+" "+s.getValue());
        }
        System.out.println("-----------------------------------------------------");
    }
    
}
