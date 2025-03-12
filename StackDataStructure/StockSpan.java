package StackDataStructure;
import java.util.Stack;

public class StockSpan {
    
    public static void main(String[] args) {    
        int[] stocks = {100,80,60,70,60,85,100};
        int[] span = new int[stocks.length];    
    
        stockSpan(stocks,span);
    
        for (int i = 0; i < span.length; i++) {
            System.out.println(span[i]+" ");
        }
    }
    public static void stockSpan(int[] stocks,int[] span){
        Stack<Integer> stack = new Stack<>();
        span[0] = 1;
        stack.push(0 );

        for (int i = 1; i < stocks.length; i++) {
            int curr = stocks[i];
            while (!stack.isEmpty() && curr >  stocks[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                span[i] = i+1;
            }else{
                int prevHigh = stack.peek();
                span[i] = i - prevHigh;
            }

            stack.push(i); 

        }




    }
}
