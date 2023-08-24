package 백트래킹;

import java.io.*;
import java.util.*;


public class p14889 {
    static int N;
    static int cnt = 0;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];

        for (int i =0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j =0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                
            }
        }

        combi(0,0);
        System.out.println(min);
    }
    public static void combi(int idx, int count){
        if (count == N/2){
            System.out.println(Arrays.toString(visited));
            diff();
            return;
        }

        for (int i = idx; i<N; i++){
            if(!visited[i]){
                visited[i] = true;

                combi(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }

    public static void diff(){
        int teamA = 0;
        int teamB = 0;
        for (int i =0; i<N-1; i++){
            for (int j = i; j< N; j++){
                if (visited[i] == true && visited[j] == true){
                    teamA += arr[i][j];
                    teamA += arr[j][i];
                } else if(visited[i] == false && visited[j] == false){
                    teamB += arr[i][j];
                    teamB += arr[j][i];
                }
            }
        }

        int diff = Math.abs(teamA - teamB);
        min = Math.min(min,diff);
    }
}
