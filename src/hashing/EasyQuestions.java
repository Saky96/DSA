package hashing;

import java.util.HashSet;

public class EasyQuestions {
    public static void main(String[] args) {
        int[] arr = {10, 11, 15, 88, 15, 10, 19, 11};
        int[] arr2 = {10, 22, 12, 11};
        System.out.println(countDistinct(arr));
        System.out.println(unionOfArrays(arr, arr2));
        System.out.println(intersectionOfArrays(arr, arr2));
    }

    static int countDistinct(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        for (int ele: arr) {
            set.add(ele);
        }

        return set.size();
    }

    static int unionOfArrays(int[] arr1, int[] arr2){
        HashSet<Integer> set = new HashSet<>(arr1.length + arr2.length);

        for (int ele: arr1) {
            set.add(ele);
        }

        for (int ele: arr2) {
            set.add(ele);
        }

        System.out.println(set);

        return set.size();
    }

    static int intersectionOfArrays(int[] arr1, int[] arr2){
        HashSet<Integer> set = new HashSet<>();
        int count=0;
        for (int ele: arr1) {
            set.add(ele);
        }

        for (int ele: arr2) {
            if(set.contains(ele)){
                count++;
                set.remove(ele);
            }
        }

        return count;
    }
}
