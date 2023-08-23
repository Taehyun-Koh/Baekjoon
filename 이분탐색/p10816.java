package 이분탐색;

import java.io.*;
import java.util.*;

public class p10816 {
    static int N,M;
    static int[] arr,numCheck;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        Arrays.sort(arr);
        for (int i = 0; i<M; i++){
            int num = Integer.parseInt(st.nextToken());
            sb.append((upperBound(arr, num) - lowerBound(arr, num)) + " ");
        }
        System.out.println(sb);
        
    }

    static int lowerBound(int[] arr, int key){
        int lo = 0;
        int hi = arr.length;

        while (lo < hi){
            int mid = (lo + hi) / 2;

            if (key <= arr[mid]){
                hi = mid;
            } else{
                lo = mid+1;
            }
        }

        return lo;
    }

    static int upperBound(int[] arr, int key){
        int lo = 0;
        int hi = arr.length;

        while (lo < hi){
            int mid = (lo + hi) / 2;

            if (key < arr[mid]){
                hi = mid;
            } else{
                lo = mid+1;
            }
        }

        return lo;
    }
}
