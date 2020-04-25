import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UniqueSubsequnces {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_cases=Integer.parseInt(br.readLine());

        String input;
        for (int i=1;i<=test_cases;i++)
        {
            int N=Integer.parseInt(br.readLine());
            input=br.readLine();
            int count=1,max_here=0;
            for (int j=0;j<N-1;j++)
            {
                if(input.charAt(j)!=input.charAt(j+1))
                {
                    count+=1;
                }
                else {
                    count=1;
                }
                if(max_here<count)
                    max_here=count;
            }
            System.out.println(max_here);
        }
    }
}
