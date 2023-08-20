package DP;

import java.io.*;
import java.util.*;


public class p5557 {
    static int N,goal;
    static int[] arr;
    static long ans = 0;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N-1];
        for (int i =0; i<N; i++){
            if(i == N-1){
                goal = Integer.parseInt(st.nextToken());
            }else{
                arr[i] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new long[N][21];
        dp[0][arr[0]]++;

        for (int i = 1; i<N-1; i++){
            int num = arr[i];
            for (int j = 0; j<21; j++){
                if (j + num < 21){
                    dp[i][j] += dp[i-1][j+num];
                }
                if (j - num >= 0 ){
                    dp[i][j] += dp[i-1][j-num];
                }
            }
        }
        System.out.println(dp[N-2][goal]);


    }
}
