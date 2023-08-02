import java.io.*;
import java.util.*;

// 학생 = 노드, 조건 = 간선

public class Main {
    static int N,M;
    static Queue<Integer> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //위상정렬에 사용할 진입차수 저장 배열
        int[] edgeCount = new int[N+1];
        //위상정렬 사용할 그래프
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i<N+1; i++){
            graph.add(new ArrayList<Integer>());
        }

        // System.out.println(graph);
        visited = new boolean[N+1];

        for (int i = 0 ; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int tmpa = Integer.parseInt(st.nextToken());
            int tmpb = Integer.parseInt(st.nextToken());
            
            graph.get(tmpa).add(tmpb);
            edgeCount[tmpb]++;

        }
        for (int i = 1; i<N+1; i++){
            if(edgeCount[i] == 0){
                q.offer(i);
            }
        }

        while (!q.isEmpty()){
            int student = q.poll();

            sb.append(student).append(' ');

            ArrayList<Integer> tmp = graph.get(student);

            for (int i = 0; i < tmp.size(); i++){
                int linkedStudent = tmp.get(i);
                edgeCount[linkedStudent]--;
                if(edgeCount[linkedStudent] == 0){
                    q.offer(linkedStudent);
                }
            }
        }

        System.out.println(sb);
    }
}
