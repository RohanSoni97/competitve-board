import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Pair{
    int X,Y;

    public Pair(int x, int y) {
        X = x;
        Y = y;
    }
}
public class SUM3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        args = br.readLine().split(" ");
        int N=args.length;
        int arr[]=new int[N];

        for(int i=0;i<N;i++)
        {
            arr[i]=Integer.parseInt(args[i]);
        }
        int target=Integer.parseInt(br.readLine());
        List<Integer> result=closest3(arr);
    }

    private static List<Integer> closest3(int[] arr) {
        Map<Integer, Pair> sum=new HashMap<>();
        for(int i=0;i<arr.length-1;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                sum.put(arr[i]+arr[j],new Pair(i,j));
            }
        }
        return null;
    }

}

//n+n-1+n-2+n-3+...+1=n*(n-1)/2

//public class Solution {
//    public int threeSumClosest(ArrayList<Integer> A, int B) {
//        int res = 0, diff = Integer.MAX_VALUE;
//
//        Collections.sort(A);
//        for(int i = 0; i < A.size() - 2; i++) {
//            int j = i + 1, k = A.size() - 1;
//            while(j < k) {
//                int sum = A.get(i) + A.get(j) + A.get(k);
//
//                if(sum == B) return sum;
//                else if(sum > B) k--;
//                else j++;
//
//                if(Math.abs(B - sum) < diff) {
//                    res = sum;
//                    diff = Math.abs(B - sum);
//                }
//
//            }
//        }
//
//        return res;

        /*
        for(int i = 0; i < A.size(); i++) {
            for(int j = i + 1; j < A.size(); j++) {
                for(int k = j + 1; k < A.size(); k++) {
                    int sum = A.get(i) + A.get(j) + A.get(k);
                    if(sum == B) return sum;
                    if(Math.abs(sum - B) < diff) {
                        res = sum;
                        diff = Math.abs(sum - B);
                    }
                }
            }
        }*/

        //return res;
//    }
//}

