import java.util.HashMap;
import java.util.Scanner;

public class CommonElements {
    public static Scanner scn = new Scanner(System.in);
    public static int[] input1D(){
        int[] arr = new int[scn.nextInt()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] a1 = input1D();
        int[] a2 = input1D();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i : a1){
            if(hm.containsKey(i)){
                int oldFreq = hm.get(i);
                int newFreq = oldFreq + 1;
                hm.put(i, newFreq);
            }
            else {
                hm.put(i, 1);
            }
        }
        for(int i : a2){
            if(hm.containsKey(i)){
                System.out.println(i);
                hm.remove(i);
            }
        }
    }
}
