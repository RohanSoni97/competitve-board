import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MedianArray {
    public static void main(String[] args) throws IOException {
        BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
        args=b.readLine().split(" ");
        int N=args.length;
        int a[]=new int[N];
        for (int i=0;i<N;i++)
        {
            a[i]=Integer.parseInt(args[i]);
        }
        args=b.readLine().split(" ");
        int M=args.length;
        int au[]=new int[M];
        for (int i=0;i<M;i++)
        {
            au[i]=Integer.parseInt(args[i]);
        }
        int total_len=N+M;

        int aux[]=new int[total_len];
        int i=0,j=0,new_len=0;
        total_len/=2;
        while (new_len<total_len+1){
            while (a[i]<=au[j] && new_len<=total_len+1){
                aux[new_len++]=a[i++];
                if(a[i]==au[j]){
                    aux[new_len++]=au[j++];
                }
            }
            while (a[i]>au[j] && new_len<=total_len+1){
                aux[new_len++]=au[j++];
            }
            while (i==N && j<M && new_len<=total_len+1)
            {
                aux[new_len++]=au[j++];
            }
            while (i<N && j==M && new_len<=total_len+1)
            {
                aux[new_len++]=a[i++];
            }
        }
        total_len=N+M;
        if((total_len)%2==0)
        {
            System.out.println((aux[total_len=(total_len/2)]+aux[total_len+1])/2.0);
        }
        else {
            System.out.println(aux[total_len/2]);
        }

    }
}
