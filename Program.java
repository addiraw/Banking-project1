


class Bank{
    String name;
    int amount = 11;
    public synchronized void deposit(){
        while(amount>10){
            try {
                System.out.println("Enter into deposit waiting");
                wait();

            } catch (InterruptedException e) {
                System.err.println("Interrupted Exception Occur");
            }
        }

        System.err.println("depositing now");
        amount+=10;
        notifyAll();

    }
    public synchronized void withdraw(){

        while(amount<11){
            try {
                System.out.println("Entered into the withdraw waiting");
                wait();
            } catch (InterruptedException e) {
                System.err.println("Error Occured");
            }
        }
        System.out.println("withdrawing now");
        amount-=10;
        notifyAll();

    }

}
public class Program {

    Bank b = new Bank();
    public static void main(String[] args) {
        Program p = new Program();
        Thread t = new Thread(()->{
            p.b.deposit();
        });

        Thread t1 = new Thread(()->{
            p.b.withdraw();
        });

        t.start();
        t1.start();


  
        
    }
}
