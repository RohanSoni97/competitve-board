import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BoxOfChoclates {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test_case=Integer.parseInt(br.readLine());
        int left_sum=0,right_sum=0,max_here=0;
        int arr[];
        for(int i=1;i<=test_case;i++)
        {left_sum=0;right_sum=0;max_here=0;
            int N=Integer.parseInt(br.readLine());
            arr=new int[N];
            args=br.readLine().split(" ");
            for (int l=0;l<N;l++)
                arr[l]=Integer.parseInt(args[l]);
            for (int l=0;l<N/2;l++){
                left_sum+=arr[l];
                right_sum+=arr[N-1-l];
                if(left_sum>right_sum)
                {
                    max_here=l+1;
                }
            }
            System.out.println(max_here);
        }
    }
}
