
/** A class that responds to the parameters defined in question 3.
 * 1.3.27- Write a method max() that takes a reference to the first node in a linked list as argument
 * and returns the value of the maximum key in the list. Assume that all keys are positive integers,
 * and return 0 if the list is empty.
 */
public class Q3{
    
    public Q3(Node<Integer> input){
        headNode = input;
    }

    public Integer max(){
        Node<Integer> nextNode = headNode;
        Integer maxLead = nextNode.item, maxChallenger;
        if (headNode == null) return 0;
        while (nextNode.next != null){
            nextNode = nextNode.next;
            maxChallenger = nextNode.item;
            if (maxLead < maxChallenger) maxLead = maxChallenger;
        }

        return maxLead;
    }

    private Node<Integer> headNode;
}