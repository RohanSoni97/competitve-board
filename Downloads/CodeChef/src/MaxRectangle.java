import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxRectangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        args=br.readLine().split(" ");
        int N=args.length;
        //int arr[]=new int[N];
        List<Integer> list=new ArrayList<>();
        int max = Collections.max(list);
        for(int i=0;i<N;i++)
        {
           list.add(Integer.parseInt(args[i]));
        }
        for (int L = 2; L <= N; L++) {

            // i is row number in cost[][]
            for (int i = 0; i <= N - L + 1; i++) {


            }
        }
            }
}
