package me.jeonghui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class JOSEPHUS {

    public static void main(String[] args) throws Exception{

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(in.readLine());

        for(int t = 0 ; t < testCase ; t++) {

            String[] input = in.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);
            LinkedList<Integer> list = new LinkedList<>();

            for(int i = 1 ; i <= N ; i++) {
                list.add(i);
            }

            int idx = 0;
            while(list.size() != 2) {
                list.remove(idx--);
                for(int i = 0 ; i < K ; i++) {
                    if (idx == list.size()) idx = 0;
                    idx++;
                }
                if (idx == list.size()) idx = 0;
            }

            sb.append(list.get(0)).append(" ").append(list.get(1)).append("\n");
        }

        System.out.println(sb);
    }
}
