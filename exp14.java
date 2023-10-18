// remove k string
// Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

import java.util.Stack;
public class exp14 {
    public static String removeKDigits(String num, int k) {
        int len = num.length();
        
        // If k is equal to or greater than the length of the number, return "0".
        if (k >= len) {
            return "0";
        }
        
        // Create a stack to hold the resulting digits
        Stack<Character> stack = new Stack<>();
        
        for (char digit : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        
        // If there are still remaining 'k' to remove, pop the last 'k' digits from the stack
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        // Build the resulting string from the stack
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        
        // Remove leading zeros
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        String num = "10";
        int k = 2;
        String result = removeKDigits(num, k);
        System.out.println("Result after removing " + k + " digits: " + result);
    }
}
