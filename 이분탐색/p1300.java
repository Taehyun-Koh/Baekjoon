package 이분탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p1300 {
    static int N,K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());


        int lo = 1;
        int hi = K;

        while (lo < hi){
            int mid = (lo + hi) / 2;
            

            int cnt = 0;

            for (int i = 1; i<=N; i++){
                cnt += Math.min(mid / i, N);
            }
            // lower bound 적용
            if (K <= cnt){
                hi = mid;
            } else {
                lo = mid + 1;
            }
            
        }
        System.out.println(lo);

    }
}
