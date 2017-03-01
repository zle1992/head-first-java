public class MyRunnable implements Runnable{
    public void run(){
        domore();
    }
    public void domore(){
        System.out.println("thread going");
    }
}
