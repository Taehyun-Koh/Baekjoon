package DFS_BFS;

import java.io.*;
import java.util.*;

public class p1759 {
    static int L,C;
    static String[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new String[C];
        for (int i = 0; i < C; i++){
            arr[i] = st.nextToken();
        }
        Arrays.sort(arr);

        for (int i = 0; i <= C-L; i++){
            if ("aeiou".contains(arr[i])){
                dfs(arr[i], i, 1, 0);
            } else{
                dfs(arr[i], i, 0, 1);
            }
        }
    }

    public static void dfs(String sb, int index, int ae, int mz){
        // System.out.println(sb);
        if(sb.length() == L){
            if (ae >= 1 && mz >=2){
                System.out.println(sb);
                return;
            }
            
        }

        for (int i = index+1; i<C; i++){
            if ("aeiou".contains(arr[i])){
                dfs(sb+arr[i], i, ae+1, mz);
            } else{
                dfs(sb+arr[i], i, ae, mz+1);
            }
        }
    }
}
