import javax.swing.JOptionPane;

/**
    A class to respond to the following parameters: 
    1.3.9- Write a program (in java) that takes from standard input an expression without left
    parentheses and prints the equivalent infix expression with the parentheses inserted. For example,
    given the input:
    1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
    your program should print
    ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) )
     */
public class Q1 {
    /**
     * 
     * A constructor that defines a private string to be processed by recieving a string as input.
     * @param str1 the string input to be processed.
     */
    public Q1(String str1){
        str = str1;
    }

    /**
     * A method named fix that adds the brackets ( where they are missing when compared to ).
     * @return the string with the missing ( added.
     */
    public String fix() {

        Q1_Stack<String> terms = new Q1_Stack<String>(null);
        Q1_Stack<String> operators = new Q1_Stack<String>(null);
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '(') ;
            else if (str.charAt(i) == '+' || str.charAt(i) == '-') operators.push(String.valueOf(str.charAt(i)));
            else if (str.charAt(i) == '*' || str.charAt(i) == '/') operators.push(String.valueOf(str.charAt(i)));
            else if (str.charAt(i) == ')'){
                String operator = operators.pop();
                String term2 = terms.pop(), term1 = terms.pop();
                terms.push("("+term1+operator+term2+")");
            }
            else terms.push(String.valueOf(str.charAt(i)));
        }
        
        return terms.pop();
    }

    public class Q1_Stack<Item>{
        public Q1_Stack(Item item1){
            head = new Node<Item>(item1, null);
        }

        public void push(Item item1){
            Node<Item> oldHead = head;
            head = new Node<Item>(item1, oldHead);
        }

        public Item pop(){
            Item popItem = head.item;
            head = head.next;
            return popItem;
        }

        private Node<Item> head;
    }

    /**
    A private variable to store the string to be parsed for the input.
     */
    private String str;
}
