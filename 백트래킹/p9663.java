package 백트래킹;

import java.io.*;

public class p9663 {
    static int N;
    static int ans;
    static int[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ans = 0;
        visited = new int[N][N];
        NQueen(0);
        System.out.println(ans);

    }
    public static void NQueen(int cnt){


        if (cnt == N){
            
            ans++;

            return;
        }

        for (int i = 0; i<N; i++){
            if(visited[i][cnt] == 0){

                for (int j =cnt; j<N; j++){
                    int diff = j-cnt;
                    if (i-diff >=0){
                        visited[i-diff][j] += 1;
                    }
                    if (i+diff <N) {
                        visited[i+diff][j] += 1;
                    }
                    visited[i][j] += 1;
                }

                NQueen(cnt + 1);
                for (int j =cnt; j<N; j++){
                    int diff = j-cnt;
                    if (i-diff >=0){
                        visited[i-diff][j] -= 1;
                    }
                    
                    if (i+diff <N) {
                        visited[i+diff][j] -= 1;
                    }
                    visited[i][j] -= 1;
                }
            }

        }
    }


}
