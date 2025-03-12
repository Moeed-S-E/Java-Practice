package StackDataStructure;
import java.util.Stack;
public class NextGreaterElement {
    public static void main(String[] args) {    
        int arr[] = {4, 5, 2, 10, 8};
        int[] NGE = nextGreater(arr);

        for (int i = 0; i < NGE.length; i++) {
            System.out.print(NGE[i]+" ");
        }
        

        
        
    }
    public static int[] nextGreater(int[] arr) {
        int[] nextGreater = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            nextGreater[i] = -1;
        }
        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] < arr[i]) {
                int index = s.pop();
                nextGreater[index] = arr[i];
            }
            s.push(i);
        }
        

        return nextGreater;
    }
}
