import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sum3to0
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        args = br.readLine().split(" ");
        int N=args.length;
        //int arr[]=new int[N];
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<N;i++)
        {
            list.add(Integer.parseInt(args[i]));
        }

        int result=sum3to0(list);
        System.out.println(result);
    }

    private static int sum3to0(List<Integer> list) {
        Collections.sort(list);
        int size=list.size();
        int count=0;
        for (int i=0;i<size-2;i++)
        {
            int j=i+1,k=size-1;
            while(j<k) {
                int sum = list.get(i) + list.get(j) + list.get(k);
                if(sum == 0)  count++;
                else if(sum > 0) k--;
                else j++;
            }
        }
        return count;
    }


}
