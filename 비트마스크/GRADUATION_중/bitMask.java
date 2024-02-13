package me.jeonghui;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bitMask {

    public static int N, K, M, L, answer;
    public static int[] major, semester;
    public static int[][] cache;
    public static final int INF = 987654321;

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(in.readLine());

        for(int t = 0 ; t < testCase ; t++) {

            String[] input = in.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            K = Integer.parseInt(input[1]);
            M = Integer.parseInt(input[2]);
            L = Integer.parseInt(input[3]);
            major = new int[N];
            semester = new int[M];
            cache = new int[M][1<<N];

            answer = INF;

            for(int i = 0 ; i < N ; i++) {
                input = in.readLine().split(" ");
                for(int j = 1 ; j < input.length ; j++) {
                    major[i] |= (1 << Integer.parseInt(input[j]));
                }
            }
            for(int i = 0 ; i < M ; i++) {
                input = in.readLine().split(" ");
                for(int j = 1 ; j < input.length ; j++) {
                    semester[i] |= (1 << Integer.parseInt(input[j]));
                }
            }

            answer = cal(0, 0);

            sb.append(answer == INF ? "IMPOSSIBLE" : answer).append("\n");
        }

        System.out.println(sb);
    }

    public static int cal(int done, int sem) {

        if(Integer.bitCount(done) >= K) return 0;
        if(sem >= M ) return INF;

        if(cache[sem][done] != 0) return cache[sem][done];

        cache[sem][done] = INF;
        int canTake = (semester[sem] & ~done);

        for(int i = 0 ; i < N ; i++) {
            if((canTake & (1 << i)) > 0 && (done & major[i]) != major[i]) canTake &= ~(1 <<i);
        }

        for(int take = canTake; take > 0; take = ((take - 1) & canTake)) {
            if(Integer.bitCount(take) > L) continue;
            cache[sem][done] = Math.min(cache[sem][done], cal(done | take, sem + 1) + 1);
        }

        cache[sem][done] = Math.min(cache[sem][done], cal(done, sem + 1));
        return cache[sem][done];
    }
}
