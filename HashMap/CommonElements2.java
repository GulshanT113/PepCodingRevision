import java.util.HashMap;

public class CommonElements2 extends CommonElements{
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
            if(hm.containsKey(i) && hm.get(i) > 0){
                System.out.println(i);
                int oldFreq = hm.get(i);
                int newFreq = oldFreq - 1;
                hm.put(i, newFreq);
            }
        }
    }
}
