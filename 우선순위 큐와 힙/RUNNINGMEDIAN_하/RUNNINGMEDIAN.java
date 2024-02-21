package me.jeonghui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class RUNNINGMEDIAN {

    public static int a, b;

    public static void main(String[] args) throws Exception{

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(in.readLine());

        for(int t = 0 ; t < testCase ; t++){

            String[] input = in.readLine().split(" ");

            int N = Integer.parseInt(input[0]);
            a = Integer.parseInt(input[1]);
            b = Integer.parseInt(input[2]);
            RNG rng = new RNG();

            double answer = 0;
            PriorityQueue<Integer> big = new PriorityQueue<>();
            PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
            small.add(rng.next());
            answer += small.peek();

            for(int i = 1 ; i < N ; i++) {
                big.add(rng.next());

                if(big.peek() < small.peek()) {
                    small.add(big.poll());
                }

                if(small.size() < big.size()) {
                    small.add(big.poll());
                }
                if(small.size() > big.size() + 1) {
                    big.add(small.poll());
                }

                answer += small.peek();
            }

            sb.append((int) (answer % 20090711)).append("\n");
        }
        System.out.println(sb);
    }

    public static class RNG {
        double seed = 1983;

        public int next() {
            double ret = seed;
            seed = (seed * a + b) % 20090711;
            return (int) ret;
        }
    }

}
