import java.util.*;
import java.lang.*;
import java.io.*;
public class MAGICJAR {
    public static void main (String[] args) throws java.lang.Exception
    {
        long t,n;
        Scanner scan=new Scanner(System.in);
        t=scan.nextLong();
        while(t--!=0){
            n=scan.nextLong();
            long sm=0;
            for(int i=0;i<n;++i)
            {
                sm=sm+scan.nextLong();
            }
            System.out.println(sm-n+1);
        }
    }
}
