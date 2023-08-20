package 수학_정수론_조합론;


import java.io.*;
import java.util.*;


public class p11051 {
    static int N,K;
    static long[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new long[N+1][K+1];
        // System.out.println(nCr(N,K));
        System.out.println(nCr(N,K));
        
    }

    static long nCr(int n, int k){
        if (n==0) return 0;

        if (n==k || k ==0){
            return 1;
        }
        if (dp[n][k] != 0){
            return dp[n][k] % 10007;
        }

        return dp[n][k] = (nCr(n-1,k-1) + nCr(n-1,k)) %10007;
    }

}
