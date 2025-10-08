import java.util.Scanner;

//Just gives you the squre root without the decimal

public class SquareRootEstimation{
    public static int squareRoot(int n){
        if(n==0)return 0;
        int right=n;
        int left=1;
        int res=-1;
        
        while(left<=right){
            int mid=left+(right-left)/2;
            if(mid==n/mid){
                return mid;
            }else if(mid>n/mid){
                right=mid-1;
                res=mid;
            }else{
                left=mid+1;
            }
        }
        return res-1;
    }
    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res=squareRoot(n);
        System.out.println(res);
        
    }
}