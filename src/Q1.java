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
    A null constructor that defines a private string to be processed by requesting
    user input.
     */
    public Q1(){
        str = JOptionPane.showInputDialog("Input a sequence of operations with only \"(\".");
    }

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
        String modifiedStr = str;
        int count = 0;

        for (int i = 0; i < str.length(); i++)
            if (')' == str.charAt(i)) count++;

        int[] indexLast = new int [count];
        int tierEval = 0;
        //logic: if another encountered following, increase tier.
        for (int i = 0; i < modifiedStr.length(); i++){
            //logic: track the instances for each tier of brackets. Place at the position where the index - the instances since the last tiered bracket.
            //       if the character at i is a star symbol, place the completing bracket to its right.
            if (')' == modifiedStr.charAt(i)){
                if ('*' == modifiedStr.charAt(i-indexLast[tierEval])) modifiedStr = modifiedStr.substring(0, i + 1 - indexLast[tierEval]) + "(" + modifiedStr.substring(i + 1 - indexLast[tierEval], modifiedStr.length());
                else modifiedStr = modifiedStr.substring(0, i - indexLast[tierEval]) + "(" + modifiedStr.substring(i - indexLast[tierEval], modifiedStr.length());
                indexLast[tierEval] = 0;
                tierEval++;
                i++;
            }
            else{
                for(int j = 0; j < count; j++)
                    indexLast[j] += 1;
                tierEval = 0;
            }
        }
        
        return modifiedStr;
    }

    /**
    A private variable to store the string to be parsed for the input.
     */
    private String str;
}
