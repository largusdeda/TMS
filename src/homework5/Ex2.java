package homework5;

/**
 * @author Elena Chinarina
 *
 **/

public class Ex2 {
    public static void main(String[] args) {
        String[][] board = new String[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = ((i + j) % 2 == 0) ? "\u25a0" : "\u25a1";
            }
        }

        System.out.println("  a b c d e f g h");
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(8 - i);
        }
        System.out.println("  a b c d e f g h");
    }
}
