package recursion;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        System.out.println(allPermutaionsOfList(Arrays.asList('a', 'b', 'c')));

    }

    static List<List<Character>> allPermutaionsOfList(List<Character> elements){
        List<List<Character>> empty = new ArrayList<>();
        empty.add(new ArrayList<>());
        if(elements.size() == 0) return empty;

        Character firstEle = elements.get(0);
        List<Character> rest = elements.subList(1, elements.size());

        List<List<Character>> permusWithoutFirst = allPermutaionsOfList(rest);
        List<List<Character>> allPermutations = new ArrayList<>();

        for (List<Character> permu : permusWithoutFirst) {
            for (int i = 0; i <= permu.size(); i++) { // we are running loop i<= permu because we to put firstEle at the end of list one of the case
                // Do same as [...permu.slice(0,i), firstEle, ...permu.slice(i)] of javascript in java
                List<Character> permuWithFirst = new ArrayList<>(permu.subList(0, i));
                permuWithFirst.add(firstEle);
                permuWithFirst.addAll(permu.subList(i, permu.size()));
                allPermutations.add(permuWithFirst);
            }
        }

        return allPermutations;
    }
}
