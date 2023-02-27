package dynamicProgramming.memoization;

import java.util.*;

public class CombinationSumProblems {
    public static void main(String[] args) {
        Map<Integer, Boolean> memo = new HashMap<>();
//        System.out.println(canSumDP(7, new int[]{2, 4}, memo));
//        System.out.println(canSumDP(7, new int[]{5, 3, 4, 7}, memo));
//        System.out.println(canSumDP(300, new int[]{7, 14}, memo));

//        System.out.println(canSum(7, new int[]{2, 4}));
//        System.out.println(canSum(7, new int[]{5, 3, 4, 7}));
//        System.out.println(canSum(300, new int[]{7, 14}));

//        System.out.println(howSumDP(7, new int[]{2, 4}, new HashMap<>()));
//        System.out.println(howSumDP(7, new int[]{5, 3, 4, 7}, new HashMap<>()));
//        System.out.println(howSumDP(300, new int[]{7, 14}, new HashMap<>()));
//
//        System.out.println(howSum(7, new int[]{2, 4}));
//        System.out.println(howSum(7, new int[]{5, 3, 4, 7}));
//        System.out.println(howSum(300, new int[]{15, 15}));

//        System.out.println(bestSum(7, new int[]{5, 3, 4, 7})); //[7]
//        System.out.println(bestSum(8, new int[]{2, 3, 5})); // [3, 5]
//        System.out.println(bestSum(8, new int[]{1, 4, 5})); // [4, 4]
//        System.out.println(bestSum(100, new int[]{1, 2, 5, 25})); // [25, 25, 25, 25]

//        System.out.println(bestSumDP(7, new int[]{5, 3, 4, 7}, new HashMap<>())); //[7]
//        System.out.println(bestSumDP(8, new int[]{2, 3, 5}, new HashMap<>())); // [3, 5]
//        System.out.println(bestSumDP(8, new int[]{1, 4, 5}, new HashMap<>())); // [4, 4]
//        System.out.println(bestSumDP(100, new int[]{1, 2, 5, 25}, new HashMap<>())); // [25, 25, 25, 25]

//        System.out.println(allSum(7, new int[]{5, 3, 4, 7})); //[7], [3, 4]
        System.out.println(allSum(8, new int[]{2, 3, 5})); // [3, 5], [2, 2, 2, 2], [2, 3, 3]
//        System.out.println(allSum(8, new int[]{1, 4, 5})); // [4, 4]
//        System.out.println(allSum(100, new int[]{1, 2, 5, 25})); // [25, 25, 25, 25]

    }

    // Recursive brute-force approach
    static boolean canSum(int target, int[] candidates){
        if(target == 0) return true;
        if(target < 0) return false;

        for (int candidate: candidates) {
            int remainingTarget = target - candidate;
            boolean res = canSum(remainingTarget, candidates);
            if(res) return true;
        }
        return false;
    }

    //Optimized recursive approach using DP and memoization
    static boolean canSumDP(int target, int[] candidates, Map<Integer, Boolean> memo){
        if(memo.containsKey(target)) return memo.get(target);
        if(target == 0) return true;
        if(target < 0) return false;

        for (int candidate: candidates) {
            int remainingTarget = target - candidate;
            boolean res = canSumDP(remainingTarget, candidates, memo);
            memo.put(remainingTarget, res);
            if(res) return true;
        }

        return false;
    }

    // Brute force approach
    // n = target
    // m = candidates.length
    // Time Complexity: O(n^m*m)
    // Space Complexity: O(m)
    //Description: Find the first combination (in an array) that adds up to target sum
    static List<Integer> howSum(int target, int[] candidates){
        if(target == 0) return new ArrayList<>();
        if(target < 0) return null;

        for (int candidate : candidates) {
            int remainder = target - candidate;
            var remainderResult = howSum(remainder, candidates);

            if(remainderResult != null){
                remainderResult.add(candidate);
                return remainderResult;
            }
        }

        return null;
    }

    // Memoization approach
    // n = target
    // m = candidates.length
    // Time Complexity: O(n*m*m) -> O(n*m^2)
    // Space Complexity: O(m*m) -> O(m^2)
    //Description: Find the first combination (in an array) that adds up to target sum
    static List<Integer> howSumDP(int target, int[] candidates, Map<Integer, List<Integer>> memo){
        if(memo.containsKey(target)) return memo.get(target);
        if(target == 0) return new ArrayList<>();
        if(target < 0) return null;

        for (int candidate : candidates) {
            int remainder = target - candidate;
            var remainderResult = howSumDP(remainder, candidates, memo);
            if(remainderResult != null){
                remainderResult.add(candidate);
                memo.put(remainder, remainderResult);
                return remainderResult;
            }
        }
        memo.put(target, null);
        return null;
    }

