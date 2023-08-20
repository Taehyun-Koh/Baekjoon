package DP;

import java.io.*;
import java.util.*;

public class p5582 {
    static ArrayList<String> strA, strB;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmpA = br.readLine().split("");
        String[] tmpB = br.readLine().split("");

        int lena = tmpA.length;
        int lenb = tmpB.length;

        strA = new ArrayList<String>();
        strB = new ArrayList<String>();
        strA.add("a");
        strB.add("b");

        dp = new int[lena+1][lenb+1];

        for(int i = 0; i<lena; i++) strA.add(tmpA[i]);
        for(int i = 0; i<lenb; i++) strB.add(tmpB[i]);
        int ans = 0;
        for (int i = 1; i<=lena; i++){
            for (int j = 1; j<=lenb; j++){
                if (strA.get(i).equals(strB.get(j))){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }

        // for (int i = 0; i<=lena; i++){
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        System.out.println(ans);
    }
}
