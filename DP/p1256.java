package DP;

import java.io.*;
import java.util.*;


public class p1256 {
    static int N,M;
    static double K;
    static double[][] dp;
    static StringBuilder sb = new StringBuilder();


    static double combi(int n, int m){
        if (n==0 || m == 0){
            return 1;
        }
        if (dp[n][m] != 0){
            return dp[n][m];
        }

        return dp[n][m] = Double.min(combi(n-1,m) + combi(n,m-1), 1000000001);
    }

    static void getRes(int a, int z, double k){
        if (a == 0 ){
            for(int i = 0; i<z; i++){
                sb.append('z');
            }
            return;
        }
        if (z == 0){
            for (int i=0; i<a; i++){
                sb.append('a');
            }
            return;
        }

        double check = combi(a-1, z);

        if (k > check){
            sb.append("z");
            getRes(a,z-1,k-check);
        } else{
            sb.append("a");
            getRes(a-1,z,k);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N,M;
        double K;


        // N개 a, M개 b
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new double[N+1][M+1];

        getRes(N,M,K);

        if (combi(N,M) < K){
            System.out.println(-1);
        }else{
            System.out.println(sb.toString());
        }
    }

}
