import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FirstIntBiggerThanTarget {
    public static int firstNotSmaller(List<Integer> arr, int target) {
       
        int left = 0;
        int right = arr.size() - 1;

        if(arr.get(0) >= target){
            return 0;
        }
        while (left <= right) { // <= here because left and right could point to the same element, < would miss it
            int mid = left + (right - left) / 2; // use `(right - left) / 2` to prevent `left + right` potential overflow
            // found target, return its index
            if (arr.get(mid) >= target && (arr.get(mid-1) <target )) return mid;
            if (arr.get(mid) < target) {
                // middle less than target, discard left half by making left search boundary `mid + 1`
                left = mid + 1;
            } else {
                // middle greater than target, discard right half by making right search boundary `mid - 1`
                right = mid - 1;
            }
        }
        return -1;
      //  return -1; // if we get here we didn't hit above return so we didn't find target
    
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input ordered digits seperated by a space then press [Enter]");
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        System.out.println("Input target digit then [Enter]");
        int target = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = firstNotSmaller(arr, target);
        System.out.println("Target found at index :"+res);
    }
}