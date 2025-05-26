/**A class to faciliatate the management of nodes as arranged in a linked-list.
 * It provides generic template functionality.
 */
public class Q2_LinkedList<Item> {
    /**A default constructor to initialize the linked list node management class.
     * @param item1 the templated item that determines the type of the linked list and the value
     * stored at its header.
     */
    public Q2_LinkedList(Item item1){
        head = new Node<Item>(item1, null);
    }
    /**A method that changes the next pointer of the item at the end of the linked-list to the input item.
     * Constructing a new node of the given type.
     * @param itemNext Constructs a new node of the template type input and store the value in a node at
     * the end of the linked array.
     */
    public void append(Item itemNext){
        Node<Item> appended = head;
        while (appended.next != null){
            appended = appended.next;
        }
        appended.next = new Node<Item>(itemNext, null);
    }

    /**A method that changes the last pointer node to null to remove it from the list.
     * If the header is the only node, it sets the head to null.
     */
    public Item peel(){
        Node<Item> peeled = head, takeOff;
        if (peeled.next == null) head = null;
        else{
            while ((peeled.next).next != null){
                peeled = peeled.next;
            }
            takeOff = peeled.next;
            peeled.next = null;
            return takeOff.item;
        }
        return null;
    }

    /**A method that prints the full contents of the linked-list for all its defined values.
     */
    public void print(){
        Node<Item> printed = head;
        while (printed.next != null){
            System.out.print(printed.item);
            printed = printed.next;
        }
    }

    /** A private variable to store the head node of the linked-list.
     */
    Node<Item> head;
}