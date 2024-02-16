package me.jeonghui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ITES {

    public static Double MOD = Math.pow(2, 32);

    public static void main(String[] args) throws Exception{

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(in.readLine());

        for(int t = 0 ; t < testCase ; t++){

            RNG rng = new RNG();

            String[] inputs = in.readLine().split(" ");
            int K = Integer.parseInt(inputs[0]);
            int N = Integer.parseInt(inputs[1]);
            int answer = 0;
            int rangeSum = 0;
            Queue<Integer> queue = new LinkedList<>();

            for(int i = 0 ; i < N ; i++) {

                int newSignal = rng.next();

                rangeSum += newSignal;
                queue.add(newSignal);

                while(rangeSum > K) {
                    rangeSum -= queue.poll();
                }

                if(rangeSum == K) {
                    answer++;
                }
            }

            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static class RNG {
        double seed = 1983;

        public int next() {
            double ret = seed;
            seed = (seed * 214013 + 2531011) % MOD;
            return (int) (ret % 10000) + 1;
        }
    }
}
