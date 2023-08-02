import java.util.*;
import java.io.*;


class Jewelry{
    int mass;
    int val;
    public Jewelry(int mass, int val) {
        this.mass = mass;
        this.val = val;
    }
    @Override
    public String toString() {
        return "Jewelry [mass=" + mass + ", val=" + val + "]";
    }


    
}
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        Jewelry[] jewels = new Jewelry[N];

        for (int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            jewels[i] = new Jewelry(m, v);
        }

        Arrays.sort(jewels, new Comparator<Jewelry>(){

            @Override
            public int compare(Jewelry o1, Jewelry o2) {
                // TODO Auto-generated method stub
                if (o1.mass == o2.mass) {
                    return o2.val - o1.val;
                }
                return o1.mass-o2.mass;
            }

        });
        
        int[] bags = new int[K];
        for (int i=0; i<K; i++){
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);

        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        long ans = 0;
        int j = 0;
        for (int i = 0; i<K; i++){
            while(j < N && jewels[j].mass <= bags[i]){
                q.add(jewels[j++].val);
            }
            if(!q.isEmpty()){
                ans += q.poll();
            }
        }
        System.out.println(ans);
    }
}
