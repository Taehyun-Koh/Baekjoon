package DP;

import java.io.*;
import java.util.*;

public class p1932 {
    static int N;
    static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i<N; i++){
            // StringTokenizer st = new StringTokenizer(br.readLine());
            String[] tmp = br.readLine().split(" ");
            List<Integer> list = new ArrayList<>();
            if (i == 0) {
                list.add(Integer.parseInt(tmp[0]));
                res.add(list);
                continue;
            }

            for (int j = 0; j<=i; j++){
                int curr = Integer.parseInt(tmp[j]);
                if(j==0){
                    list.add(res.get(i-1).get(0) + curr);
                } else if (j==i){
                    list.add(res.get(i-1).get(j-1) + curr);
                }
                else{
                    int left = res.get(i-1).get(j-1) + curr;
                    int right = res.get(i-1).get(j) + curr;
                    list.add(Math.max(left,right));
                }
            }
            res.add(list);
        }

        System.out.println(Collections.max(res.get(N-1)));
    }
}
