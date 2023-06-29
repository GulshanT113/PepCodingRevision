import java.util.PriorityQueue;

public class KLargestElements extends Basics {
    public static void main(String[] args) {
        int[] arr = input1D();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int k = scn.nextInt();
        for (int i = 0; i < arr.length; i++) {
            if(i < k) {
                pq.add(arr[i]);
            }
            else {
                if (arr[i] > pq.peek()) {
                    pq.remove();
                    pq.add(arr[i]);
                }
            }
        }
        while (pq.size() > 0){
            System.out.println(pq.remove());
        }
    }
}
