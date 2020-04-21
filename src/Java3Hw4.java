public class Java3Hw4 {
    private static char[] chars = {'A', 'B', 'C'};
    private static char currentChar = chars[2];
    private static Object lock = new Object();

    public static void main(String[] args) {
        new Thread(() -> printChar(chars[0], chars[2])).start();
        new Thread(() -> printChar(chars[1], chars[0])).start();
        new Thread(() -> printChar(chars[2], chars[1])).start();
    }

       public static void printChar(char printingChar, char previousChar) {
        synchronized (lock) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentChar != previousChar)
                        lock.wait();
                    System.out.print(printingChar);
                    currentChar = printingChar;
                    lock.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
