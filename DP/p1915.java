package DP;

import java.io.*;
import java.util.*;

public class p1915 {
    static int N,M;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int ans = 0;
        dp = new int[N+1][M+1];
        for (int i = 1; i<=N; i++){
            String[] input = br.readLine().split("");
            for (int j = 1; j<=M; j++){
                int tmp = Integer.parseInt(input[j-1]);
                if(tmp==1){
                    dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1])) + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        System.out.println(ans*ans);
    }
}
