import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args)
            throws IOException {

        TestThread tt1 = new TestThread("#First");
        TestThread tt2 = new TestThread("#Second");
        Thread t1 = new Thread(tt1);
        Thread t2 = new Thread(tt2);
        t1.start();
        t2.start();


        String str = """
                Hello! Вау!
                    И так могу
                    и так могу
                Привет!""";
        var array = new int[10];
        var result = "123";
        int what = 6;
        //System.out.print(what);

        Integer i1 = 1000;
        Integer i2 = 1000;
        int i3 = 1000;
        int i4 = 1000;

        System.out.println(i1 == i2);
        System.out.println(i1 == i3);
        System.out.println(i3 == i4);

        int i;
        FileInputStream fin = null;
        FileOutputStream fout = null;
        // The following code opens a file, reads characters until EOF
        // is encountered, and then closes the file via a finally block.
        try {
            fin = new FileInputStream("src/input.txt");
            fout = new FileOutputStream("src/output.txt");
            do {
                i = fin.read();
                if(i != -1)
                    fout.write(i);
            } while(i != -1);
        } catch(IOException exc) {
            System.out.println("I/O Error: " + exc);
        } finally {
            // Close file in all cases.
            try {
                if(fin != null) fin.close();
            } catch(IOException exc) {
                System.out.println("Error Closing File");
            }
            try {
                if(fout != null) fout.close();
            } catch(IOException exc) {
                System.out.println("Error Closing Output File");
            }
        }
    }

    static class TestThread implements Runnable{
        public static Integer counter = 0;
        String name;
        @Override
        public void run() {
            System.out.println("Thread " + name + " started.");
            synchronized (counter) {
                for (int i = 0; i < 10000; i++) {
                    counter++;
                }
                System.out.println("Result value - " + counter);
                counter = 0;
            }
            System.out.println("Thread " + name + " ended.");
        }

        public TestThread (String name){
            this.name = name;
        }
    }

    private static void printHello(String ... names){
        System.out.println("Hello!");
        for(String name : names)
            System.out.println("Hi " + name);
        System.out.println("Have a nice day, guys!");
    }

    private static void vararg(int number, int ...indices){
        System.out.println("Method 1 is called, with " + indices.length + " parameters");
    }
    private static void vararg(int ...indices){
        System.out.println("Method 2 is called, with " + indices.length + " parameters");
    }
}