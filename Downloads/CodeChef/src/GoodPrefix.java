import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class GoodPrefix {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test_cases=Integer.parseInt(br.readLine());
        String input;
        int a_z[]=new int[26];
        //Arrays.fill();
        int count=0;
        for (int i=1;i<=test_cases;i++)
        {
            input=br.readLine();
            args=br.readLine().split(" ");
            int K=Integer.parseInt(args[0]);
            int X=Integer.parseInt(args[1]);
            count=0;
            for (int j=0;j<input.length();j++)
            {
                if(a_z[input.charAt(j)-'a']<X)
                {
                    a_z[input.charAt(j)-'a']++;
                    count++;
                }
                else if(K!=0 && a_z[input.charAt(j)-'a']>=X) {
                    K--;
                }
                else if(K==0){
                    break;
                }
            }
            System.out.println(count);
            Arrays.fill(a_z,0);
        }
    }
}
