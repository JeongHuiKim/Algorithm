package me.jeonghui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BRACKETS2 {

    public static Stack<Character> stack;

    public static void main(String[] args) throws Exception{

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(in.readLine());

        for(int t = 0 ; t < testCase ; t++){

            char[] inputs = in.readLine().toCharArray();

            stack = new Stack<>();

            for(int i = 0 ; i < inputs.length ; i++) {
                if(stack.isEmpty() || check(inputs[i])) stack.push(inputs[i]);
                else stack.pop();
            }

            sb.append(stack.isEmpty() ? "YES\n" : "NO\n");
        }

        System.out.println(sb);
    }

    public static boolean check(char input) {

        if((input == '}' && stack.peek() == '{') || (input == ']' && stack.peek() == '[') || (input == ')' && stack.peek() == '(')) {
            return false;
        }

        return true;
    }
}
