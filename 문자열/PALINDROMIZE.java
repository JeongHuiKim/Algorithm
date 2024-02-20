package me.jeonghui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PALINDROMIZE {

    public static int[] pi;
    public static int N;

    public static void main(String[] args) throws Exception{

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(in.readLine());

        for(int t = 0 ; t < testCase ; t++) {

            String input = in.readLine();
            StringBuilder sbb = new StringBuilder(input);

            char[] inputs = input.toCharArray();
            char[] reverses = sbb.reverse().toString().toCharArray();

            KMP(reverses);

            int answer = -1;
            int begin = 0;
            int matched = 0;

            while (begin < inputs.length) {
                if(matched < inputs.length && inputs[begin + matched] == reverses[matched]) {
                    ++matched;
                    if(begin + matched == inputs.length) {
                        answer = matched;
                        break;
                    }
                }
                else {
                    if(matched == 0) {
                        ++begin;
                    }
                    else {
                        begin += matched - pi[matched -1];
                        matched = pi[matched -1];
                    }
                }
            }

            sb.append(inputs.length * 2 - (answer == -1 ? 0 : answer)).append("\n");
        }

        System.out.println(sb);
    }

    public static void KMP(char[] input) {

        N = input.length;
        pi = new int[N];

        int begin = 1;
        int matched = 0;

        while(begin + matched < N) {
            if(input[begin + matched] == input[matched]) {
                ++matched;
                pi[begin + matched -1] = matched;
            }
            else {
                if(matched == 0) {
                    ++begin;
                }
                else {
                    begin += matched - pi[matched -1];
                    matched = pi[matched -1];
                }
            }
        }
    }
}
