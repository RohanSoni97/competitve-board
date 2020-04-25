import java.io.*;
import java.util.*;
class maxremove
{
    public static void main(String args[])throws IOException
    {
        Reader sc=new Reader();
        int t=sc.nextInt();
        for(int z=1;z<=t;z++)
        {
            int n=sc.nextInt();
            int k=sc.nextInt();
            List<Integer> klist=new ArrayList<>();
            List<Integer> kplus=new ArrayList<>();
            int left[]=new int[n];
            int right[]=new int[n];
            int max=0;
            for(int i=0;i<n;i++)
            {
                left[i]=sc.nextInt();
                right[i]=sc.nextInt();
                max=Math.max(max,right[i]);
            }
            int arr[]=new int[max+2];
            for(int i=0;i<n;i++)
            {
                arr[left[i]]++;
                arr[right[i]+1]--;
            }
            for(int i=1;i<=max;i++)
            {
                arr[i]+=arr[i-1];
                if(arr[i]==k)
                    klist.add(i);
                if(arr[i]==k+1)
                    kplus.add(i);
            }
            int numk=klist.size(),res=0;
            for(int i=0;i<n;i++)
            {
                int ind1=Collections.binarySearch(kplus,right[i]);
                int ind2=Collections.binarySearch(kplus,left[i]-1);
                if(ind1<0)
                    ind1=ind1*-1 -2;
                if(ind2<0)
                    ind2=ind2*-1 -2;
                int kp=ind1-ind2+numk;
                ind1=Collections.binarySearch(klist,right[i]);
                ind2=Collections.binarySearch(klist,left[i]-1);
                if(ind1<0)
                    ind1=ind1*-1 -2;
                if(ind2<0)
                    ind2=ind2*-1 -2;
                res=Math.max(res,kp-(ind1-ind2));

            }
            System.out.println(res);
        }
    }
}
//import java.io.*;
class Reader {
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte [] buffer;
    private int bufferPointer, bytesRead;

    public Reader () {
        din = new DataInputStream (System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public Reader (String file_name) throws IOException {
        din = new DataInputStream (new FileInputStream (file_name));
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public String readLine () throws IOException {
        byte [] buf = new byte[1024];
        int cnt = 0, c;
        while ((c = read ()) != -1) {
            if (c == '\n')
                break;
            buf[cnt++] = (byte) c;
        }
        return new String (buf, 0, cnt);
    }

    public int nextInt () throws IOException {
        int ret = 0;
        byte c = read ();
        while (c <= ' ')
            c = read ();
        boolean neg = (c == '-');
        if (neg)
            c = read ();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read ()) >= '0' && c <= '9');
        if (neg)
            return -ret;
        return ret;
    }

    public long nextLong () throws IOException {
        long ret = 0;
        byte c = read ();
        while (c <= ' ')
            c = read ();
        boolean neg = (c == '-');
        if (neg)
            c = read ();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read ()) >= '0' && c <= '9');
        if (neg)
            return -ret;
        return ret;
    }

    public double nextDouble () throws IOException {
        double ret = 0, div = 1;
        byte c = read ();
        while (c <= ' ')
            c = read ();
        boolean neg = (c == '-');
        if (neg)
            c = read ();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read ()) >= '0' && c <= '9');
        if (c == '.')
            while ((c = read ()) >= '0' && c <= '9')
                ret += (c - '0') / (div *= 10);
        if (neg)
            return -ret;
        return ret;
    }

    private void fillBuffer () throws IOException {
        bytesRead = din.read (buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }

    private byte read () throws IOException {
        if (bufferPointer == bytesRead)
            fillBuffer ();
        return buffer[bufferPointer++];
    }

    public void close () throws IOException {
        if (din == null)
            return;
        din.close ();
    }
}
