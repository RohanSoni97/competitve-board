import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class XorGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        int odd_count=0,even_count=0;
        for(int i=1;i<=test_case;i++)
        {odd_count=0;even_count=0;
            args=br.readLine().split(" ");
            int N=Integer.parseInt(args[0]);
            int Q=Integer.parseInt(args[1]);
            int arr[]=new int[N];
            args=br.readLine().split(" ");
            for(int j=0;j<N;j++)
                arr[j]=Integer.parseInt(args[j]);
            for(int j=0;j<Q;j++){
                int num=Integer.parseInt(br.readLine());
                for(int k=0;k<N;k++){
                    if(countOne(arr[k]^num)==1)
                        even_count++;
                    else odd_count++;
                }
            }
            System.out.println(even_count+" "+odd_count);
        }
    }
    static int countOne(int n)
    {
        int count = 0;
        while (n > 0)
        {
            n = n & (n - 1);
            count++;
        }

        if (count % 2 == 0)
            return 1;
        else
            return 0;
    }

}
