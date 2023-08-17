package 자료구조;

import java.io.*;
import java.util.*;

public class IndexedTree {

    static int N, M, K;
    static long[] nums;
    static long[] tree;

    static int command, param1;
    static long param2;

    static int S;
    static int height = 1; // 트리 출력용

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        // N = Integer.parseInt(st.nextToken());
        // M = Integer.parseInt(st.nextToken());
        // K = Integer.parseInt(st.nextToken());

        nums = new long[N]; // N = 7

        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }

        S = 1;
        while (S < N) {
            S *= 2;
            height += 1; // 트리 출력용
        }
        // S = 8
        tree = new long[S * 2];

        init();
        printTree();
        update(1,S,1,6,-2);
        printTree();
        System.out.println(query(1,S,1,3,10));

    }

    static void init() {
        for (int i = 0; i < N; i++) {
            tree[S + i] = nums[i];
        }
        for (int i = S - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    static long query(int left, int right, int node, int queryLeft, int queryRight) {
        if (queryRight < left || right < queryLeft) {
            return 0;
        } else if (queryLeft <= left && right <= queryRight) {
            return tree[node];
        } else {
            int mid = (left + right) / 2;
            return query(left, mid, node * 2, queryLeft, queryRight) + query(mid + 1, right, node * 2 + 1, queryLeft, queryRight);
        }
    }

    static void update(int left, int right, int node, int target, long diff) {
        if (target < left || right < target) {
            return;
        } else {
            tree[node] += diff;
            if (left != right) {
                int mid = (left + right) / 2;
                update(left, mid, node * 2, target, diff);
                update(mid + 1, right, node * 2 + 1, target, diff);
            }
        }
    }

    static long queryBU(int queryLeft, int queryRight) {
        int left = S + queryLeft - 1;
        int right = (int) (S + queryRight - 1);
        long sum = 0;
        while (left <= right) {
            if (left % 2 == 1) {
                sum += tree[left++];
            }
            if (right % 2 == 0) {
                sum += tree[right--];
            }
            left /= 2;
            right /= 2;
        }
        return sum;
    }

    static void updateBU(int target, long value) {
        int index = S + target - 1;
        tree[index] = value;
        index /= 2;
        while (index > 0) {
            tree[index] = tree[index * 2] + tree[index * 2 + 1];
            index /= 2;
        }
    }

    static void printTree(){
        int index = 1;
        for (int i = 1; i<=height; i++){
            int two = (int) Math.pow(2,i);
            for (int j = index; index<two; j++){
                System.out.print(tree[j]);
                System.out.print(" ");
                
                index = j+1;
            }
            System.out.println();
        }
    }
}