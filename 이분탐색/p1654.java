package 이분탐색;

import java.io.*;
import java.util.*;

public class p1654 {
    static int K;
    static long N;
    static long[] line;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Long.parseLong(st.nextToken());

        line = new long[K];
        for (int i = 0; i<K; i++){
            line[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(line);

        long lo = 1;
        long hi = line[K-1]+1;

        while (lo < hi){
            long mid = (lo + hi) / 2;
            // 개수 부족 -> 더 촘촘하게 자르기
            if (totalLine(mid) < N){
                hi = mid;
            } else{
                lo = mid+1;
            }
        }
        
        // System.out.println(lo-1);
        bw.write((lo-1)+"\n");
        bw.flush();

    }

    public static long totalLine(long num){
        long ans = 0;
        for (int i = 0; i<K; i++){
            
            ans += line[i] / num;

        }

        return ans;
    }
}
