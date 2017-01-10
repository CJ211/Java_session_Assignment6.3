import java.util.TreeMap;

public class Bank {

 int balance = 100;

 public void deposit(int amount) {
  this.balance = amount;
  System.out.println(Thread.currentThread().getName()+" Deposit:" + balance);
 }

 public synchronized void withdraw(int amount) throws Exception{
  if (balance >= amount) {
   
   System.out.println(Thread.currentThread().getName()+" Withdrawing:" + balance);
   Thread.sleep(5000);
   this.balance =this.balance- amount;
   System.out.println(Thread.currentThread().getName()+" Withdrawn" + balance);
  } else {
   System.out.println(Thread.currentThread().getName()+" Withdraw: entered amount : " + amount + " more than balance:" + balance);
  }
 }
}


public class Withdrawer extends Thread {
 Bank bank;

 public Withdrawer(Bank bank) {
  this.bank = bank;

 }
 
 public void run(){
  try {
   bank.withdraw(100);
  } catch (Exception e) {
   
   e.printStackTrace();
  }
 }
}
public class TestBank {

 public static void main(String[] args) {
  
  Bank bank = new Bank();
  Withdrawer withdrawer = new Withdrawer(bank);
  Withdrawer withdrawer2 = new Withdrawer(bank);
  withdrawer.start();
  withdrawer2.start();
  
 }
 
}
