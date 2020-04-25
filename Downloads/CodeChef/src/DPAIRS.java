import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class XY{
    int x;
    int y;

    public XY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
public class DPAIRS {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        args=br.readLine().split(" ");
        int N=Integer.parseInt(args[0]);
        int M=Integer.parseInt(args[1]);
        int A[]=new int[N];
        int B[]=new int[M];
        args=br.readLine().split(" ");
        for (int i=0;i<N;i++)
            A[i]=Integer.parseInt(args[i]);
        args=br.readLine().split(" ");
        for (int i=0;i<M;i++)
            B[i]=Integer.parseInt(args[i]);
        int result=N+M-1,count=0;
        HashMap<Integer,XY> hashMap=new HashMap<>();
        for (int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {int sum=0;
                if(!hashMap.containsKey(sum=(A[i]+B[j])))
                {
                    hashMap.put(sum,new XY(i,j));
                    if(++count==result)
                        break;
                }
            }
            if(count==result)
                break;
        }
        hashMap.forEach((k,v)->{
            System.out.println(v.getX()+" "+v.getY());
        });
    }
}
