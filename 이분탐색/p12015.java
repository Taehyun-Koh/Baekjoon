package 이분탐색;

import java.io.*;
import java.util.*;
public class p12015 {
    static int N;
    static int[] arr;
    static ArrayList<Integer> LIS;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        
        LIS = new ArrayList<>();
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        LIS.add(arr[0]);


        for (int i = 1; i<N; i++){
            int num = arr[i];

            if (LIS.get(LIS.size()-1) < num){
                LIS.add(num);
            }
            else{
                int lo = 0;
                int hi = LIS.size() - 1;

                lo = binarySearch(num,lo,hi);
                LIS.set(lo,num);
            }
            
        }
        System.out.println(LIS.size());

        

    }

    public static int binarySearch(int n, int left, int right){
        if (left > right){
            return left;
        }
        int mid = (left + right) / 2;
        if (LIS.get(mid) > n){
            return binarySearch(n, left, mid-1);
        } else if (LIS.get(mid) < n){
            return binarySearch(n,mid+1, right);
        } else {
            return mid;
        }
        
    }

}
