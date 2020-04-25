import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MinBasket {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());

        for(int i=1;i<=test_case;i++)
        {
            args=br.readLine().split(" ");
            int N=Integer.parseInt(args[0]);
            int M=Integer.parseInt(args[1]);
            int f[]=new int[N];
            int p[]=new int[N];
            Map<Integer,Integer> values=new HashMap<Integer,Integer>();
                args=br.readLine().split(" ");
                for(int j=0;j<N;j++)
                    f[j]=Integer.parseInt(args[j]);
                args=br.readLine().split(" ");
                for(int j=0;j<N;j++)
                    p[j]=Integer.parseInt(args[j]);
            for(int j=0;j<N;j++)
            {
                if(values.containsKey(f[j]))
                {
                    values.put(f[j],values.get(f[j])+p[j]);
                }
                else {
                    values.put(f[j],p[j]);
                }
            }
            System.out.println(Collections.min(values.values()));
        }
    }
}
