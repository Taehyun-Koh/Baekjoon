import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] dp,arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        dp = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 0;

        for (int i = 1; i<=N; i++){
            dp[i] = dp[i-1] + arr[i];
        }

        for (int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(dp[b] - dp[a-1]);
        }
    }
}
