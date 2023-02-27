package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
//        List<List<Character>> empty = new ArrayList<>();
//        empty.add(new ArrayList<>());
//        System.out.println(empty);
        System.out.println(allCombinationsOfList(Arrays.asList('a', 'b', 'c')));
    }

    static List<List<Character>> allCombinationsOfList(List<Character> elements){
        List<List<Character>> empty = new ArrayList<>();
        empty.add(new ArrayList<>());
        if(elements.size() == 0) return empty;

        Character firstEle = elements.get(0);
        List<Character> restElements = elements.subList(1, elements.size());

        List<List<Character>> combWithoutFirst = allCombinationsOfList(restElements);
        List<List<Character>> combWithFirst = new ArrayList<>();

        // Loop to combine all the combinations without first element with the first element
        for (var comb: combWithoutFirst) {
            var combineFirst = new ArrayList<>(comb);
            combineFirst.add(firstEle);
            combWithFirst.add(combineFirst);
        }

        // Combining both the lists to get the final answer
        combWithoutFirst.addAll(combWithFirst);
        return new ArrayList<>(combWithoutFirst);
    }
}
