package 백트래킹;

import java.io.*;
import java.util.*;

public class p15649 {
    static int N,M;
    static int[] visited,arr;
    static BufferedWriter bw;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new int[N];
        arr = new int[M];
        back(0);
        System.out.print(sb);

    }

    public static void back(int cnt) throws IOException{
        if (cnt == M){
            for (int val : arr){
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
            
        }

        for (int i = 0; i<N; i++){
            if (visited[i] == 0){
                visited[i] = 1;
                arr[cnt] = i+1;
                back(cnt+1);
                visited[i] = 0;
            }
        }
    }
}

