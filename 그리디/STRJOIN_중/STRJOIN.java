package me.jeonghui.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class STRJOIN {

    public static void main(String[] args) throws Exception{

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(in.readLine());

        for(int t = 0 ; t < testCase ; t++) {

            int N = Integer.parseInt(in.readLine());
            PriorityQueue<Integer> queue = new PriorityQueue<>();

            String[] num = in.readLine().split(" ");
            for(int i = 0 ; i < N ; i++) {
                queue.add(Integer.parseInt(num[i]));
            }

            int answer = 0;

            while(queue.size() != 1) {
                int value = queue.poll();
                value += queue.poll();
                answer += value;
                queue.add(value);
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

}
