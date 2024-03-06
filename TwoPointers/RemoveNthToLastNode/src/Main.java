import java.util.LinkedList;

/**
 * @author Yao Wu~
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {

        int[][] inputs = {
                {23, 89, 10, 5, 67, 39, 70,28},
                {34, 53, 6, 95, 38, 28, 17, 63, 16, 76},
                {288, 224, 275, 390, 4, 383, 330, 60, 193},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {69, 8, 49, 106, 116, 112, 104, 129, 39, 14, 27, 12}
        };

        for (int i = 0; i < inputs.length; i++) {

        }

    }

      public static LinkedListNode removeNthLastNode(LinkedListNode head, int n) {
        LinkedListNode right = head;
        LinkedListNode left = head;

        for (int i = 0; i < n; i++) {
            right = right.getNext();
        }

        if (right == null) {
            return head.getNext();
        }

        while (right.getNext() != null) {
            right = right.getNext();
            left = left.getNext();
        }

        left.setNext(left.getNext().getNext());
        return head;
    }

}