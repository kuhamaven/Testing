import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Stack;

public class ClassExcercises {

    @Test
    public void test001_addingFuelShouldModifyFuelValue(){
        /*
        Usando un Stack y una Queue, verifique si una palabra es capicua.
         */

        String possibleCapicua = "neuquen";

        Stack<Character> stack = new Stack<>();
        ArrayDeque<Character> queue = new ArrayDeque<>();

        for (int i = 0; i < possibleCapicua.length(); i++){
            stack.push(possibleCapicua.charAt(i));
            queue.add(possibleCapicua.charAt(i));
        }

        while(!stack.isEmpty()){
            if(!stack.pop().equals(queue.pop())) throw new RuntimeException("Not capicua");
        }

    }


    @Test
    public void test002(){
        /*
            1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
            Resultado: ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
         */

        String input = "1+2)*3-4)*5-6)))";
        String a = "";
        String b = "";
        String c = "";

        Stack<String> stackNumbers = new Stack<>();
        Stack<Character> stackSymbols = new Stack<>();

        for (int i = 0; i < input.length(); i++){
            switch (input.charAt(i)){
                case '*':
                case '+':
                case '-':
                case '/':
                    stackSymbols.push(input.charAt(i));
                    break;
                case ')':
                    a = stackNumbers.pop();
                    b = stackSymbols.pop().toString();
                    c = stackNumbers.pop();
                    stackNumbers.push("("+c+b+a+")");
                    break;
                default:
                    stackNumbers.push(input.charAt(i)+"");
                    break;
            }


        }

    }

    @Test
    public void test004(){

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
