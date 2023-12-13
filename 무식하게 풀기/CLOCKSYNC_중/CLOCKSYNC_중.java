import java.io.*;
import java.util.*;

public class CLOCKSYNC_중 {

	public static int N = 16;
	public static final int INF = 987654321;
	public static int[] state;
	public static int[][] switchs = {{1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
									 {0,0,0,1,0,0,0,1,0,1,0,1,0,0,0,0},
									 {0,0,0,0,1,0,0,0,0,0,1,0,0,0,1,1},
									 {1,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0},
									 {0,0,0,0,0,0,1,1,1,0,1,0,1,0,0,0},
									 {1,0,1,0,0,0,0,0,0,0,0,0,0,0,1,1},
									 {0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,1},
									 {0,0,0,0,1,1,0,1,0,0,0,0,0,0,1,1},
									 {0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0},
									 {0,0,0,1,1,1,0,0,0,1,0,0,0,1,0,0}};
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(in.readLine().trim());
		
		for(int t = 0 ; t < testCase ; t++) {
			state = new int[N];
			StringTokenizer st = new StringTokenizer(in.readLine().trim());
			for(int i = 0 ; i < N ; i++) {
				state[i] = Integer.parseInt(st.nextToken());
			}
			
			int count = solve(0);
			
			sb.append(count == INF ? -1 : count).append("\n");
		}
		
		System.out.print(sb);
	}
	
	public static int solve(int switchNum) {
		
		if(switchNum == 10) return check() ? 0 : INF;
		
		int ret = INF;
		for(int i = 0 ; i < 4 ; i++) {
			ret = Math.min(ret, i + solve(switchNum + 1));
			push(switchNum);
		}
		
		return ret;
	}
	
	public static void push(int switchNum) {
		for(int i = 0 ; i < N ; i++) {
			if(switchs[switchNum][i] == 1) {
				state[i] += 3;
				if(state[i] == 15) state[i] = 3;
			}
		}
	}
	
	public static boolean check() {
		for(int i = 0 ; i < N ; i++) {
			if(state[i] != 12) return false;
		}
		return true;
	}
}
