/**
 * @author Yao Wu~
 * @version 1.0
 */
public class LinkedListNode {
    private int nodeItem;
    private LinkedListNode next;

    public LinkedListNode(int nodeItem) {
        this.nodeItem = nodeItem;
        this.next = null;
    }

    public int getNodeItem() {
        return nodeItem;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public void setNodeItem(int nodeItem) {
        this.nodeItem = nodeItem;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }
}
