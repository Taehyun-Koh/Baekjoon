package 백트래킹;

import java.io.*;
import java.util.*;

public class p15664 {
    static int N,M;
    static int[] arr;
    static int[] ans;
    static HashSet<String> hs = new HashSet<>();
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        ans = new int[M];
        for (int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        for (int i=0; i<N; i++){
            dfs(0, i);
        }

    }
    static void dfs(int depth ,int index){
        if (depth == M){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i<M; i++){
                sb.append(ans[i]).append(" ");
            }

            if (!hs.contains(sb.toString())){
                System.out.println(sb);
                hs.add(sb.toString());
            }
            return;
        }

        for (int i = 0; i<N; i++){
            ans[depth] = arr[i];
            dfs(depth+1, i+1);
        }
    }
}
