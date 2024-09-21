
public class LinkedList {

    private Node head;  // Head of the linked list

    // Constructor to initialize an empty linked list
    public LinkedList() {
        this.head = null;
    }

    // Method to insert a new node at the end
    public void insertAtEnd(String data, int pos) {
        Node newest = new Node(data, pos);
        if (head == null)
            head = newest;
        else{
            Node current = this.head;
            while (current.next != null){
                current = current.next;
            }
            current.next = newest;
        }
    }

    // Method to update a specific position in the list
    public void updatePosition(int position, String data) {
        if (head == null)
            return;
        else{
            Node current = this.head;
            while (current.next != null){
                if (current.cellPosition == position){
                    break;
                }
                current = current.next;
            }

            current.data = data;
        }
    }

    // Method to get the value at a specific position
    public String getPositionValue(int position) {
        if (head == null)
            return null;
        else{
            Node current = this.head;
            while (current.next != null){
                if (current.cellPosition == position){
                    break;
                }
                current = current.next;
            }
            return current.data;
        }
    }

    // Method to display the Tic Tac Toe board
    public void displayBoard() {
        // TODO: To be implemented
        String divider = "-------------------------------";
        String rowTop = "|";
        String rowMid = "|";
        String rowBot = "|";
        String xTop = " \\‾\\/‾/  |";
        String xMid = "  )  (   |";
        String xBot = " /_/\\_\\  |";
        String oTop = "  /‾‾‾\\  |";
        String oMid = " | ( ) | |";
        String oBot = "  \\___/  |";
        String blank = "         |";
        for (int i = 1; i < 10; i++){
            if (i == 4 || i == 7 ){
                System.out.println(divider);
                System.out.println(rowTop);
                System.out.println(rowMid);
                System.out.println(rowBot);
                rowTop = "|";
                rowMid = "|";
                rowBot = "|";
            }
            if (getPositionValue(i).equals("X")){
                rowTop += xTop;
                rowMid += xMid;
                rowBot += xBot;
            }
            else if (getPositionValue(i).equals("O")){
                rowTop += oTop;
                rowMid += oMid;
                rowBot += oBot;
            }
            else{
                rowTop += blank;
                rowMid += "    "+i+"    |";
                rowBot += blank;
            }
        }
        System.out.println(divider);
        System.out.println(rowTop);
        System.out.println(rowMid);
        System.out.println(rowBot);
        System.out.println(divider);
    }

    // Method to check for a win
    public boolean checkWinCondition() {
        // TODO: To be implemented
        if(!getPositionValue(1).isEmpty()){
            if(isWin(1,2,3) || isWin(1,5,9) || isWin(1,4,7)){
                return true;
            }
        }
        if(!getPositionValue(2).isEmpty()){
            if(isWin(2,5,8)){
                return true;
            }
        }
        if(!getPositionValue(3).isEmpty()){
            if (isWin(3,5,7) || isWin(3,6,9)){
                return true;
            }
        }
        if(!getPositionValue(4).isEmpty()){
            if(isWin(4,5,6)){
                return true;
            }
        }
        if(!getPositionValue(7).isEmpty()){
            if(isWin(7,8,9)){
                return true;
            }
        }
        return false;
    }
    private boolean isWin(int x, int y, int z){
        return getPositionValue(x).equals(getPositionValue(y)) && getPositionValue(x).equals(getPositionValue(z));
    }

    // Method to check if the board is full (for draw condition)
    public boolean isBoardFull() {
        if (head == null)
            return false;
        else{
            Node current = this.head;
            while (current.next != null){
                if (current.data.isEmpty()){
                    return false;
                }
                current = current.next;
            }
        }
        return true;
    }

    // Method to reset the board
    public void resetBoard() {
        if (head == null)
            return;
        else{
            Node current = this.head;
            while (current.next != null){
               current.data = "";
               current = current.next;
            }
            current.data = "";
        }
    }
}
