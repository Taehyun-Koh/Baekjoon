//2042 구간합구하기
import java.io.*;
import java.util.*;
public class Main {

    static int N,M,K;
    static long[] nums;
    static long[] tree;

    static int S;

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new long[N];

        for (int i = 0; i<N; i++){
            nums[i] = Long.parseLong(br.readLine());
        }

        S = 1;
        while (S < N){
            S *= 2;
        }

        tree = new long[S*2];

    }

    static void init(){
        for(int i = 0; i<N; i++){
            tree[S+i] = nums[i];
        }

        for(int i = S - 1; i > 0; i--){
            tree[i] = tree[i*2] + tree[i*2+1];
        }
    }

    static long query(int left, int right, int node, int queryLeft, int queryRight){
        if (right < queryLeft || left > queryRight){
            return 0;
        } else if (queryLeft <= left && right <= queryRight){
            return tree[node];
        } else{
            int mid = (left + right) / 2;
            return query(left, mid, node*2, queryLeft, queryRight) + query(mid + 1, right, node*2+1,queryLeft, queryRight);
        }
    }
    
    static void update(int left, int right, int node, int target, int diff){
        if (target < left || right < target){
            return;
        } else {
            tree[node] += diff;
            if (left != right){
                int mid = (left + right) / 2;
                update(left, mid, node*2, target, diff);
                update(mid + 1, right, node*2 + 1, target, diff);
            }
        }
        // return diff;
    }


}
