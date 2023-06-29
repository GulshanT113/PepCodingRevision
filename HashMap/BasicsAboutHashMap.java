import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BasicsAboutHashMap {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("delhi", 20);
        hm.put("uttar pradesh", 50);
        hm.put("meerut", 5);
        hm.put("modinagar", 2);
        System.out.println(hm);
        hm.put("meerut", 6);
        System.out.println(hm);
        System.out.println(hm.get("delhi"));
        Set<String> keys = hm.keySet();
        System.out.println(keys);
        for (String key : hm.keySet()){
            System.out.println(key + " " +hm.get(key));
        }
    }
}
