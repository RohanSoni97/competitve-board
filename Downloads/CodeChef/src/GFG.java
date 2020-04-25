import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

//Java implementation of efficient algorithm to find  
// smaller element on left side  
class GFG {

    // Prints smaller elements on left side of every element
    static void printPrevSmaller(int arr[], int n) {
        // Create an empty stack  
        Stack<Integer> S = new Stack<>();

        // Traverse all array elements
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // Keep removing top element from S while the top  
            // element is greater than or equal to arr[i]  
            while (!S.empty() && S.peek() >= arr[i]) {
                S.pop();
            }

            // If all elements in S were greater than arr[i]  
            if (S.empty()) {
                System.out.print("-1, ");
            } else //Else print the nearest smaller element  
            {
               // System.out.print(S.peek() + ", ");
                list.add(S.peek());
            }

            // Push this element  
            S.push(arr[i]);
        }
    }

    /* Driver program to test insertion sort */
    public static void main(String[] args) {
        int arr[] = {4, 5, 2, 10, 8};
        int n = arr.length;
        printPrevSmaller(arr, n);
    }
}
