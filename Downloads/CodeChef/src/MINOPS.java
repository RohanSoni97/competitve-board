
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
class MINOPS
{
    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static FastReader fs;

    static void in(int a[]) {
        for (int i = 0; i < a.length; i++) {
            a[i] = fs.nextInt();
        }
    }

    static void in(long a[]) {
        for (int i = 0; i < a.length; i++) {
            a[i] = fs.nextLong();
        }
    }

    static void in(int a[][]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = fs.nextInt();
            }
        }
    }

    static void sort(int a[]) {
        Arrays.sort(a);
    }

    static void sort(long a[]) {
        Arrays.sort(a);
    }

    static void sort(String a[]) {
        Arrays.sort(a);
    }

    public static void main(String[] args) {
        fs = new FastReader();
        int t = fs.nextInt();
        while (t-- > 0)
        {
            PriorityQueue<Long> pq = new PriorityQueue();
            String s=fs.nextLine();
            String r=fs.nextLine();

            long start=-1,end=0;
            long c=0,range=0;
            for(int i=0;i<s.length();)
            {
                if(s.charAt(i)!=r.charAt(i))
                {
                    int j=i;
                    if(start==-1)
                        start=i;
                    else
                        pq.add(i-end-1);
                    ++range;
                    for(j=i;j<s.length();++j)
                    {
                        if(s.charAt(j)!=r.charAt(j))
                        {
                            ++c;
                            end=j;
                        }
                        else break;
                    }
                    i=j;
                }
                else
                    ++i;
            }
            //System.out.println("Range="+range+" c="+c+" start="+start+" end="+end);
            //System.out.println(pq);
            if(c==0)
            {
                System.out.println("0");
                continue;
            }
            long ans=Long.MAX_VALUE;
            for(long i=range;i>=1;i--)
            {
                ans=Math.min(ans,c*i);
                if(pq.size()>0)
                    c=c+pq.poll();
            }
            System.out.println(ans);
        }

    }

}
