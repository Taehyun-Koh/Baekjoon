package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2249 {
    public static int N,K;
    public static int[] arr;
    public static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        arr = new int[N+1];
        dp = new int[N+1][N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] == arr[i-1]){
                N--;
                i--;
            }
        }

        for (int i = 1; i<=N; i++){
            for (int j = 1; j<=N; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
            // 본인 전구를 바꾸는 값 = 0
            dp[i][i] = 0;
        }

        //두 개 이상의 전구들간의 최솟값 게산 => 사이즈 늘려감
        for (int size = 2; size<=N; size++){
            for (int start = 1; start<=N-size+1; start++){
                int end = start + size - 1;
                for (int k = start; k<end; k++){
                    int tmp = dp[start][k] + dp[k+1][end];
                    // 앞 묶음이랑 뒤 묶음의 색이 다를경우
                    if (arr[start] != arr[k+1]){
                        tmp++;
                    }

                    dp[start][end] = Math.min(dp[start][end], tmp);
                }
            }
        }
        System.out.println(dp[1][N]);
        
        
    }
}
