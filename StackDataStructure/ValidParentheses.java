package StackDataStructure;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String str = "([{)]}";

        System.out.println(isValid(str));
        String expr1 = "((a + b))"; 
        String expr2 = "(a + (b + c))";

        System.out.println(isDuplicate(expr1));
        System.out.println(isDuplicate(expr2));

    }
    public static boolean isValid(String str){
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
        //opening    
        if (ch == '(' || ch == '{' || ch == '[') {
            s.push(ch);
        }else{
            //closing
            if (s.isEmpty()) {
                return false;
            }
            if ((s.peek() == '(' && ch == ')') || (s.peek() == '{' && ch == '}') || (s.peek() == '[' && ch == ']')) {
                s.pop();
            }else{
                return false;
            }
        }
        }

        if (s.isEmpty()) {
            return true;
        }else{
            return false;
        }
    }
    public static boolean isDuplicate(String str){
        Stack<Character> s = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == ')') {
                if (s.isEmpty() || s.peek() == '(') {
                    return true;
                }
                while (!s.isEmpty() && s.peek() != '(') {
                    s.pop();
                }
                s.pop();
            }else{
                s.push(ch);
            }
        }
        return false;
    }
}
