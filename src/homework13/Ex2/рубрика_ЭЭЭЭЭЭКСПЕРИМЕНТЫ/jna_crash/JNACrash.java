
/**
 * @author Elena Chinarina
 *
 **/

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

public class JNACrash {

    public interface CLibrary extends Library {
        CLibrary INSTANCE = Native.load(
                Platform.isWindows() ? "msvcrt" : "c",
                CLibrary.class
        );

        void abort();
        int raise(int sig);
    }

    // Константы сигналов
    public static final int SIGSEGV = 11; // Segmentation fault
    public static final int SIGABRT = 6; // Abort
    public static final int SIGFPE = 8; // Floating point exception

    public static void testFinallyNotExecuted(Runnable crashMethod, String testName) {
        System.out.println("\n=== " + testName + " ===");
        try {
            System.out.println("In try block before crash");
            crashMethod.run();
            System.out.println("This string will not be displayed");
        } catch (Throwable t) {
            System.out.println("In catch block: " + t);
        } finally {
            System.out.println("=== FINALLY BLOCK WILL NOT BE REACHED ===");
        }
    }

    public static void main(String[] args) {
        System.out.println("Demo with JNA\n");

        System.out.println("Choose one for demo:");
        System.out.println("1 - abort()");
        System.out.println("2 - Segmentation fault");
        System.out.print("Choice: ");

        try {
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    testFinallyNotExecuted(() -> {
                        System.out.println("Calling abort()...");
                        CLibrary.INSTANCE.abort();
                    }, "JNA Abort");
                    break;

                case 2:
                    testFinallyNotExecuted(() -> {
                        System.out.println("Calling segmentation fault using raise(SIGSEGV)...");
                        CLibrary.INSTANCE.raise(SIGSEGV);
                    }, "JNA SIGSEGV");
                    break;

                default:
                    System.out.println("Invalid input");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
