package 백트래킹;

import java.io.*;
import java.util.*;


public class p14888 {
    static int N;
    static int[] arr;
    static int plus, minus, multi, divi;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        arr = new int[N];

        for (int i =0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        plus = Integer.parseInt(st.nextToken());
        minus = Integer.parseInt(st.nextToken());
        multi = Integer.parseInt(st.nextToken());
        divi = Integer.parseInt(st.nextToken());

        
    }
}