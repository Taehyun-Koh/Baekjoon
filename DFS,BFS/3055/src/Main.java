import java.io.*;
import java.util.*;


public class Main {
    static int R,C;
    static Character[][] map;
    static Queue<String> q = new LinkedList<>();
    static int[] start;
    static int[] end;
    static int[] water;
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for(int i = 0; i< C; i++){
            String s = br.readLine();
            for(int j = 0; j<R; j++){
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'S'){
                    start = new int[j,i];


                }
            }
        }
    }

    static void bfs() {

    }
}
