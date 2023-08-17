import java.io.*;
import java.util.*;

public class Main {
    static int[] nums;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[N];
        
        for (int i =0; i<N; i++) nums[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(nums);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i =0; i<M; i++){
            int num = Integer.parseInt(st.nextToken());
            if (binarySearch(num,0,nums.length - 1)){
                System.out.println(1);
            } else{
                System.out.println(0);
            }
        }
    }
    
    //1 2 3 4 5
    public static boolean binarySearch(int n, int left, int right){
        if (left > right) return false;

        int mid = (left+right) / 2;

        if (nums[mid] < n){
            return binarySearch(n, mid+1, right);
        } else if(nums[mid] > n){
            return binarySearch(n,left,mid-1);
        }else{
            return true;
        }
    }
}
