import java.io.*;
import java.util.*;

public class Main {
    // W 열 , H 행
    static int W,H;
    static int dp[][][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        dp = new int[W+1][H+1][4];
        for (int w = 2; w<W+1; w++){
            dp[w][1][0] = 1;
        }
        for (int h = 2; h<H+1; h++){
            dp[1][h][1] = 1;
        }

        dp[2][2][2] = 1;
        dp[2][2][3] = 1;

        for (int X = 2; X<W+1; X++){
            for (int Y = 2; Y< H+1; Y++){
                if (X==2 && Y==2) continue;
                dp[X][Y][0] = ((dp[X-2][Y][0] + dp[X-2][Y][1] + dp[X-2][Y][2]))%100000;
                dp[X][Y][1] = ((dp[X][Y-2][0] + dp[X][Y-2][1] + dp[X][Y-2][3]))%100000;
                dp[X][Y][2] = ((dp[X-1][Y-1][1] + dp[X-1][Y-1][3]))%100000;
                dp[X][Y][3] = ((dp[X-1][Y-1][0] + dp[X-1][Y-1][2]))%100000;
            }
        }
        System.out.println((dp[W][H][0] + dp[W][H][1] + dp[W][H][2] + dp[W][H][3])%100000);
    }
}
