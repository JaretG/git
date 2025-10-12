/*Middle of a Linked List
Find the middle node of a linked list.

Input: 0 1 2 3 4

Output: 2

If the number of nodes is even, then return the second middle node.

Input: 0 1 2 3 4 5

Output: 3 */
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

class MiddleOfLinkedList {
    public static class Node<T> {
        public T val;
        public Node<T> next;

        public Node(T val) {
            this(val, null);
        }

        public Node(T val, Node<T> next) {
            this.val = val;
            this.next = next;
        }
    }

    public static int middleOfLinkedList(Node<Integer> head) {
        Node<Integer> currSlow=head;
        Node<Integer> currFast=head;
        int counter=0;
        while(currFast.next!=null){
            currFast=currFast.next;
            counter++;
            if(counter%2!=0){
               currSlow =currSlow.next;
                
            }
        }
        return currSlow.val;
    }

    public static <T> Node<T> buildList(Iterator<String> iter, Function<String, T> f) {
        if (!iter.hasNext()) return null;
        String val = iter.next();
        Node<T> next = buildList(iter, f);
        return new Node<T>(f.apply(val), next);
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type an ordered list starting from 0 going up by 1 ");        Node<Integer> head = buildList(splitWords(scanner.nextLine()).iterator(), Integer::parseInt);
        scanner.close();
        int res = middleOfLinkedList(head);
        System.out.println(res+" is the middle of the linked List");
    }
}