package 수학_정수론_조합론;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
//그냥 팩토리얼
// public class Main {
 
// 	public static void main(String[] args) throws IOException {
 
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
// 		StringTokenizer st = new StringTokenizer(br.readLine());
 
// 		int N = Integer.parseInt(st.nextToken());
// 		int K = Integer.parseInt(st.nextToken());
 

// 		System.out.println(factorial(N) / (factorial(N - K) * factorial(K)));
// 	}
 
// 	static int factorial(int N) {

// 		if (N <= 1)	{
// 			return 1;
// 		}
// 		return N * factorial(N - 1);
// 	}
// }

// //파스칼 삼각형 사용
// public class Main {
 
// 	public static void main(String[] args) throws IOException {
 
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
// 		StringTokenizer st = new StringTokenizer(br.readLine());
 
// 		int N = Integer.parseInt(st.nextToken());
// 		int K = Integer.parseInt(st.nextToken());
 

// 		System.out.println(BC(N,K));
// 	}
 
// 	static int BC(int N, int K) {

// 		if (N <= 1)	{
// 			return 1;
// 		}
// 		return BC(N-1, K-1) + BC(N-1,K);
// 	}
// }

// DP
public class p11050 {
 
    static int[][] dp;
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		StringTokenizer st = new StringTokenizer(br.readLine());
 
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
 

        dp = new int[11][11];

		System.out.println(BC(N,K));
	}
 
	static int BC(int N, int K) {

		if (N <= 1)	{
			return 1;
		}

        if (dp[N][K] != 0){
            return dp[N][K];
        }
		return dp[N][K] = BC(N-1, K-1) + BC(N-1,K);
	}
}
