package arrays;

import java.util.*;
import java.util.stream.Collectors;

public class BarChart {
    //Using Arrays
/*    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        Integer[] intArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            intArr[i] = scn.nextInt();
        }

        int maxHeight = findMax(n, intArr);

        Integer[] diffArr = new Integer[n];
        for(int i = 0; i<n; i++){
            diffArr[i] = maxHeight - intArr[i];
        }

        for (int i = 0; i < maxHeight; i++) {
            for (int j = 0; j < n; j++) {
                if(i+1 <= diffArr[j]){
                    System.out.print("\t");
                }
                else {
                    System.out.print("*\t");
                }
            }
            System.out.println();
        }
    }

    //Using ArrayList
    public static int findMax(int n, Integer[] intArr){
        int max = intArr[0];
        for (int i = 1; i < n; i++) {
            if(max < intArr[i]){
                max = intArr[i];
            }
        }
        return max;
    }*/

    //Using ArrayList
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        ArrayList<Integer> intList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            intList.add(scn.nextInt());
        }

//        int maxHeight = intList.stream().mapToInt(i -> i).max().orElseThrow(NoSuchElementException::new);
        int maxHeight = Collections.max(intList);

        List<Integer> diffList = intList.stream().map(ele -> maxHeight - ele).collect(Collectors.toList());

        for (int i = 0; i < maxHeight; i++) {
            for (int j = 0; j < n; j++) {
                if(i+1 <= diffList.get(j)){
                    System.out.print("\t");
                }
                else {
                    System.out.print("*\t");
                }
            }
            System.out.println();
        }
    }
}
