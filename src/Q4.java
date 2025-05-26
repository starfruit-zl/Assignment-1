/** A class that responds to the parameters defined in Question 4:
 * 1.3.37- Josephus problem. In the Josephus problem from antiquity, N people are in dire straits
and agree to the following strategy to reduce the population. They arrange them-selves in a circle
(at positions numbered from 0 to N–1) and proceed around the circle, eliminating every Mth
person until only one person is left. Legend has it that Josephus figured out where to sit to avoid
being eliminated. Write a Queue client Josephus program (in java) that takes N and M from the
command line and prints out the order in which people are eliminated (and thus would show
Josephus where to sit in the circle).
% java Josephus 7 2 1 3 5 0 4 2 6
 */
public class Q4 {

    /** Null constructor to initialize a null Queue block for the private data queue.
     */
    Q4(){
        queue = new Q4_Queue<Integer>(null, null);
    }

    /**Defines a circular progression for a set of people queued 0 to N, and removes each Mth person.
     * 
     * @param N The number of elements in the Josephus problem.
     * @param M The skips before a person is selected.
     */
    public void Josephus(int N, int M){
        //defining Josephus queue.
        queue.first = new Node<Integer>(0, null);
        Node<Integer> fillerNode = queue.first;
        for (int i = 1; i < N; i++){
            fillerNode.next = new Node<Integer>(i, null);
            fillerNode = fillerNode.next;
        }
        queue.last = fillerNode;
        //testing Josephus position
        System.out.print("\n% java Josephus ");
        System.out.print(N);
        System.out.print(" ");
        System.out.print(M);
        System.out.print(" ");
        while (!(queue.isEmpty())){
            for(int i = 0; i < M - 1; i++)
               queue.enqueue(queue.dequeue());
            System.out.print(queue.dequeue());
        }
    }   

    /**Template class for the type Item to define a queue data structure of items.
     */
    public class Q4_Queue<Item>{

        /**default constructor for the Queue data structure
         * 
         * @param p0Node first node that is at front of queue
         * @param pLastNode last node that is at the rear of the queue
         */
        public Q4_Queue(Item p0Node, Item pLastNode){
            last = new Node<Item>(pLastNode, null);
            first = new Node<Item>(p0Node, last);
        }
        /** Checks if the queue is empty, and returns the appropriate bool value.*/
        public boolean isEmpty(){
            if (first == null) return true;
            else return false;
        }

        /** Adds a node to the end of the queue, at last.next, of data type Item.
         * @param in the type of item to be used in the node constructor.
         */
        public void enqueue(Item in){
            Node<Item> oldLast = last;
            last = new Node<Item>(in, null);
            if (isEmpty()) first = last;
            else oldLast.next = last;
        }
        /** Removes a node from the front of the queue, at private data front.
         * Reassigns the node front.next as front.
         * @return the item stored inside the first node
         */
        public Item dequeue(){
            Item oldFirst = first.item;
            first = first.next;
            if (isEmpty()) last = null;
            return oldFirst;
        }

        /**Private data nodes first and last, to define enqueue and dequeue methods */
        private Node<Item> first, last;
    }
    
    /**Private queue data to define the josephus method's data. */
    private Q4_Queue<Integer> queue;

}
