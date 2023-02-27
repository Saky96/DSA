package stacks;

import java.util.Stack;

public class BracketProblems {
    public static void main(String[] args) {
        String exp = "{{[]}}";
        String exp2 = "][]][";
        System.out.println(isBalancedBraces(exp2));
    }

    static Boolean isOpening(char ch){
        return ch == '(' || ch == '{' || ch == '[' || ch == '<';
    }

    static Boolean isMatching(char op, char cl){
        return (op == '(' && cl == ')') || (op == '{' && cl == '}') || (op == '[' && cl == ']') || (op == '<' && cl == '>');
    }

    public static Boolean isBalancedBraces(String exp){
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if(isOpening(ch)){
                st.add(ch);
            }
            else {
                if(st.isEmpty()){
                    return false;
                } else if (!isMatching(st.peek(), ch)) {
                    return false;
                }
                else {
                    st.pop();
                }
            }
        }

        return st.isEmpty();
    }
}
