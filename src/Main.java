public class Main {
    public static void main(String[] args) {
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

        int[] numer = { 4, 8, 16, 32, 64, 128, 256, 512 };
        int[] denom = { 2, 0, 4, 4, 0, 8 };
        try { // outer try
            for(int i=0; i<numer.length; i++) {
                try { // nested try
                    System.out.println(numer[i] + " / " +
                            denom[i] + " is " +
                            numer[i]/denom[i]);
                }
                catch (ArithmeticException exc) {
                    // catch the exception
                    System.out.println("Can't divide by Zero!");
                }
                catch (Throwable exc){
                    System.out.println("Caught in nested try");
                }
            }
        } catch (ArrayIndexOutOfBoundsException exc) {
            // catch the exception
            System.out.println("No matching element found.");
            System.out.println("Fatal error - program terminated.");
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