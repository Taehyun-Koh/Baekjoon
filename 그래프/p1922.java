package 그래프;
import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int start;
    int end;
    int weight;


    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }


    @Override
    public int compareTo(Edge o) {
        // TODO Auto-generated method stub
        return weight - o.weight; // 자신이 앞에 있는게 오름차순
    }


    @Override
    public String toString() {
        return "Edge [start=" + start + ", end=" + end + ", weight=" + weight + "]";
    }
}


public class p1922 {
	static int[] parent;
	static ArrayList<Edge> edgeList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		edgeList = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			edgeList.add(new Edge(start, end, weight));
		}

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		Collections.sort(edgeList);

		int ans = 0;
		for (int i = 0; i < edgeList.size(); i++) {
			Edge edge = edgeList.get(i);

			// 사이클이 발생하는 간선은 제외.
			if (find(edge.start) != find(edge.end)) {
				ans += edge.weight;
				union(edge.start, edge.end);
			}
		}

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

    static boolean union(int x, int y){
        x = find(x); //부모 노드 찾기
        y = find(y);

        if (x==y) return false;

        if (x <= y) parent[y] = x;
        else parent[x] = y;
        return true;
    }

    static int find(int x){
        if (parent[x] == x) return x;
        return find(parent[x]);
    }
}
