import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] dp = new int[30][30];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T ; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int W = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            System.out.println(combi(E,W));
            
        }
    }

    static int combi(int n ,int r){
        if (dp[n][r] > 0){
            return dp[n][r];
        }
        if (n == r || r == 0){
            return dp[n][r] = 1;
        }

        return dp[n][r] = combi(n-1, r-1) + combi(n-1,r);
    }
}
