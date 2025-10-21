/* 
Jaret Godinez AlgoMonster Problem
Fixed Size Sliding Window
Given an array (list) nums consisted of only non-negative integers, find the largest sum among all subarrays of length k in nums.

For example, if the input is nums = [1, 2, 3, 7, 4, 1], k = 3, then the output would be 14 as the largest length 3 subarray sum is given by [3, 7, 4] which sums to 14.

Try it yourself!*/
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class FixedSubarraySum {
    public static int subarraySumFixed(List<Integer> nums, int k) {
        int res=0;
        
        for(int i=0;i<k;i++){
            res+=nums.get(i);
        }
        int sum=res;
        for(int i=k;i<nums.size();i++){
            sum+=nums.get(i);
            sum-=nums.get(i-k);
            if(sum>res){res=sum;}
        }
        return res;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a list of numbers all seperated by a space: ");
        List<Integer> nums = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        System.out.println("Enter the size of the subarray that is going to be added: ");
        int k = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = subarraySumFixed(nums, k);
        System.out.println("THe biggest fixed subarray of length k has the sum of: "+res);
    }
}
