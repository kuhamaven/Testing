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

    private void insertAfter(Node first, Node second){
        if(first == null || second == null) return;

        Node aux = first.next;
        first.next = second;
        second.next = aux;
    }

    private class Node<E>{
        E item;
        Node next;
    }

    @Test
    public void addParenthesis(){
        String input =  "1+2)*3-4)*5-6)))";
        // ((1 + 2 ) * ((3 - 4) * (5 - 6 ) ) )

        Stack<Character> stack = new Stack<>();

        char[] chars = input.toCharArray();
        for(char c: chars) {
            stack.push(c);
        }

        String result = "";
        int parenthesisCount = 0;

        while(!stack.isEmpty()){
            char c = stack.pop();

            switch (c){
                case ')':
                    parenthesisCount += 1;
                    result = c + result;
                    break;
                case '-':
                case '+': result = c + result;
                    c = stack.pop();
                    result = "(" + c + result;
                    parenthesisCount -= 1;
                    break;
                default: result = c + result;
            }
        }

        //for (int i = 0; i<parenthesisCount; i++) result = "(" + result;

        System.out.println(result);
    }
}
