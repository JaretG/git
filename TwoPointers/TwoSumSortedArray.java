/*
Jaret Godinez Algo Monster Example
Two Sum Sorted
Given an array of integers sorted in ascending order, find two numbers that add up to a given target. Return the indices of the two numbers in ascending order. You can assume elements in the array are unique and there is only one solution. Do this in O(n) time and with constant auxiliary space.

Input:

arr: a sorted integer array
target: the target sum we want to reach
Sample Input: [2, 3, 4, 5, 8, 11, 18], 8

Sample Output: 1 3
 */
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class TwoSumSortedArray {
    public static List<Integer> twoSumSorted(List<Integer> arr, int target) {
        int l=0;
        int r=arr.size()-1;
        while(l<=r){
            if(arr.get(l)+arr.get(r)==target){
                return List.of(l,r);
            }else if(arr.get(l)+arr.get(r)>target){
                r--;
            }else{
                l++;
            }
        }
        return null;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sorted list of numbers seperated by spaces");
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        System.out.println("Enter a target sumation");

        int target = Integer.parseInt(scanner.nextLine());
        scanner.close();
        List<Integer> res = twoSumSorted(arr, target);
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(" "))+" are going to be the indexes of the additions");
    }
}