import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Codechef ob=new Codechef();
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(T=T;T>0;T--)
        {
            int n=sc.nextInt(),a[]=new int[n],i,MOD=1000000007;
            double ans=1;
            for(i=0;i<n;i++)
            {
                a[i]=sc.nextInt();
            }
            for(i=0;i<n-1;i++)
            {
                if(a[i+1]<a[i])
                {ans=0;break;}
                ans=(ans*Math.pow(2,ob.result(a[i],a[i+1])))%MOD;
            }
            System.out.println((long)ans);
        }
    }
    int result(int x,int y)
    {
        int z=x&y;
        int c=0;
        while(z>0)
        {
            z=z&(z-1);
            c++;
        }
        return(c);
    }
}