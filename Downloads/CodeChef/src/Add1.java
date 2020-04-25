import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Add1 {
    public static void main(String[] args) {
        int arr[]=new int[]{1,2,3,4,5};
       arr= plusOne(arr);
       for(int i=0;i<arr.length;i++)
       {
           System.out.print(arr[i]);
       }
    }

    private static int[] plusOne(int[] arr) {
        Stack<Integer> stack=new Stack<>();
        int sum=0,carry=0,N=arr.length-1;
        sum=arr[N]+1;
        for(int i=N-1;i>=0;i--)
        {


            stack.push(sum%10);
            carry=(sum/10)%10;
            sum=(arr[i]+carry);

        }

        stack.push(sum%10);
        carry=(sum/10)%10;
        if(carry!=0)
            stack.push(carry);
        while(!stack.empty() && stack.peek()==0)
        {
            stack.pop();
        }
        int i=0;
        int temp[]=new int[stack.size()];
        while (!stack.empty() )
        {
            temp[i++]=stack.pop();
        }

        return temp;
    }
}
