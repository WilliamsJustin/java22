import java.io.*;

public class Test {
	public static void main(String[] args) throws Exception {
		FileWriter fw = new FileWriter("111.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		for(int i=1; i<= 25; i++) {
			bw.write(i + " ");
			if(i%5 == 0) bw.newLine();
		}
		
		bw.flush();
		bw.close();
	}
}

class Customer{  
int amount=10000;  
  
synchronized void withdraw(int amount){  
System.out.println("going to withdraw...");  
  
if(this.amount<amount){  
System.out.println("Less balance; waiting for deposit...");  
try{wait();}catch(Exception e){}  
}  
this.amount-=amount;  
System.out.println("withdraw completed...");  
}  
  
synchronized void deposit(int amount){  
System.out.println("going to deposit...");  
this.amount+=amount;  
System.out.println("deposit completed... ");  
notify();  
}  
}  
  
class Test{  
public static void main(String args[]){  
final Customer c=new Customer();  
new Thread(){  
public void run(){c.withdraw(15000);}  
}.start();  
new Thread(){  
public void run(){c.deposit(10000);}  
}.start();  
  
}}  