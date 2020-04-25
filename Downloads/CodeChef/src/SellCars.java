import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SellCars {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        final int mod=1000000007;
        int test_case=Integer.parseInt(br.readLine());
        int profit;
        for (int i=0;i<test_case;i++)
        {
            int N=Integer.parseInt(br.readLine());
            args=br.readLine().split(" ");
            int arr[]=new int[N];

            for (int j=0;j<N;j++)
                arr[j]=Integer.parseInt(args[j]);
            Arrays.sort(arr);
            profit=arr[N-1];
            int k;
            for(int j=N-2;j>=0;j--){
                if((k=(arr[j]-(N-(j+1))))>0)
                {
                    profit+=k;
                }
                else {
                    break;
                }
                profit%=mod;
            }
            System.out.println(profit);
        }
    }
}
