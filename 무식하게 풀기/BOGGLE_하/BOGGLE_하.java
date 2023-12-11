import java.io.*;

// 6.2
public class BOGGLE_하 {
	
	public static int N = 5;
	public static char[][] map = new char[5][5];
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 0 ; t < testCase ; t++) {
			
			for(int i = 0 ; i < N ; i++) {
				map[i] = in.readLine().toCharArray();
			}
			
			int count = Integer.parseInt(in.readLine());
			
			for(int i = 0 ; i < count ; i++) {
				
				char[] word = in.readLine().toCharArray();
				boolean isTrue = false;
				sb.append(word).append(" ");
				
				for(int x = 0 ; x < N ; x++) {
					for(int y = 0 ; y < N ; y++) {
						if(map[x][y] == word[0] && isNextWord(word, x, y, 1)) {
							isTrue = true;
							break;
						}
					}
					if(isTrue) break;
				}
				
				if(isTrue) {
					sb.append("YES\n");
				}
				else {
					sb.append("NO\n");
				}
			}
		}
		
		System.out.print(sb);
	}
	
	public static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
	public static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
	
	public static boolean isNextWord(char[] word, int x, int y, int index) {
		
		if(index == word.length) {
			return true;
		}
		
		for(int i = 0 ; i < 8 ; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && map[nextX][nextY] == word[index]) {
				if(isNextWord(word, nextX, nextY, index+1)) {
					return true;
				}
			}
		}
		
		return false;
	}
}
