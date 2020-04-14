import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DEPCHEF {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test_case=Integer.parseInt(br.readLine());
        int result=-1;
        for(int i=0;i<test_case;i++)
        {
            result=-1;
            int N=Integer.parseInt(br.readLine());
            int attack[]=new int[N];
            int defense[]=new int[N];
            args=br.readLine().split(" ");
            for (int j=0;j<N;j++)
                attack[j]=Integer.parseInt(args[j]);
            args=br.readLine().split(" ");
            for (int j=0;j<N;j++)
               defense[j]=Integer.parseInt(args[j]);
            if(defense[0]-(attack[N-1]+attack[1])>0)
                result=defense[0];
            for(int j=1;j<N;j++)
            {
                if(j!=N-1)
                {
                    if(defense[j]-(attack[j-1]+attack[j+1])>0){
                        if(result<defense[j]){
                            result=defense[j];
                        }
                    }
                }else {
                    if(defense[j]-(attack[j-1]+attack[0])>0){
                        if(result<defense[j]){
                            result=defense[j];
                        }
                    }
                }
            }
            System.out.println(result);
        }
    }
}
