package 백트래킹;

import java.io.*;
import java.util.*;


public class p15650 {
    static int N,M;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];

        backtracking(0,0);

    }

    public static void backtracking(int index, int cnt){
        if (cnt == M){
            for (int i =0; i<N; i++){
                if (visited[i] == true){
                    System.out.print(i+1 + " ");
                }
            }
            System.out.println();
        }
        for (int i = index; i<N; i++){
            if (!visited[i]){
                visited[i] = true;
                backtracking(i+1, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
