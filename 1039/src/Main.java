import java.io.*;
import java.util.*;



public class Main {
    static int K, maxv;
    static String[] N;
    static int[] big;
    static Queue<Integer> q = new LinkedList<>();
    static int[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = st.nextToken().split("");
        K = Integer.parseInt(st.nextToken());
        big = new int[2];
        maxv = 0;
        for (int k = 0 ; k<K; k++){
            for (int i = N.length - 1; i>=0; i--){
                if (Integer.parseInt(N[i]) > maxv){
                    big[0] = Integer.parseInt(N[i]);
                    big[1] = i;
                }
            }
        }
        
    }
}
