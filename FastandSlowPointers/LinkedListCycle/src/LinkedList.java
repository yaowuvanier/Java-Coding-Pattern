/**
 * @author Yao Wu~
 * @version 1.0
 */
import java.util.*;
// Template for the linked list
class LinkedList<T> {
    public LinkedListNode head;
    // constructor will be used to make a LinkedList type object
    public LinkedList() {
        this.head = null;
    }
    // insertNodeAtHead method will insert a LinkedListNode at head
    // of a linked list.
    public void insertNodeAtHead(LinkedListNode node) {
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }
    // createLinkedList method will create the linked list using the
    // given integer array with the help of InsertAthead method.
    public LinkedListNode createLinkedList(int[] lst) {
        LinkedListNode head = null; // Initialize the head of the linked list
        for (int i = lst.length - 1; i >= 0; i--) {
            LinkedListNode newNode = new LinkedListNode(lst[i]);
            if (head == null) {
                head = newNode; // If the list is empty, set the new node as the head
            } else {
                newNode.next = head; // Set the next pointer of the new node to the current head
                head = newNode; // Update the head to the new node
            }
        }
        return head; // Return the head of the linked list
    }


    // returns the node at the specified position(index) of the linked list
    public static LinkedListNode getNode(LinkedListNode head, int pos){
        LinkedListNode ptr = head;
        if (pos != -1){
            int p = 0;

            while (p < pos){
                ptr = ptr.next;
                p += 1;
            }

            return ptr;
        }
        return ptr;
    }

    // returns the number of nodes in the linked list
    public static int getLength(LinkedListNode head)
    {
        LinkedListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }


}