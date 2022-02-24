package Algo_D0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_7236 {
	// 좌상, 상, 우상, 우, 우하, 하, 좌하, 좌
	static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			
			char[][] map = new char[N][N];
			ans=0;
			
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j=0;j<N;j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}
			for(int x=1;x<N-1;x++) {
				for(int y=1;y<N-1;y++) {
					int sum = 0;
					for(int i=0;i<8;i++) {
						int nx = x+dx[i];
						int ny = y+dy[i];
						switch(map[nx][ny]) {
						case 'W':
							sum+=1;
							break;
						}
					}
					if(ans<=sum) ans = sum;
				}
			}
			sb.append(ans);
			System.out.println(sb);
		}
	}
}
