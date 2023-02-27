import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
        int[] arr = {1, 2, 3, 1, 2};
        Map<Integer, Integer> numMap = new HashMap<>();
        for(int num: arr){
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }

        int maxValue = 0;
        int maxKey = 0;
        for(Map.Entry<Integer, Integer> entry: numMap.entrySet()){
            if(entry.getValue() > maxValue){
                maxKey = entry.getKey();
                maxValue = entry.getValue();
            }
        }

        System.out.println(numMap);
        System.out.println(maxKey);
    }
}