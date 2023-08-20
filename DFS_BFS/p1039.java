package DFS_BFS;

import java.io.*;
import java.util.*;



public class p1039 {
    public static int[] visited = new int[1000001];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N,K;

        Queue<Integer> q = new LinkedList<>();


        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        String numberStr = Integer.toString(N);
        
        int length = numberStr.length();
        
        q.add(N);

        while (!q.isEmpty() && K>0){
            int size = q.size();
            
            for (int x = 0; x<size; x++){
                int now = q.poll();
                // System.out.println(now);
                //바꾸기
                for (int i =0; i<length-1; i++){
                    for (int j = i+1;  j<length; j++){
                        int next = swap(now,i,j);

                        //앞자리가 0이거나 현재 depth에서 방문한 적이 있는 경우 q add하지않음
                        if(next != 0 && visited[next]!=K) {
                            q.add(next);
                            visited[next] = K;
                        }
                    }
                }
            }
            K--;
        }
        System.out.println(q);
        if(q.isEmpty()) System.out.println(-1);
        else{
            int ans = 0;
            for (int x : q){
                ans = Math.max(x,ans);
            }

            System.out.println(ans);
        }
        
    }
    public static int swap (int now, int i, int j){
        char[] list = String.valueOf(now).toCharArray();
        char tmp = list[i];
        list[i] = list[j];
        list[j] = tmp;

        if(list[0] == '0'){
            return 0;
        }

        return Integer.parseInt(new String(list));
    }
    
}
