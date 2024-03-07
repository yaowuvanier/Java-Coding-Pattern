/**
 * @author Yao Wu~
 * @version 1.0
 */
public class LinkedListNode {
    public int data;
    public LinkedListNode next;
    // Constructor will be used to make a LinkedListNode type object
    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
    public void setNext(LinkedListNode next) {
        this.next = next;
    }
}
