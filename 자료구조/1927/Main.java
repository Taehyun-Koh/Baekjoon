import java.util.*;
import java.io.*;


public class Main {

	static int N;
	
	public static void main(String[] args) throws IOException{

		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				if(!q.isEmpty()) {
					System.out.println(q.poll());
				}
				else {
					System.out.println(0);
				}
				continue;
			}
			q.add(num);
		}
//		MinHeap mh = new MinHeap();
		
		
	}

}