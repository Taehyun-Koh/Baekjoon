import java.io.*;
import java.util.*;


public class Main {
    static int[] rocks;
    static int M,K;
    static double[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());
        rocks = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = 0;
        for (int i=0; i<M; i++){
            rocks[i] = Integer.parseInt(st.nextToken());
            total += rocks[i];
        }

        K = Integer.parseInt(br.readLine());

        double pos = 0;

        
        for (int i = 0; i<M; i++){

            if (rocks[i] < K) continue;

            double tmp = rocks[i];
            for (int j = 1 ; j<K; j++){
                tmp *= (rocks[i] - j);
            }
            pos += tmp;
        }
        double tmp2 = total;
        for (int i = 1; i < K; i++){
            tmp2 *= total-i;
        }
        double ans = pos/tmp2;
        System.out.println(ans);

    }

    static double nCr(int n, int k){
        if (n==k) return 1;
        if (dp[n][k] != 0) return dp[n][k];
        return dp[n][k] = nCr(n-1,k-1) + nCr(n-1,k);
    }

}
