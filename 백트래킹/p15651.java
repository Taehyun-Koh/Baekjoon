package 백트래킹;

import java.io.*;
import java.util.*;

public class p15651 {
    static int N,M;
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        arr = new int[M];

        dfs(0);
        System.out.print(sb);
    }

    public static void dfs(int cnt) throws IOException{
        if (cnt == M){
            for (int val : arr){
                bw.write(val + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < N; i++){
            if (!visited[i]){
                arr[cnt] = i+1;
                // System.out.println(Arrays.toString(arr));
                dfs(cnt+1);

            }
        }
    }
}
