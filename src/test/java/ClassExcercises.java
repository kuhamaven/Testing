import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ClassExcercises {

    @Test
    public void excercise001_stackShouldIdentifyLiterals(){
        Assert.assertTrue(isBalanced("{}"));
        Assert.assertFalse(isBalanced("{}]"));
        Assert.assertTrue(isBalanced("{abc}"));
    }

    private boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();
        char[] chars = input.toCharArray();
        for(char c: chars) {
            switch (c) {
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case '}':
                    if(stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if(stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }

    @Test
    public void excercise002_isPalindrome(){
        Assert.assertTrue(isPalindrome("anana"));
        Assert.assertFalse(isPalindrome("ananaf"));
    }

    private boolean isPalindrome(String input){
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new ArrayDeque<>();

        char[] chars = input.toCharArray();
        for(char c: chars) {
            stack.push(c);
            queue.add(c);
        }

        while (!stack.isEmpty()){
            if(!stack.pop().equals(queue.remove())) return false;
        }

        return true;
    }
}
