

/** A class to respond to the following parameters:
 * Write a method DeleteRange(int start, int end) that deletes all elements from the start to the end
 * positions (inclusive) in a singly linked list, if those indices exist. If start or end is out of bounds
 * or invalid (e.g., start>end), the method should do nothing.
*/
public class Q2<Item> {
    public Q2(Q2_LinkedList<Item> input){
        toBeParsed = input;
    }

/** A method to remove a specific range of items from a linked list.
 * @param start The starting index position.
 * @param end   The finishing index position.
 */
    public void DeleteRange(int start, int end){
        if (start < end && start != end){
            int count = 0;
            Node<Item> current = toBeParsed.head, st = null;
            if (start == 0) {
                while (current.next != null){
                    current = current.next;
                    if (count == end){
                    toBeParsed.head = current;
                    break;
                    }
                    count++;
                }
            }
            else while(current.next != null){
                    if(count + 1 == start) st = current;
                    else if(count == end){
                        st.next = current.next;
                        break;
                    }
                    count++;
                }
        }
    }
    
    private Q2_LinkedList<Item> toBeParsed;
}
