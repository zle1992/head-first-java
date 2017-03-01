public class ThreadTester{
    public static void main(String[] args){
        Runnable threadJob = new MyRunnable();
        Thread t = new Thread(threadJob);
        t.start();
        System.out.println("main going!");
        
    }
}
