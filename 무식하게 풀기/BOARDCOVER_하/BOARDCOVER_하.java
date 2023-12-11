import java.io.*;
import java.util.*;

public class BOARDCOVER_하 {

	public static int H, W, count;
	public static char[][] map;
	public static int[][][] block = {{{0,0}, {0,1}, {1,1}}, {{0,0}, {1,0}, {1,-1}}, {{0,0}, {0,-1}, {-1,-1}},
									 {{0,0}, {-1,0}, {-1,1}}, {{0,0}, {0,1}, {-1,1}}, {{0,0}, {1,0}, {1,1}}, 
									 {{0,0}, {0,-1}, {1,-1}}, {{0,0}, {-1,0}, {-1,-1}}, {{0,0}, {-1,0}, {0,1}}, 
									 {{0,0}, {1,0}, {0,1}}, {{0,0}, {1,0}, {0,-1}}, {{0,0}, {-1,0}, {0,-1}}};
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(in.readLine().trim());
		
		for(int t = 0 ; t < testCase ; t++) {
			
			StringTokenizer st = new StringTokenizer(in.readLine().trim());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			count = 0;
			
			for(int i = 0 ; i < H ; i++) {
				map[i] = in.readLine().toCharArray();
			}
			
			coverUp(0,0);
			
			sb.append(count).append("\n");
		}
		
		System.out.print(sb);
	}
	
	public static void coverUp(int x, int y) {
		if(x == H) {
			count++;
			return;
		}
		
		if(y == W) {
			coverUp(x+1, 0);
			return;
		}
		
		if(map[x][y] == '#') {
			coverUp(x, y+1);
			return;
		}
		
		for(int i = 0 ; i < 12 ; i++) {
			int num = 0;
			for(int j = 0 ; j < 3 ; j++) {
				int nextX = x + block[i][j][0];
				int nextY = y + block[i][j][1];
				if(nextX >= 0 && nextX < H && nextY >=0 && nextY < W && map[nextX][nextY] == '.') num++;
			}
			if(num != 3) {
				continue;
			}
			for(int j = 0 ; j < 3 ; j++) {
				map[x + block[i][j][0]][y + block[i][j][1]] = '#';
			}
			coverUp(x, y+1);
			for(int j = 0 ; j < 3 ; j++) {
				map[x + block[i][j][0]][y + block[i][j][1]] = '.';
			}
		}
	}
}
