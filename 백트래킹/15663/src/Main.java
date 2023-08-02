import java.util.*;
import java.io.*;


public class Main {
    static int N,M;
    static int[] arr;
    static int[] out;
    static boolean[] visited;
    static HashSet<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        visited = new boolean[N];
        out = new int[M];
        for (int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0);
    }
    static void dfs(int depth){

        if (depth == M){
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i<M; i++){
                sb2.append(out[i]).append(" ");
            }
            if (!set.contains(sb2.toString())){
                System.out.println(sb2);
                set.add(sb2.toString());
            }
            return;
        }

        for(int i =0 ; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                out[depth] = arr[i];
                dfs(depth+1);
                visited[i] = false;
            }


        }

    }

    // static void dfs()
}
