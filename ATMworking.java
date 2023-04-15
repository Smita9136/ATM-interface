package ATM;
import java.util.*;



public class ATMworking  {
  public static void main(String[] args){
    int flag=0;
    int account ;
    Scanner sc=new Scanner(System.in);
int op=0;
    ArrayList<userinfo> a=new ArrayList<>();

    do{
      System.out.println("-----------------------ATM-----------------------------");
      System.out.println("1.Create new account\n2.Enter into existing account");
      account=sc.nextInt();
      switch(account){
        case 1: 
          userinfo u=new userinfo();
          u.enterDetails();
          for(int i=0;i<a.size();i++){
          if(a.get(i).userid.equals(u.userid)){
            flag=1;
          }
         }
        if(flag==0){
        a.add(u);
        }
        System.out.println("Select Operation From Following\n1.Tansaction History\n2.Withdraw\n3.Deposit\n4.Transfer\n5.Check Balance\n6.Quit");

        op=sc.nextInt();
        switch(op){
          case 1:
         u.transaction_history();

         break;
          case 2:
          u.Withdraw();
          break;
          case 3:
          u.Deposit();
          break;
          case 4:
          System.out.println("Entr userId of client");
          String client=sc.next();
          System.out.println("Enter amount You Want to transfer");
          int x=sc.nextInt();
          if(x<u.balance){
          for(int i=0;i<a.size();i++){
            if(a.get(i).userid.equals(client))
            {
               a.get(i).transfer(u,x);
            }
          }
        }
        else{
          System.out.println("You have insufficient balance to make transfer");
        }
          break;
          case 5:
          u.Balance();
          break;
      }
      break;
      case 2:
      System.out.println("Enter UserId");
      String UserId=sc.next();
      System.out.println("Enter UserPin");
      String Userpin=sc.next();
      

      for(int i=0;i<a.size();i++){
        if(a.get(i).userid.equals(UserId)&& a.get(i).userpin.equals(Userpin)){
  
      System.out.println("Select Operation From Following\n1.Tansaction History\n2.Withdraw\n3.Deposit\n4.Transfer\n5.Check Balance\n6.Quit");

      op=sc.nextInt();
      switch(op){
        case 1:
        a.get(i).transaction_history();

       break;
        case 2:
        a.get(i).Withdraw();
        break;
        case 3:
        a.get(i).Deposit();
        break;
        case 4:
        System.out.println("Entr userId of client");
        String person=sc.next();
        System.out.println("Enter amount You Want to transfer");
        int k=sc.nextInt();
        if(k<a.get(i).balance){
        for(int j=0;j<a.size();j++){
          if(a.get(j).userid.equals(person))
          {
             a.get(j).transfer(a.get(i),k);
          }
        }
        }
      else{
        System.out.println("You have insufficient balance to make transfer");
      }
        break;
        case 5:
        a.get(i).Balance();
        break;
    }
  }
  else{
    System.out.println("Invalid UserId and Userpin");
  }
   
      }
      break;
        }
     // c=op; 
} while(op!=6 );

}
}

