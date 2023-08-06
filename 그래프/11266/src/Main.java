import java.io.*;
import java.util.*;


public class Main {
    static int dfsnCnt = 1; // 방문순서
    static int[] discover; // 방문순서배열
    static boolean[] isCutVertax; // 단절점
    static ArrayList<ArrayList<Integer>> a = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        

        int V = Integer.parseInt(st.nextToken()); //정점개수
        int E = Integer.parseInt(st.nextToken()); //간선개수

        
        for (int i = 0; i <=V; i++){
            a.add(new ArrayList<>());
        }

        for (int i = 0; i<E; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            a.get(A).add(B);
            a.get(B).add(A);
        }

        discover = new int[V+1];
        isCutVertax = new boolean[V+1];

        for (int i = 1; i<=V; i++){
            if(discover[i] == 0) dfs(i,true); // 아직 탐색안된애는 루트로 생각하고 들어감
        }

        int cnt = 0;

        for (int i = 1; i<=V; i++){
            if (isCutVertax[i]){
                sb.append(i).append(" ");
                cnt++;
            }
        }
        System.out.println(cnt);
        System.out.println(sb.toString());


    }

    static int dfs(int vertax, boolean isRoot){

        discover[vertax] = dfsnCnt++;

        int ret = discover[vertax]; // 리턴값 : 올라갈수있는 최소번호

        int childTreeCount = 0; // 분리된 자식 컴포넌트 수

        //자식 검사
        for (int child : a.get(vertax)){
            // 이미 방문 완료한 경우
            if (discover[child] != 0){
                ret = Math.min(ret,discover[child]);
            }
            // 아직 방문 안된 경우 = 새로운 자식 컴포넌트를 탐색 하게 되는 경우
            else{
                childTreeCount++;
                int Ctree = dfs(child, false); // Ctree : 자식을 통해 갈 수 있는 최소 번호
                
                // root가 아니고, 자식트리가 위로가지 못하면 ==> 단절점
                if (Ctree >= discover[child] && !isRoot){
                    isCutVertax[child] = true;
                }

                ret = Math.min(ret, Ctree); // 올라갈 수 있는 최소번호 업데이트
            }
        }

        if (isRoot && childTreeCount >=2){
            isCutVertax[vertax] = true;
        }

        return ret;
    }
}

