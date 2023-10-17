public class Test {
    private static boolean debug = true;

    public static void main(String[] args) {
        //TODO
    }

    public static void print(String str) {
        if(debug) 
            System.out.println(str);
    }

    /**
     * Swaps the test mode to do test cases or not.
     * @return value of debug
     */
    public static boolean toggleDebug() {
        debug = !debug;
        return debug;
    }
}
