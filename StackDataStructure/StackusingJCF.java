package StackDataStructure;
import java.util.Stack;

public class StackusingJCF {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        pushAtBottom(stack, 0);

        String str = "abc";
        System.out.println(reverseString(str));
        System.out.println(stack);
        reverseStack(stack);
        System.out.println(stack);
    }
    public static void pushAtBottom(Stack<Integer> stack,int data){
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }

        int top = stack.pop();
        pushAtBottom(stack, data);
        stack.push(top);
    }
    public static String reverseString(String str){
        Stack<Character> stackCharacters = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stackCharacters.push(str.charAt(i));
        }
        StringBuilder result = new StringBuilder("");
        while (!stackCharacters.isEmpty()) {
            char current = stackCharacters.pop();
            result.append(current);
        }
        return result.toString(); 
    }
    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        
        int top = stack.pop();
        
        reverseStack(stack);
        
        pushAtBottom(stack, top);
    }
}
