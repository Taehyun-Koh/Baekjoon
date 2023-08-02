import java.io.*;
import java.util.*;


public class Main {

    static long T;
    static int[] A,B;
    static int lena,lenb;
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Long.parseLong(br.readLine());
        lena = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < lena; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        lenb = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<lenb; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }
ㅇㄴ


    }
}
