public class assignment1_driver {
    public static void main(String[] args) throws Exception {
        Q1 testParse = new Q1("1+2)*3-4)*5-6))");
        System.out.println(testParse.fix());

        Q2_LinkedList<Integer> sequence = new Q2_LinkedList<Integer>(0);
        for (int i = 1; i < 10; i++){
            sequence.append(i);
        }
        sequence.print();
        System.out.println(' ');
        Q2<Integer> testRemove = new Q2<Integer>(sequence);
        testRemove.DeleteRange(0,3);
        sequence.print();
    }
}
