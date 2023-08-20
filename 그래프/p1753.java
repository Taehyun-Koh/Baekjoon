package 그래프;
import java.io.*;
import java.util.*;



public class p1753 {

    static int V,E,start;
    static ArrayList<ArrayList<Edge>> adjList;
    static PriorityQueue<Edge> pq;
    static int[] dist;

    public static class Edge implements Comparable<Edge>{
        int to, cost;

        
        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        // 우선순위 큐에 삽입했을 떄 순서 결정용
        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

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

        for (int i = 0; i<=V; i++){
            adjList.add(new ArrayList<Edge>());
        }
        for(int i = 1; i<=E; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList.get(s).add(new Edge(e,c));

        }

        dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Dijkstra();

        for (int i = 1; i <=V; i++){
            if (dist[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            }else{
                System.out.println(dist[i]);
            }
        }
    }

    public static void Dijkstra(){
        pq = new PriorityQueue<>();
        pq.add(new Edge(start,0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Edge now = pq.poll(); // 최소 비용을 가진 간선 정보를 꺼내기

            if(dist[now.to] < now.cost) { // 거리 갱신이 필요없으면 무시
                continue;
            }

            for(Edge next : adjList.get(now.to)){
                //현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                if (dist[next.to] > dist[now.to] + next.cost){
                    dist[next.to] = dist[now.to] + next.cost;
                    pq.add(new Edge(next.to, dist[next.to]));
                }
            }
        }
    }
}
