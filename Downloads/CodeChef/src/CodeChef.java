import java.io.*;
import java.util.*;

class CodeChef {

    public static void main (String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int t=Integer.parseInt(br.readLine());
        while(t-->0)
        {
            int n=Integer.parseInt(br.readLine());
            int a[]=new int[n];
            int max=Integer.MIN_VALUE;
            int sidx=-1;
            int eidx=-1;
            String str[]=br.readLine().split(" ");
            for(int i=0;i<n;i++)
            {
                a[i]=Integer.parseInt(str[i]);
                if(a[i]>=max)
                {
                    if(a[i]>max)
                    {
                        max=a[i];
                        sidx=i;

                    }

                    eidx=i;



                }
            }
            int hh=0;
            int k=n/2-sidx;
            if(k>0)
            {
                eidx=eidx+k;

            }

            if(eidx<n)
            {
                if(k<0)
                {
                    k=-k;
                    bw.write((n-eidx+k)+"\n");

                }
                else
                    bw.write((n-eidx)+"\n");

            }

            else
                bw.write(hh+"\n");





        }
        bw.close();
    }
}