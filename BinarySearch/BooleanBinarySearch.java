import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class BooleanBinarySearch {
    public static int findBoundary(List<Boolean> arr) {
        int left = 0;
        int right = arr.size() - 1;

        if(arr.get(0) == true){
            return 0;
        }
        while (left <= right) { // <= here because left and right could point to the same element, < would miss it
            int mid = left + (right - left) / 2; // use `(right - left) / 2` to prevent `left + right` potential overflow
            // found target, return its index
            if (arr.get(mid) == true && (arr.get(mid-1) !=true )) return mid;
            if (arr.get(mid) == false) {
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
        System.out.println("Input a list of as many fasle and true in that order then press [Enter] ");
        List<Boolean> arr = splitWords(scanner.nextLine()).stream().map(v -> v.equals("true")).collect(Collectors.toList());
        scanner.close();
        int res = findBoundary(arr);
        System.out.println("The first True will be found at index: "+res);
    }
}