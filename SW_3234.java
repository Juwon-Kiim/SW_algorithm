package w0218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
3
3
1 2 4
3
1 2 3
9
1 2 3 5 6 4 7 8 9

*/
// 전역변수로 실행하면 시간초과가 뜬다.
/*public class SW_3234 {
	static int count;
	static int N;
	static int[] weight;
	static boolean[] isSelected;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			
			weight = new int[N];
			isSelected = new boolean[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			count=0;
			permutation(0, 0, 0);
			System.out.println("#"+tc+" "+count);
		}
	}
	public static void permutation(int cnt, int lsum, int rsum) {
		if(cnt==N) {
			count++;
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(isSelected[i]) continue;
			
			isSelected[i] = true;
			permutation(cnt+1, lsum+weight[i], rsum);
			
			if(lsum>=rsum+weight[i])
				permutation(cnt+1, lsum, rsum+weight[i]);
			isSelected[i] = false;
		}
	}
}*/

// 지역변수를 넘겨줬을 때 시간 초과가 뜨지 않는다
public class SW_3234 {
	static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] weight = new int[N];
			boolean[] isSelected = new boolean[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			count=0;
			permutation(0, weight, 0, 0, isSelected);
			System.out.println("#"+tc+" "+count);
		}
	}
	public static void permutation(int cnt, int[] weight, int lsum, int rsum, boolean[] isSelected) {
		if(cnt==weight.length) {
			count++;
			return;
		}
		
		for(int i=0;i<weight.length;i++) {
			if(isSelected[i]) continue;
			
			isSelected[i] = true;
			permutation(cnt+1, weight, lsum+weight[i], rsum, isSelected);
			
			if(lsum>=rsum+weight[i])
				permutation(cnt+1, weight, lsum, rsum+weight[i], isSelected);
			isSelected[i] = false;
		}
	}
}
