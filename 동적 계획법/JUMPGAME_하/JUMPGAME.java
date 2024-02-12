package me.jeonghui.dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JUMPGAME {

    public static int[][] map;
    public static boolean[][] check;
    public static int N;

    public static int[] dx = {1,0};
    public static int[] dy = {0,1};

    public static void main(String[] args) throws Exception{

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());

        for(int testCase = 0 ; testCase < T ; testCase++) {

            N = Integer.parseInt(in.readLine());
            map = new int[N][N];
            check = new boolean[N][N];

            for(int i = 0 ; i < N ; i++) {
                String num[] = in.readLine().split(" ");
                for(int j = 0 ; j < N ; j++) {
                    map[i][j] = Integer.parseInt(num[j]);
                }
            }

            jump(0,0);

            if(check[N-1][N-1]) {
                sb.append("YES").append("\n");
            }
            else {
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb);
    }

    public static void jump(int x, int y) {
        check[x][y] = true;

        for(int i = 0 ; i < 2 ; i++) {
            int xx = x + dx[i] * map[x][y];
            int yy = y + dy[i] * map[x][y];
            if(xx >= 0 && xx < N && yy >= 0 && yy < N && !check[xx][yy]) {
                jump(xx, yy);
            }
        }
    }
}
