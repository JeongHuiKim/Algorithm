package me.jeonghui.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class LUNCHBOX {

    public static void main(String[] args) throws Exception{

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());

        for(int testCase = 0 ; testCase < T ; testCase++) {

            int N = Integer.parseInt(in.readLine());

            String[] hotNum = in.readLine().split(" ");
            String[] eatNum = in.readLine().split(" ");

            PriorityQueue<Lunch> queue = new PriorityQueue<>();

            for(int i = 0 ; i < N ; i++) {
                queue.add(new Lunch(hotNum[i], eatNum[i]));
            }

            int answer = 0;
            int eatTime = 0;

            while(!queue.isEmpty()) {

                Lunch curr = queue.poll();

                answer += curr.hot;
                eatTime = Math.max(Math.max(eatTime - curr.hot, 0), curr.eat);
            }

            sb.append(answer + eatTime).append("\n");
        }

        System.out.println(sb);
    }

    public static class Lunch implements Comparable<Lunch> {


        int hot;
        int eat;

        public Lunch(String hot, String eat) {
            this.hot = Integer.parseInt(hot);
            this.eat = Integer.parseInt(eat);
        }

        @Override
        public int compareTo(Lunch o) {
            return o.eat - this.eat;
        }
    }
}
