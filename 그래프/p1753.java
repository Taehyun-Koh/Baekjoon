package 그래프;
import java.io.*;
import java.util.*;



public class p1753 {

    public static class Edge implements Comparable<Edge>{
        int to,cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            // TODO Auto-generated method stub
            return this.cost - o.cost;
        }

        
        
    }
    static int V,E;
    static int start;
    static PriorityQueue<Edge> pq;
    static ArrayList<ArrayList<Edge>> adjList;
    static int[] dist;
    
    // 다익스트라 구현
    // 1. 출발 노드 설정
    // 2. 최단 거리 테이블 초기화
    // 3. 방문하지 않은 노드 중에서 최단 거리가 가장 짧은 노드를 선택한다.
    // 4. 해당 노드를 거쳐 다른 노드로 가는 비용을 계산하여 최단 거리 테이블을 갱신한다.

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        adjList = new ArrayList<ArrayList<Edge>>();
        for (int i = 0; i <=V; i++){
            adjList.add(new ArrayList<Edge>());
        }

        for (int i = 1; i<=E; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList.get(s).add(new Edge(e,c));
        }

        //결과 배열
        dist = new int[V+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        Dijkstra();

        for (int i = 1; i<=V; i++){
            if (dist[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }

    public static void Dijkstra(){
        pq = new PriorityQueue<>();

        // 시작지점 초기화
        pq.add(new Edge(start,0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Edge now = pq.poll();

            // 갱신하려는 값이 지금 저장된 최소 비용보다 큰 경우 -> 갱신 필요없으므로 continue
            if (dist[now.to] < now.cost){
                continue;
            }

            //현재 노드에 연결된 다른 노드를 하나씩 탐색
            for (Edge next : adjList.get(now.to)){
                // 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                if (dist[next.to] > dist[now.to] + next.cost){
                    dist[next.to] = dist[now.to] + next.cost;
                    pq.add(new Edge(next.to, dist[next.to]));
                }
            }
        }
    }


}
