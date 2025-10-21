/*
Jaret Godinez AlgoMonster Problem
Valid Palindrome
Determine whether a string is a palindrome, ignoring non-alphanumeric characters and case. Examples:

Input: Do geese see God? Output: True

Input: Was it a car or a cat I saw? Output: True

Input: A brown fox jumping over Output: False */
import java.util.Scanner;

class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        int l=0;
        int r=s.length()-1;
        while(l<r){
            while(l<r && !Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }
            while(l<r && !Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }
           if(Character.toLowerCase(s.charAt(r))!=Character.toLowerCase(s.charAt(l))){return false;}
            l++;
            r--;
            
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a phrase,not case-sensitive and only characters will be accounted for: ");
        String s = scanner.nextLine();
        scanner.close();
        boolean res = isPalindrome(s);
        System.out.println("It's "+res+" that this phrase is a palindrome");
    }
}
