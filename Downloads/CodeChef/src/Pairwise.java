import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pairwise {
    public static void main(String[] args) throws IOException {
        BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
        args=b.readLine().split(" ");
        int N=args.length;
        int ar[]=new int[N];
        int mod=1000000007;
        int sum=0;
        for (int i=0;i<N;i++)
        {
            ar[i]=Integer.parseInt(args[i]);
        }
        for (int i=0;i<N-1;i++)
        {
            for (int j=i+1;j<N;j++)
            {
                sum+=Integer.bitCount(ar[i]^ar[j]);
            }
            sum%=mod;
        }
        System.out.println((sum*2)%mod);
    }
}
/*
public int cntBits(List<Integer> a) {
        int[] count1=new int[32];
        for (int n:a) {
            for (int i=0; i<32; i++) {
                count1[i]+=n & 1;
                n=n>>1;
            }
        }
        long res=0;
        for (int i=0; i<32; i++) {
            res+=((long)count1[i]*(a.size()-count1[i]))%1000000007;
        }
        return (int)(2*res%1000000007);
    }
 */
