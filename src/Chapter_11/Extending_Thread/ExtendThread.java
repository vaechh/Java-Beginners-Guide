package Chapter_11.Extending_Thread;

public class ExtendThread {
    public static void main(String[] args) {
        MyThread mt = MyThread.createAndStart("Child #1");
        for(int i=0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            }
            catch(InterruptedException exc) {
                System.out.println("Main thread interrupted.");
            }
        }
        System.out.println("Main thread ending.");
    }
}

class MyThread extends Thread {
    MyThread(String name) {
        super(name); // name thread
    }

    public void run(){
        System.out.println(getName() + " starting.");
        try {
            for(int count=0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println("In " + getName() +
                        ", count is " + count);
            }
        }
        catch(InterruptedException exc) {
            System.out.println(getName() + " interrupted.");
        }
        System.out.println(getName() + " terminating.");
    }

    public static MyThread createAndStart(String name) {
        MyThread myThrd = new MyThread(name);
        myThrd.start();
        return myThrd;
    }
}