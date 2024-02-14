package me.jeonghui;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CHRISTMAS {

    public static final int MOD = 20091101;

    public static void main(String[] args) throws Exception{

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(in.readLine());

        for(int t = 0 ; t < testCase ; t++) {

            String[] input = in.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);
            int[] psum = new int[N + 1];

            input = in.readLine().split(" ");
            for(int i = 1 ; i <= N ; i++) {
                psum[i] = Integer.parseInt(input[i-1]);
                psum[i] += psum[i-1];
            }

            for(int i = 1 ; i <= N ; i++) {
                psum[i] %= K;
            }

            // 1
            int answer = 0;
            int[] count = new int[K];
            for(int i = 0 ; i <= N ; i++) {
                count[psum[i]]++;
            }

            for(int i = 0 ; i < K ; i++) {
                if(count[i] >= 2) answer = (answer + ((count[i] * (count[i] - 1)) / 2)) % MOD;
            }

            sb.append(answer).append(" ");

            // 2
            int[] ret = new int[N+1];
            int[] prev = new int[K];
            for(int i = 0 ; i < K ; i++) {
                prev[i] = -1;
            }

            for(int i = 0 ; i <= N ; i++) {
                if(i > 0) ret[i] = ret[i-1];
                else ret[i] = 0;

                int loc = prev[psum[i]];
                if(loc != -1) ret[i] = Math.max(ret[i], ret[loc] + 1);
                prev[psum[i]] = i;
            }

            sb.append(ret[N]).append("\n");
        }

        System.out.println(sb);
    }

}
