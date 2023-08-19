package DP;

import java.io.*;
import java.util.*;
public class p11053 {
    static int N;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dp = new int[N];
        for (int i = 0; i<N; i++){
            dp[i] = 1;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i<N; i++){
            for (int j = 0; j <i; j++){
                if (arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }

        }

        int max = 0;
        System.out.println(Arrays.toString(dp));
        for (int x: dp){
            max = Math.max(max,x);
        }
        bw.write(max+"\n");
        bw.flush();
        bw.close();
        br.close();

    }
}
