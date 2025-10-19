/*
Jaret Godinez Exercice from Algo Monster
Container With Most Water
Given an array representing heights of vertical lines, find the maximum area of water trapped between two lines.

Input: [1,8,6,2,5,4,8,3,7].

Output: 49. */
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class ContainerWithMostWater{
    public static int containerWithMostWater(List<Integer> arr) {
        int l=0;
        int r=arr.size()-1;
        int maxArea=0;
        while(l<r){
            if((r-l)*Math.min(arr.get(l),arr.get(r))>maxArea){
                maxArea=(r-l)*Math.min(arr.get(l),arr.get(r));
            }
            if(arr.get(r)>arr.get(l)){
                l++;
            }else{
                r--;
            }
            
        }
        return maxArea;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a list of integers seperated by a space: ");
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        int res = containerWithMostWater(arr);
        System.out.println("The biggest area of water that can be held is: "+res);
    }
}