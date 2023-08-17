package 자료구조;

import java.io.*;
import java.util.*;

public class p7578 {
    static int N,S;
    static long ans;
    static int[] A;
    static long[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j =0; j<N;j++){
            int num = Integer.parseInt(st.nextToken());
            A[j] = num;
        }

        st = new StringTokenizer(br.readLine());
        for (int j =0; j<N;j++){
            int num = Integer.parseInt(st.nextToken());
            hashmap.put(num,j);
        }     
        
        S = 1;
        while(S < N){
            S *= 2;
        }

        tree = new long[S*2];

        ans = 0;
        for (int i = 0; i<N; i++){
            int valA = A[i];
            int valB = hashmap.get(valA);

            ans += query(1,S,1,valB+1,S);

            update(1,S,1,valB,1);
        }

        bw.write(ans+"\n");
        bw.flush();
    }

    public static long query(int left, int right, int node, int queryleft, int queryright){
        if (right < queryleft || queryright < left){
            return 0;
        } else if(queryleft <= left && right <= queryright){
            return tree[node];
        } else{
            int mid = (left + right) / 2;
            return query(left, mid, node*2, queryleft, queryright) + query(mid + 1,right, node*2+1,queryleft,queryright);
        }
    }
    public static void update(int left, int right, int node, int target, int diff){
        if (target < left || right < target){
            return;
        }else{
            tree[node] += diff;
            if (left != right){
                int mid = (left + right) / 2;
                update(left,mid,node*2,target,diff);
                update(mid+1,right,node*2+1,target,diff);
            }
        }
    }

}
