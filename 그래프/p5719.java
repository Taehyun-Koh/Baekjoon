package 그래프;
import java.io.*;
import java.util.*;
// 다익스트라를 통해 최단 경로를 트래킹해준다. => 최단 경로를 추적주기 위해서 별도의 리스트를 하나 더 만들어서 저장
// 1. 간선 정보를 인접리스트에 저장한다
// 2. 첫번째 1차 다익스트라를 통해 구해준다. -> 최단 경로에 해당되는 간선을 추적해서 저장
// 3. 추적한 간선에 대한 정보를 활용해서 boolean 배열 탑색 불가하도록
public class p5719 {

	static class Node implements Comparable<Node>{
		int to;
		int w;
		public Node(int to, int w) {
			this.to = to;
			this.w = w;
		}
		
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	static final int MAX = Integer.MAX_VALUE;
	static int n,m;
	static int[] dp;
	static boolean[][] exRoute;
	static List<Node>[] list;
	static List<Integer>[] removeList;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String input = null;
		StringBuilder sb = new StringBuilder();
		while(!(input=br.readLine()).equals("0 0")) {
			st = new StringTokenizer(input);
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[n];
			removeList = new ArrayList[n];
			dp = new int[n];
			for(int i=0; i<n; i++) {
				list[i] = new ArrayList<>();
				removeList[i] = new ArrayList<>();
			}
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				list[u].add(new Node(v,cost));
			}
			
			exRoute = new boolean[n][n];
            // 최단 경로 탐색
			dijkstra(s);
            // 최단 경로 제외
			removeMinRouteVertex(s,d);
            // 최단 경로 재탐색
			dijkstra(s);
			sb.append(dp[d]== MAX? -1 : dp[d]);
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}
	
	static void initDp() {
		Arrays.fill(dp, MAX);
	}
	
	static void removeMinRouteVertex(int s, int d) {
		if(s==d) return;
		for(int nxt : removeList[d]) {
			if(!exRoute[nxt][d]) {
				exRoute[nxt][d] = true;
				removeMinRouteVertex(s, nxt);
			}
		}
	}
	
	static void dijkstra(int s) {
		Queue<Node> q = new PriorityQueue<>();
		initDp();
		dp[s] = 0;
		q.add(new Node(s,0));
		
		while(!q.isEmpty()) {
			Node node = q.poll(); // 최소 비용을 가진 간선 정보를 꺼내기
			int cur = node.to;
			if(node.w > dp[cur]) continue; // 거리 갱신이 필요없으면 무시
			for(Node nxt : list[cur]) {

                //true이면 사용 불가능 => 두번째 탐색때만 활용
				if(exRoute[cur][nxt.to]) continue;
                //현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
				if(dp[nxt.to] > dp[cur] + nxt.w) {
					dp[nxt.to] = dp[cur] + nxt.w;
					removeList[nxt.to] = new ArrayList<>();
					removeList[nxt.to].add(cur);
					q.add(new Node(nxt.to, dp[nxt.to]));	
				}else if(dp[nxt.to] == dp[cur] + nxt.w) {
					removeList[nxt.to].add(cur);
				}
			}
		}
	}
}