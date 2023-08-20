package 백트래킹;

import java.io.*;

public class p9663 {
    static int N;
    static int ans;
    static int[] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ans = 0;
        map = new int[N];
        NQueen(0);
        System.out.println(ans);

    }

    public static void NQueen(int depth){
        if (depth == N) {
            ans++;
            return;
        }

        for (int i = 0; i<N; i++){
            map[depth] = i;

            if (Possibility(depth)){
                NQueen(depth+1);
            }
        }
    }

    public static boolean Possibility(int col){

        for (int i = 0; i < col; i++){
            if (map[col] == map[i]) return false;

            else if (Math.abs(col-i) == Math.abs(map[col] - map[i])){
                return false;
            }
        }
        return true;
    }
}
