
public class assignment1_driver {
    public static void main(String[] args) throws Exception {
        //Question 1:
        Q1 testParse = new Q1("1+2)*3-4)*5-6))");
        System.out.println(testParse.fix());

        //Question 2:
        Q2_LinkedList<Integer> sequence = new Q2_LinkedList<Integer>(0);
        for (int i = 1; i < 10; i++){
            sequence.append(i);
        }
        sequence.print();
        System.out.println(' ');
        Q2<Integer> testRemove = new Q2<Integer>(sequence);
        testRemove.DeleteRange(1,6);
        sequence.print();

        //Question 3:
        Node<Integer> findMax = new Node<Integer>(5, null);
        Node<Integer> moveMax = findMax;
        for (int i = 1; i < 10; i++){
            if (i < 6 )moveMax.next = new Node<Integer>((i*5), null);
            else moveMax.next = new Node<Integer>(i*4, null);
        }
        Q3 testFindMax = new Q3(findMax);
        System.out.println(' ');
        System.out.println(testFindMax.max()); //expecting 36.

        //Question 4:
        Q4 joseph = new Q4();
        joseph.Josephus(7, 2);

        //Question 5:
    }
}