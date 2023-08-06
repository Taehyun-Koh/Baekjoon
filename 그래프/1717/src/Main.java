import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for (int i = 0; i<n+1; i++){
            parent[i] = i;
        }
        for (int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int uf = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (uf == 0){
                union(a,b);
            }
            else{
                if (find(a) == find(b)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);

        if (x!=y){
            parent[x] = y;
        }

    }

    static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}
