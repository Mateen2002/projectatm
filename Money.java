import java.util.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.lang.model.util.ElementScanner14;

/*ATM-PIN : 2002
AVAILABLE BALANCE : 20000
cardno : 123456789
*/
public class Money {

  public static void main(String[] args) throws InterruptedException {
    LocalDateTime dt = LocalDateTime.now();
    int syshh = dt.getHour();
    int sysmm = dt.getMinute();
    Map<Integer, String> ministmt = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    int withdraw, deposit, balance;
    balance = 20000;
    int mpin, cardno = 123456789;
    System.out.println("-----------------------");
    System.out.println("Welcome! ATM");
    System.out.println("-----------------------");
    System.out.println("Enter your card number : ");
    int cardno1 = sc.nextInt();
    if (cardno1 == cardno) {
      while (true) {

        Thread.sleep(2000);

        System.out.println();
        System.out.println("-----------------------");
        System.out.println("Welcome! ATM");
        System.out.println("-----------------------");
        System.out.println("1.Withdraw");
        System.out.println("2.Deposit");
        System.out.println("3.Balance");
        System.out.println("4.Pin Change");
        System.out.println("5.Mini Statement");
        System.out.println("6.Exit");

        System.out.println("-----------------------");
        System.out.println("Enter your Choice : ");
        int num = sc.nextInt();

        int pin = 2002;
        switch (num) {
          case 1:
            System.out.println("\t\t\t\t__________Withdraw__________");
            System.out.print("Enter amount withdrawal : ");
            int withd = sc.nextInt();

            System.out.print("Please Enter Your Mpin : ");
            mpin = sc.nextInt();
            if (mpin == pin) {
              if (withd <= balance) {

                syshh = dt.getHour();
                sysmm = dt.getMinute();
                ministmt.put(withd, " Amount Withdrawn at " + syshh + ":" + sysmm);

                balance = balance - withd;

                System.out.println("Withdrawal process start plz wait...");
                Thread.sleep(2000);
                System.out.println("Withdrawal Successfull : " + withd);
                System.out.println("Please Collect Your Money. Take Your Card!");

              } else {
                Thread.sleep(250);
                System.out.println("Insufficient Balance..");
              }
            } else

              System.out.println("Incorrect pin");
            break;
          case 2:
            System.out.println("\t\t\t\t__________Deposit__________");
            System.out.print("Enter Deposit Amount : ");
            deposit = sc.nextInt();
            System.out.print("Please Enter Your Mpin : ");
            mpin = sc.nextInt();
            if (pin == mpin) {
              System.out.println("Deposit Process plz Wait...");
              syshh = dt.getHour();
              sysmm = dt.getMinute();
              ministmt.put(deposit, " Amount Deposited at " + syshh + ":" + sysmm);
              Thread.sleep(2000);
              System.out.println("Deposit Successfull : " + deposit);
              balance = balance + deposit;

              System.out.println("\t\t\t\tThank U");
            } else {
              Thread.sleep(250);
              System.out.println("Incorrect pin");
            }

            break;
          case 3:
            System.out.println("\t\t\t\t__________Account Balance__________");
            System.out.print("Please Enter Your Mpin : ");
            mpin = sc.nextInt();
            if (pin == mpin) {
              Thread.sleep(500);
              System.out.println("Your Account Balance : " + balance);

            } else {
              Thread.sleep(250);
              System.out.println("Incorrect pin");
            }
            break;

          case 4:
            System.out.println("Do You Want Change Mpin --> (Y/y) || (N/n) : ");
            char c = sc.next().charAt(0);
            if (c == 'y' || c == 'Y') {
              System.out.print("Enter Old Mpin : ");
              mpin = sc.nextInt();
              if (pin == mpin) {
                System.out.print("Enter New Mpin : ");
                mpin = sc.nextInt();
                System.out.print("Re-entered Mpin : ");
                int mpin1 = sc.nextInt();
                if (mpin == mpin1) {
                  System.out.print("Mpin Changed Successfully....");
                } else {
                  System.out.print("Not Matching...");
                }
              } else {
                System.out.println("Incorrect Mpin...");
              }
            } else if (c == 'N' || c == 'n') {
              System.out.println("Thank U");
            } else {
              System.out.println("Invalid Option...");
            }
            break;

          case 5:
            System.out.print("Please Enter Your Mpin : ");
            mpin = sc.nextInt();
            if (mpin == pin) {
              System.out.println("Plz Wait Processing...");
              Thread.sleep(250);
              System.out.println("_________Mini Statement__________");

              for (Map.Entry<Integer, String> m : ministmt.entrySet()) {
                System.out.println(m.getKey() + "" + m.getValue());
              }
              System.out.println("End of the Mini Statement");
            } else {
              System.out.println("Incorrect Pin");
            }
            break;
          case 6:
            System.out.println("Thank U...");
            System.out.println("Plz Take Your Card");
            System.exit(0);
            break;
          default:
            System.out.print("Invalid Choice : " + num);
        }
      }

    } else

    {
      System.out.println("Your card number is not exist");
    }
  }
}
