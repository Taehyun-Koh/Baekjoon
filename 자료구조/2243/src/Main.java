import java.io.*;
import java.util.*;


public class Main {

    static int S,N,A,B,C;
    static int[] tree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        S = 1;
        while (S<1000000){
            S *= 2;
        }

        tree = new int[S*2];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());

            if (A == 2){
                B = Integer.parseInt(st.nextToken());
                C = Integer.parseInt(st.nextToken());
                update(1,S,1,B,C);
            } else if(A==1){
                B = Integer.parseInt(st.nextToken());
                int ans = query(1,S,1,B);
                System.out.println(ans);
                update(1,S,1,ans,-1);
            }
        }

    }

    static void update(int left, int right, int node, int target, int diff){
        if (target < left || right < target){
            return;
        }else{
            tree[node] += diff;
            if (left != right){
                int mid = (left + right) / 2;
                update(left, mid, node*2, target, diff);
                update(mid + 1, right, node*2+1, target, diff);
            }
        }
    }

    static int query(int left ,int right, int node, int value){
        if (left == right){
            return left;
        } 
        else{
            int mid = (left + right) / 2;
            if(tree[node*2] >= value){
                //왼쪽으로 감
                return query(left,mid,node*2,value);
            }else{
                value -= tree[node*2];
                return query(mid + 1, right, node*2 + 1, value);
            }

        }
    }
}
