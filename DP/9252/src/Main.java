import java.io.*;
import java.util.*;

public class Main {
    static String[] strA,strB;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String tmpA = br.readLine();
        String tmpB = br.readLine();

        int lenA = tmpA.length();
        int lenB = tmpB.length();

        dp = new int[lenA+1][lenB+1];

        strA = (tmpA).split("");
        strB = (tmpB).split("");

        int max = 0;
        for(int i = 1; i<=lenA; i++){
            for(int j = 1; j<=lenB; j++){
                if(strA[i-1].equals(strB[j-1])){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        Stack<String> stack = new Stack<>();
        while (lenA >= 1 && lenB >= 1){
            if (dp[lenA][lenB] == dp[lenA-1][lenB]){
                lenA--;
            } else if(dp[lenA][lenB] == dp[lenA][lenB-1]){
                lenB--;
            } else{
                stack.push(strB[lenB-1]);
                lenA--;
                lenB--;
            }
        }
        System.out.println(max);
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
        System.out.println(sb);
        
    }
}
