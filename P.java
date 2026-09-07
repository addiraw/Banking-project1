class Q {
    
    boolean isTick = true;
    boolean isTock = false;

    public synchronized void tick(){
  
        while(!isTick){
            try{
                System.err.println("Waiting tick");
                wait();
            } catch(InterruptedException exception){
                System.out.println("System interrupted");
            }
        }
        System.err.println("tick");
        isTick = false;
        isTock = true;
        notify();


    }

    public synchronized void tock(){
        while(!isTock){
            try {
                System.err.println("Waiting tock");

                wait();
            } catch (InterruptedException e) {
                System.err.println("Exception occur");
            }
        }
        System.err.println("tock");
        isTock = false;
        isTick = true;
        notify();
    }
}
public class P{
    
    public static void main(String args[]){
        Q q = new Q();
        Thread tickThread = new Thread(()->{
            for(int i=0;i<5;i++)
            q.tick();
        },"Tick");

        Thread tockThread = new Thread(()->{
            for(int i=0;i<5;i++)
            q.tock();
        });

        tickThread.start();
        tockThread.start();
        }
}
