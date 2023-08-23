package 이분탐색;

import java.io.*;
import java.util.*;

public class p2110 {
    static int N,C;
    static int[] home;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        home = new int[N];
        
        for (int i = 0; i<N; i++){
            home[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(home);

        int lo = 1;
        int hi = home[N-1] - home[0] + 1;

        while (lo < hi){
            int mid = (lo + hi) / 2;
            // System.out.println("mid = "+mid+" caninstall(mid) = "+canInstall(mid));
            if(canInstall(mid) < C){
                hi = mid;
            }   
            else{
                lo = mid + 1;
            }

        }
        System.out.println(lo-1);
        

    }

    public static int canInstall(int distance){

        int cnt = 1;
        int lastLocate = home[0];

        for (int i = 1; i< N; i++){
            int locate = home[i];

            if (locate - lastLocate >= distance){
                cnt++;
                lastLocate = locate;
            }
        }

        return cnt;
    }
}
