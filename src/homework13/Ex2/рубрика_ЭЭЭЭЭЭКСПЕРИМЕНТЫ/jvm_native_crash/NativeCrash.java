
/**
 * @author Elena Chinarina
 *
 **/

public class NativeCrash {

    static {
        // Загрузка нативной библиотеки
        try {
            System.loadLibrary("jvmcrash");
            System.out.println("Native library loaded");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Could not load native library: " + e.getMessage());
        }
    }

    // Объявление нативных методов
    public native void crashBySegfault();
    public native void crashByDivZero();
    public native void crashByAbort();
    public native void crashByStackOverflow();
    public native void crashByStackCorruption();
    public native void crashByIllegalInstruction();

    // Метод для демонстрации, что finally не выполнится
    public static void testFinallyNotExecuted(Runnable crashMethod, String testName) {
        System.out.println("\n=== " + testName + " ===");
        try {
            System.out.println("In try block before crash");
            crashMethod.run();
            System.out.println("This string will not be output");
        } catch (Throwable t) {
            System.out.println("In catch block: " + t.getClass().getSimpleName() + ": " + t.getMessage());
        } finally {
            System.out.println("FINALLY block will not be executed");
        }
        System.out.println("This string will not be output");
    }

    public static void main(String[] args) {
        NativeCrash nativeCrash = new NativeCrash();

        System.out.println("DEMO: finally will not be executed because of JVM crash\n");
        System.out.println("ACHTUNG! JVM will crash");
        System.out.println("Run each example individually\n");

        System.out.println("Choose one for demo:");
        System.out.println("1 - Segmentation Fault");
        System.out.println("2 - Division by Zero");
        System.out.println("3 - Abort");
        System.out.println("4 - Stack Overflow");
        System.out.println("5 - Stack Corruption");
        System.out.println("6 - Illegal Instruction");
        System.out.print("Choice: ");

        try {
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    testFinallyNotExecuted(() -> nativeCrash.crashBySegfault(), "Segmentation Fault");
                    break;
                case 2:
                    testFinallyNotExecuted(() -> nativeCrash.crashByDivZero(), "Division by Zero");
                    break;
                case 3:
                    testFinallyNotExecuted(() -> nativeCrash.crashByAbort(), "Abort()");
                    break;
                case 4:
                    testFinallyNotExecuted(() -> nativeCrash.crashByStackOverflow(), "Stack Overflow");
                    break;
                case 5:
                    testFinallyNotExecuted(() -> nativeCrash.crashByStackCorruption(), "Stack Corruption");
                    break;
                case 6:
                    testFinallyNotExecuted(() -> nativeCrash.crashByIllegalInstruction(), "Illegal Instruction");
                    break;
                default:
                    System.out.println("Invalid input");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
