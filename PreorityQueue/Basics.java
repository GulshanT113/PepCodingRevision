import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Basics {
    public static Scanner scn = new Scanner(System.in);
    public static int[] input1D() {
        int[] arr = new int[scn.nextInt()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        return arr;
    }
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] arr = input1D();
        for(int i : arr){
            pq.add(i);
        }
        while (pq.size() > 0){
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}
