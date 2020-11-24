package leetcode.blindcurated75;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Num20_ValidParentheses {

    // '(' = 40
    // '{' = 123
    // '[' = 91
    // ')' = 41
    // '}' = 125
    // ']' = 93
    public boolean isValid(String s) {

        Stack<Integer> leftStack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            int code = (int) c;
            int rightCode = ")}]".indexOf(c);
            if(rightCode!=-1) {
                if(leftStack.isEmpty()) {
                    return false; // missing left
                } else {
                    if( leftStack.peek() == rightCode) {
                        leftStack.pop(); // close immediately
                    } else  {
                        return false; // not close
                    }
                }
            } else {
                switch (c) {
                    case 40: // (
                        leftStack.push(0);
                        continue;
                    case 123: // {
                        leftStack.push(1);
                        continue;
                    case 91: // [
                        leftStack.push(2);
                        continue;
                }
            }
        }

        return leftStack.isEmpty();
    }


}
