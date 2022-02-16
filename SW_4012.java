package w0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
1
6
0 37 26 52 77 20
32 0 15 26 75 16
54 33 0 79 37 90
92 10 66 0 92 3
64 7 89 89 0 21
80 49 94 68 5 0

*/
public class SW_4012 {
	static int N, min;
	static boolean[] isSelected;
	static int[][] S;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			S = new int[N][N];
			isSelected = new boolean[N];
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					S[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			combi(0, 0);
			
			System.out.println("#"+tc+" "+min);
		}
	}
	public static void combi(int cnt, int start) {
		if(cnt==N/2) {
			int[] A = new int[cnt];
			int[] B = new int[cnt];
			int sumA = 0;
			int sumB = 0;
			for(int i=0, cnt1=0, cnt2=0;i<N;i++) {
				if(isSelected[i]) {
					A[cnt1++] = i;
				}
				else {
					B[cnt2++] = i;
				}
			}
			for(int i=0;i<cnt;i++) {
				for(int j=0;j<cnt;j++) {
					if(i==j) continue;
					sumA += S[A[i]][A[j]];
					sumB += S[B[i]][B[j]];
				}
			}
			if(min>Math.abs(sumA-sumB))
				min = Math.abs(sumA-sumB);
			return;
		}
		for(int i=start;i<N;i++) {
			isSelected[i] = true;
			combi(cnt+1, i+1);
			isSelected[i] = false;
		}
	}
}
