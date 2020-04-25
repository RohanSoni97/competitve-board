import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test_cases=Integer.parseInt(br.readLine());
        int last_index=0,prev_index=-1,count=0;
        for(int j=0;j<test_cases;j++) {
            int N = Integer.parseInt(br.readLine());
            int arr[] = new int[N];
            count=0;


            prev_index=-1;
            args = br.readLine().split(" ");
            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(args[i]);
            for (int i = 0; i < N; i++) {

                if (arr[i] == 1) {
                    last_index=i;
                    if(prev_index==-1)
                        prev_index=i;
                    else if(last_index-prev_index<=5)
                    {   count=1;
                        break;
                    }
                    prev_index=i;
                }
            }
            if(count==1)
                System.out.println("NO");
            else System.out.println("YES");
        }
    }
}
