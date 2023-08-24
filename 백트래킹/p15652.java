package 백트래킹;

import java.io.*;
import java.util.*;

public class p15652 {
    static int N,M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        

        dfs(0,0);
        System.out.println(sb);
    }
    
    public static void dfs(int index, int cnt){
        if (cnt == M){
            for (int val : arr){
                sb.append(val + " ");
            }
            sb.append('\n');
            return;
        }

        for (int i = index; i<N; i++){
            arr[cnt] = i + 1;
            dfs(i,cnt+1);
        }
    }
}
