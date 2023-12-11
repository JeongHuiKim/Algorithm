import java.io.*;
import java.util.*;

public class PICNIC_하 {

	public static boolean[][] friendInfo;
	public static boolean[] isChecked;
	public static int n, m, count;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(in.readLine().trim());
		
		for(int t = 0 ; t < testCase ; t++) {
			
			StringTokenizer st = new StringTokenizer(in.readLine().trim());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			isChecked = new boolean[n];
			friendInfo = new boolean[10][10];
			count = 0;
			
			st = new StringTokenizer(in.readLine().trim());
			for(int i = 0 ; i < m ; i++) {
				int first = Integer.parseInt(st.nextToken());
				int second = Integer.parseInt(st.nextToken());
				friendInfo[first][second] = true;
				friendInfo[second][first] = true;
			}
			
			makeCouple(0);
			
			sb.append(count).append("\n");
		}
		
		System.out.print(sb);
	}
	
	public static void makeCouple(int index) {
		
		if(index >= n) {
			count++;
			return;
		}
		
		if(isChecked[index]) {
			makeCouple(index+1);
			return;
		}
		
		for(int i = index + 1 ; i < n ; i++) {
			if(!isChecked[i] && friendInfo[index][i]) {
				isChecked[index] = true;
				isChecked[i] = true;
				makeCouple(index+1);
				isChecked[index] = false;
				isChecked[i] = false;
			}
		}
		
		return;
	}
	
}
