import java.util.*;

public class FactorialRecursion{
    
    public static int calcFactorial(int n){
        if(n==0){//base case
            return 1;
        }else{//Recursion
            return n*calcFactorial(n-1);
        }

    }
    
    public static void main(String[] args){
        
        System.out.print("Enter the number that you want factored:");
        
        Scanner scanner= new Scanner(System.in);
        int n= scanner.nextInt();//Reads the int

        int res=calcFactorial(n);

        System.out.println("The factorial of "+n+" is: " +res);

    }    
}
