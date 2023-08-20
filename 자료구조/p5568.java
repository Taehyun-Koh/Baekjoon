package 자료구조;

import java.io.*;
import java.util.*;


public class p5568 {
    static String[] cards;
    static Set<String> hs = new HashSet<>();
    static int N,K;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        cards = new String[N];
        visited = new boolean[N];

        for (int i = 0; i< N; i++){
            cards[i] = br.readLine();
        }

        selectCard(K,"");
        System.out.println(hs.size());

        
    }

        static void selectCard(int remain, String k){
            if (remain == 0){
                hs.add(k);
                return;
            }
            for (int i = 0; i < N; i++){
                if (!visited[i]){
                    visited[i] = true;
                    selectCard(remain - 1, k + cards[i]);
                    visited[i] = false;
                }
            }
        }
    
}
