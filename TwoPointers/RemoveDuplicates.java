/*
Jaret Godinez Example problem AlgoMonster
Given a sorted list of numbers, remove duplicates and return the new length. You must do this in-place and without using extra memory.
Input: [0, 0, 1, 1, 1, 2, 2].
Output: 3.
Your function should modify the list in place so that the first three elements become 0, 1, 2. Return 3 because the new length is 3. */



import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class RemoveDuplicates {
    public static int removeDuplicates(List<Integer> arr) {
        int num=-1;
        int counter=0;
        for(int i=0;i<arr.size();i++){
            
            if(arr.get(i)!=num){
                counter++;
                num=arr.get(i);
                arr.set(counter-1,num);
                
            }
        }
        return counter;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type list of ordered numbers seperated by a space");
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        
        scanner.close();
        int res = removeDuplicates(arr);
        System.out.println(arr.stream().limit(res).map(String::valueOf).collect(Collectors.joining(" ")));
    }
}