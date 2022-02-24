package Algo_D0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
1
2 2 1
3 2

*/
public class SW_1860 {
	public static void main(String[] args) throws NumberFormatException, IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// N명의 사람, M초의 시간에 K개의 붕어빵 생성
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int bread = 0;
			int[] seconds = new int[N];
			boolean out = false;
			st = new StringTokenizer(br.readLine());			
			
			for(int i=0;i<N;i++) {
				seconds[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(seconds);
			
			int idx = 0;
			
			for(int i=1;i<=seconds[N-1];i++) {
				if(i%M==0) {
					bread+=K;
				}
				if(seconds[idx]<M) {
					sb.append("Impossible");
					break;
				}
				for(int j=0;j<N;j++) {
					if(seconds[j]==i) {
						bread-=1;
						if(bread<0) {
							sb.append("Impossible");
							out = true;
							break;
						}
					}
					if(out) break;
				}
				if(out) break;
				if(seconds[N-1]==i) {
					sb.append("Possible");
					break;
				}
			}
			
			System.out.println(sb);
		}
	}
}
