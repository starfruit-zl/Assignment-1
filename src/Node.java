/** A class that defines the node sub-component to build the linked-list data structure.
 *  It is public in order to facilitate the construction of the linked-list.
 */
public class Node<Item> {
        /** The default constructor for the class node for a template configuration.
         * @param item1 The data-type that defines the given node, of type defined in the template.
         * @param next1 The pointer to the next node of the linked-list.
         */
        public Node(Item item1, Node<Item> next1){
            item = item1;
            next = next1;
        }

        /** A public data-type that defines the data stored in the current node.
         */
        Item item;
        /** A public data-type that defines the pointed to the next node in the linked-list.
         */
        Node<Item> next;
    }