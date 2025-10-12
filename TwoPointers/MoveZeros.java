/* 
Jaret Godinez AlgoMonster Example solved
Move Zeros
Given an array of integers, move all the 0s to the back of the array while maintaining the relative order of the non-zero elements. Do this in-place using constant auxiliary space.

Input:

[1, 0, 2, 0, 0, 7]
Output:

[1, 2, 7, 0, 0, 0]
*/
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class MoveZeros {
    public static void moveZeros(List<Integer> nums) {
        int slow=0;
        for(int i=0;i<nums.size();i++){
            if(nums.get(i)!=0){
                int holder=nums.get(slow);
                nums.set(slow,nums.get(i));
                nums.set(i,holder);
                slow++;
                
            }
            
        }
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a list of numers seperated by Zeros");
        List<Integer> nums = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        moveZeros(nums);
        System.out.println(nums.stream().map(String::valueOf).collect(Collectors.joining(" "))+" is the list with zeros to the right");
    }
}