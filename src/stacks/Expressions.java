package stacks;

import java.util.*;

public class Expressions {

    static Set<Character> operatorSet;

    public static void main(String[] args) {
        operatorSet = new HashSet<>();
        operatorSet.add('+');
        operatorSet.add('-');
        operatorSet.add('*');
        operatorSet.add('/');

//        System.out.println(isHigherPriority('-', '*'));
        String infixExp = "((a+b)-c)*d";
        String infixExp1 = "((9+6)-5)*3";
        String infixExp2 = "a+b-c*d";
        String infixExp3 = "a+b";
        System.out.println(convertInfixToPostfix(infixExp1));
        evaluatePostfix(convertInfixToPostfix(infixExp1));
    }

    public static boolean isHigherPriority(char op1, char op2){
        Set<Character> higherPriority = new HashSet<>();
        higherPriority.add('*');
        higherPriority.add('/');
        Set<Character> lowerPriority = new HashSet<>();
        lowerPriority.add('+');
        lowerPriority.add('-');

        if(!operatorSet.contains(op1) && operatorSet.contains(op2)){
            return false;
        }

        if(operatorSet.contains(op1) && !operatorSet.contains(op2)){
            return true;
        }

        if(higherPriority.contains(op1) && lowerPriority.contains(op2)){
            return true;
        }
//        else if (higherPriority.contains(op2) && lowerPriority.contains(op1)) {
//            return false;
//        }
        else if (higherPriority.contains(op1) && higherPriority.contains(op2)) {
            return true;
        }
        else if(lowerPriority.contains(op1) && lowerPriority.contains(op2)){
            return true;
        }
        return false;
    }

    //Postfix also known as reverse-polish notation
    public static String convertInfixToPostfix(String infixExp){
        StringBuilder postfixExp = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for (int i=0; i<infixExp.length(); i++) {
            char ele = infixExp.charAt(i);

            // If the scanned character is an '(',
            // push it to the stack.
            if(ele == '('){
                st.add(ele);
            }

            //  If the scanned character is an ')',
            // pop and output from the stack
            // until an '(' is encountered.
            else if(ele == ')'){
                while (st.peek() != '('){
                   char ch = st.pop();
                    postfixExp.append(ch);
                }
            }

            // an operator is encountered
            else if(operatorSet.contains(ele)){
                if(st.isEmpty()){
                    st.add(ele);
                }
                else {
                    if(isHigherPriority(ele, st.peek())){
                        st.add(ele);
                    }
                    else {
                        while (isHigherPriority(ele, st.peek())){
                            char ch = st.pop();
                            postfixExp.append(ch);
                        }
                    }
                }
            }

            // If the scanned character is an
            // operand, add it to output.
            else {
                postfixExp.append(ele);
            }
        }
        while (!st.isEmpty()){
            char ch = st.pop();
            if(ch == '(' || ch == ')'){
                continue;
            }
            postfixExp.append(ch);
        }

        return postfixExp.toString();
    }

    public static void evaluatePostfix(String pfx){

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < pfx.length(); i++) {
            char ele = pfx.charAt(i);
            if(operatorSet.contains(ele)){
                int b = st.pop();
                int a = st.pop();

                int res = evaluate(a, b, ele);
                st.add(res);
            }
            else {
                st.add(ele - '0');
            }
        }
        System.out.println(st.peek());
    }

    private static int evaluate(int a, int b, char ele) {
        return switch (ele) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            default -> 0;
        };

    }
}
