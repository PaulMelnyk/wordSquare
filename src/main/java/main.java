import error.InvalidStringForWordSquareException;

import java.io.IOException;

public class main {

    public static void main(String argv[]) throws IOException, InvalidStringForWordSquareException {
        Producer tester = new Producer();

        tester.getSquare(4, "eeeeddoonnnsssrv");
        System.out.println("-----------------");
        tester.getSquare(5, "aaaeeeefhhmoonssrrrrttttw");
        System.out.println("-----------------");
        tester.getSquare(7, "aaaaaaaaabbeeeeeeedddddggmmlloooonnssssrrrruvvyyy");
        System.out.println("-----------------");

    }
}