    // Brute force approach
    // n = target
    // m = candidates.length
    // Time Complexity: O(n^m*m) -> O(n*m^2)
    // Space Complexity: O(m^2)
    //Description: Find the best combination (in an array having least length) that adds up to target sum
    static List<Integer> bestSum(int target, int[] candidates){
        if(target == 0) return new ArrayList<>();
        if(target < 0) return null;

        List<Integer> shortestCombination = null;

        for (int candidate: candidates) {
            int remainder = target - candidate;
            var currentCombination = bestSum(remainder, candidates);
            if(currentCombination != null){
                currentCombination.add(candidate);
                if(shortestCombination == null || currentCombination.size() < shortestCombination.size()){
                    shortestCombination = currentCombination;
                }
            }

        }

        return shortestCombination;
    }

    // Memoization approach
    // n = target
    // m = candidates.length
    // Time Complexity: O(n*m*m) -> O(n*m^2)
    // Space Complexity: O(m*m) -> O(m^2)
    //Description: Find the best combination (in an array having least length) that adds up to target sum
    static List<Integer> bestSumDP(int target, int[] candidates, Map<Integer, List<Integer>> memo){
        if(memo.containsKey(target)) return memo.get(target);
        if(target == 0) return new ArrayList<>();
        if(target < 0) return null;

        List<Integer> shortestCombination = null;

        for (int candidate: candidates) {
            int remainder = target - candidate;
            var currentCombination = bestSumDP(remainder, candidates, memo);
            if(currentCombination != null){
                List<Integer> combination = new ArrayList<>(currentCombination);  // Do not alter the currentCombination array instead a new list called combination
                combination.add(candidate);
                if(shortestCombination == null || combination.size() < shortestCombination.size()){
                    shortestCombination = combination;
                }
            }

        }
        memo.put(target, shortestCombination);
        return shortestCombination;
    }

    /*
    * Approach
        While inside recursion call:

        Check if the target is reached if not continue.
        If target is reached in a negative value return as no solution is found.
        Use for loop to access every element from candidates using the start index.
        Backtrack every possible solution from the chosen element.
        Complexity
        Time complexity: O((2^n)*n)
        Space complexity: O(n)
    * */
    // Using backtracking


    public static List<List<Integer>> allSum(int target, int[] candidates){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currCombination = new ArrayList<>();
        allPossibleSum(target, candidates, result, currCombination, 0);
//        System.out.println(allPossibleSum2(target, candidates, target));
        return result;
    }


    public static void allPossibleSum(int target, int[] candidates, List<List<Integer>> ans, List<Integer> currCombination, int start){
        if(target==0)
        {
            ans.add(new ArrayList<>(currCombination));
            return;
        }
        if(target<0)
            return;
        for(int i=start;i<candidates.length;++i)
        {
            currCombination.add(candidates[i]);
            allPossibleSum(target-candidates[i], candidates, ans, currCombination,i);
            currCombination.remove(currCombination.size()-1);
        }
    }

//    static List<List<Integer>> result = new ArrayList<>();
//    public static List<Integer> allPossibleSum2(int target, int[] candidates, int finalTarget){
//        if(target == 0) return new ArrayList<>();
//        if(target < 0) return null;
//
//        List<Integer> allCombination = null;
//
//        for (int candidate: candidates) {
//            int remainder = target - candidate;
//            var currentCombination = allPossibleSum2(remainder, candidates, finalTarget);
//            if(currentCombination != null){
//                List<Integer> combination = new ArrayList<>(currentCombination);  // Do not alter the currentCombination array instead a new list called combination
//                combination.add(candidate);
////                allCombination = combination;
////                if(shortestCombination == null || currentCombination.size() < shortestCombination.size()){
////                    shortestCombination = currentCombination;
////                }
//                if(combination.stream().mapToInt(Integer::intValue).sum() == finalTarget){
////                    result.add(allCombination);
//                    result.add(combination);
//                }
////                return combination;
//                allCombination = new ArrayList<>(combination);
//            }
//
//        }
//
//        return allCombination;
//    }
}
