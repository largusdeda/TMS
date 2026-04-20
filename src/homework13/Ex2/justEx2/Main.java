package homework13.Ex2.justEx2;

/**
 * @author Elena Chinarina
 *
 **/

public class Main {
    public static void systemExitMethod() {
        try {
            System.out.println("В блоке try");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("В блоке сatch");
        } finally {
            System.out.println("В блоке finally");
        }
    }

    public static void whileTrueMethod() {
        try {
            System.out.println("В блоке try");
            while(true) {
                // бесконечный цикл
            }
        } catch (Exception e) {
            System.out.println("В блоке сatch");
        } finally {
            System.out.println("В блоке finally");
        }
    }


    public static void main(String[] args) {
        System.out.println("1 способ");
        systemExitMethod();

        System.out.println("2 способ"); // нужно закомментировать первый способ
        whileTrueMethod();

    }
}
