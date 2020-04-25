import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ARTBALAN {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test_case=Integer.parseInt(br.readLine());
        for(int i=0;i<test_case;i++) {
            String input=br.readLine();
            int A_Z[]=new int[26];
            int result=0,operation=0;
            Arrays.fill(A_Z,0);
            for(int j=0;j<input.length();j++)
               {
                  A_Z[input.charAt(j)-'A']++;
               }
            for(int j=0;j<26;j++)
            {
             if(A_Z[j]!=0 && A_Z[j]%2!=0)
             {
                 if(result!=0) {
                     result=0;
                 }
                 else {
                     result++;
                     operation++;
                 }
             }
            }

            System.out.println(operation);
        }
    }
}
