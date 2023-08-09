import java.io.*;
import java.util.*;

public class Main {
    
    static class Edge implements Comparable<Edge>{
        int cost;
        int a;
        int b;

        public Edge(int cost, int a, int b) {
            this.cost = cost;
            this.a = a;
            this.b = b;
        }
        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
        @Override
        public String toString() {
            return "Edge [cost=" + cost + ", a=" + a + ", b=" + b + "]";
        } 
    }

    static int N,M;
    static int[] parent;
    static int ans,cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        Edge[] edge = new Edge[M];
        parent = new int[N+1];
        for (int i = 1; i<=N; i++) parent[i] = i;

        for (int i = 0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edge[i] = new Edge(cost,a,b);
        }

        Arrays.sort(edge);

        ans = 0;
        cnt = 0;

        for (Edge x : edge){

            if (cnt == N+1) break;
            
            if (!union(x.a, x.b)){
                ans += x.cost;
                cnt++;
            }
            else continue;
        }

        System.out.println(ans);


    }

    public static int find(int x){
        if (parent[x] == x) return x;
        return find(parent[x]);
    }

    public static boolean union(int x, int y){
        x = find(x);
        y = find(y);

        if (x!=y){
            parent[y] = x;
            return false;
        }
        return true;
    }
}
