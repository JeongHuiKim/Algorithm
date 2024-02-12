package me.jeonghui.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MATCHORDER {

    public static void main(String[] args) throws Exception{

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());

        for(int testCase = 0 ; testCase < T ; testCase++) {

            int N = Integer.parseInt(in.readLine());

            ArrayList<Integer> RUS =new ArrayList<>();
            ArrayList<Integer> KOR =new ArrayList<>();

            String[] rNum = in.readLine().split(" ");
            for(int i = 0 ; i < N ; i++) {
                RUS.add(Integer.parseInt(rNum[i]));
            }
            String[] kNum = in.readLine().split(" ");
            for(int i = 0 ; i < N ; i++) {
                KOR.add(Integer.parseInt(kNum[i]));
            }

            Collections.sort(RUS);
            Collections.sort(KOR);

            int count = 0;
            while(!KOR.isEmpty()) {
                int lowest = KOR.get(0);

                if(lowest >= RUS.get(0)) {
                    count++;
                    RUS.remove(0);
                }
                else {
                    RUS.remove(RUS.size() - 1);
                }
                KOR.remove(0);
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

}
