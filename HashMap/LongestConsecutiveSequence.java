import java.util.HashMap;

public class LongestConsecutiveSequence extends CommonElements {
    public static void main(String[] args) {

        int[] arr = input1D();

        HashMap<Integer, Boolean> hm = new HashMap<>();

        for(int i : arr){
            hm.put(i, true);
        }

        for(int i : arr){
            if(hm.containsKey(i - 1)){
                hm.put(i, false);
            }
        }
        int maxAdd = 0;
        int maxVal = 0;
        for (int i : arr) {
            if(hm.get(i) == true){
                int val = i;
                int add = 1;
                while (hm.containsKey(val + add)) {
                    add++;
                }
                if(add > maxAdd){
                    maxAdd = add;
                    maxVal = val;
                }
            }
        }
        for(int i = 0; i < maxAdd; i++){
            System.out.print(maxVal + i + " ");
        }
    }

}
