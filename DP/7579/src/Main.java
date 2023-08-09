import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] memory, cost;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int ans = Integer.MAX_VALUE;

        memory = new int[N];
        cost = new int[N];
        dp = new int[N][100001];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i<N; i++){
            memory[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<N; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<N; i++){
            int c = cost[i];
            int m = memory[i];

            for (int j = 0; j<=10000; j++){
                if (i==0){
                    if (j>=c) dp[i][j] = m;
                } else{
                    if (j>=c){
                        dp[i][j] = Math.max(dp[i-1][j-c] + m, dp[i-1][j]);
                    } else{
                        dp[i][j] = dp[i-1][j];
                    }
                }

                if (dp[i][j] >= M) ans = Math.min(ans,j);
            }

            
        }

        System.out.println(ans);
    }
}
