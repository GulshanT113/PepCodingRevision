import java.util.PriorityQueue;

public class SortNearlySortedArray extends Basics {
    public static void main(String[] args) {
        int[] arr = input1D();
        int k = scn.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i <= k; i++) {
            pq.add(arr[i]);
        }
        for (int i = k+1; i < arr.length; i++){
            System.out.println(pq.remove() + " ");
            pq.add(arr[i]);
        }
        while (pq.size() > 0) {
            System.out.println(pq.remove() + " ");
        }
    }
}
