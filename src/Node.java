
public class Node {
    String data;  // Could be 'X', 'O', or empty
    int cellPosition; // could be numbers 1 - 9
    Node next; // A reference (pointer) to the next node.

    // Constructor for a new node
    public Node(String data, int pos) {
        this.data = data;
        this.next = null;
        this.cellPosition = pos;
    }
}
