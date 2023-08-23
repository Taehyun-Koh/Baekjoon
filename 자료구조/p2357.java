package 자료구조;

import java.io.*;
import java.util.*;

public class p2357 {
    static int N,M;
    static int S;
    static int[] arr,treeMax, treeMin;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        S = 1;
        while (S < N){
            S *= 2;
        }
        treeMax = new int[S*2];
        treeMin = new int[S*2];
        arr = new int[N];

        for (int i =0 ; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.fill(treeMin, Integer.MAX_VALUE);

        initMax();
        initMin();


        for (int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(queryMin(1,S,1,a,b) + " " + queryMax(1,S,1,a,b) + "\n");
        }
        bw.flush();
        
       
    }

    public static void initMax(){

        for (int i = 0; i<N; i++){
            treeMax[S + i] = arr[i];
        }

        for (int i = S-1; i>0; i--){
            treeMax[i] = Math.max(treeMax[i*2],treeMax[i*2+1]);
        }
    }
    public static void initMin(){

        for (int i = 0; i<N; i++){
            treeMin[S + i] = arr[i];
        }

        for (int i = S-1; i>0; i--){
            treeMin[i] = Math.min(treeMin[i*2],treeMin[i*2+1]);
        }
    }

    public static int queryMax(int left, int right, int node, int queryLeft, int queryRight){
        // if (left > right){
        //     return 0;
        // }

        int mid = (left + right) / 2;
        if (queryLeft > right || queryRight < left){
            return 0;
        } else if(queryLeft <= left && right <= queryRight){
            return treeMax[node];
        } else{
            return Math.max(queryMax(left,mid,node*2,queryLeft,queryRight), queryMax(mid+1,right,node*2+1,queryLeft,queryRight));
        }
    }
    public static int queryMin(int left, int right, int node, int queryLeft, int queryRight){
        // if (left > right){
        //     return 0;
        // }

        int mid = (left + right) / 2;

        if (queryLeft > right || queryRight < left){
            return Integer.MAX_VALUE;
        } else if(queryLeft <= left && right <= queryRight){
            return treeMin[node];
        } else{
            return Math.min(queryMin(left,mid,node*2,queryLeft,queryRight), queryMin(mid+1,right,node*2+1,queryLeft,queryRight));
        }
    }
}
