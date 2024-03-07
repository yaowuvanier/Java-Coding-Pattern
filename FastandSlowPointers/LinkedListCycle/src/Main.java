/**
 * @author Yao Wu~
 * @version 1.0
 */


/**
 * Check whether or not a linked list contains a cycle.
 * If a cycle exists, return TRUE. Otherwise, return FALSE.
 * The cycle means that at least one node can be reached again by traversing the next pointer.
 * */
public class Main {
    public static void main(String[] args) {

    /* test cases: (Note: The first input of the test case includes an array representing the contents of a linked list.
    The second input represents the index of the node to which the tail pointer is pointing. It will be −1, in case it is pointing to NULL.
    The second input is not passed as a parameter in the function because it is just to represent the cycle in the linked list.)
    *
    [2,4,6,8,10], 1;          [1,3,5,7,9],  -1;    [1,2,3,4,5], 1;    [0,2,3,5,6], -1;   [3,6,9,10,11], -1
    */
        LinkedList<Integer> listCycle = new LinkedList<>();
        int[] arrC = {2, 4, 6, 8, 10};
        listCycle.createLinkedList(arrC);
        LinkedListNode last = listCycle.getNode(listCycle.head,arrC.length-1);
        last.setNext(listCycle.getNode(listCycle.head,1));

        LinkedList<Integer> list = new LinkedList<>();
        int[] arr = {1,3,5,7,9};
        list.createLinkedList(arr);


        System.out.println("[2,4,6,8,10], 1 exist cycle?: " + isExistCycle(listCycle));
        System.out.println("[1,3,5,7,9], -1 exist cycle?: " + isExistCycle(list));

    }
    public static boolean isExistCycle(LinkedList list){

        if (list.head == null) {
            return false;
        }

        LinkedListNode fast, slow;
        slow = list.head;
        fast = list.head.next;

        while ((fast != slow) && (fast != null) && (fast.next != null)){
            slow = slow.next;
            if(fast.next != null )
                fast = fast.next.next;
        }
        return fast == slow;
    }
}
    /*
        while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast) {
                    return true;
                }
            }

            return false;
        }
    * */