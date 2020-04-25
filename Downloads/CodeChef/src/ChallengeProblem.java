import java.io.*;
import java.util.*;
import java.math.*;
class ChallengeProblem
{
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }
        long nextLong()
        {
            return Long.parseLong(next());
        }
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
    public static void main(String[] args)
    {
        FastReader sc=new FastReader();
        StringBuilder sb=new StringBuilder();
        HashMap<Character,Integer> hp=new HashMap<>();
        int n=sc.nextInt();
        int m=sc.nextInt();
        int a=sc.nextInt();
        int x=sc.nextInt();
        int r=sc.nextInt();
        String s=sc.next();
        char[] str=s.toCharArray();
        String[] mel=new String[m];
        int[] mel1=new int[m];
        int op=0;
        int cost=0;
        for(int i=0;i<m;i++)
        {
            mel[i]=sc.next();
            mel1[i]=sc.nextInt();
            if(mel[i].length()==1)
            {
                if(!hp.containsKey(mel[i].charAt(0)))
                    hp.put(mel[i].charAt(0),mel1[i]);
            }
        }
        String[] pi=new String[a];
        int[] pi1=new int[a];
        for(int i=0;i<a;i++)
        {
            pi[i]=sc.next();
            pi1[i]=sc.nextInt();
        }
        if(x>=r)
        {
            for(Character ch: hp.keySet())
            {
                //System.out.println(ch);
                if(op>=99998)
                    break;
                if(Character.isLowerCase(ch))
                {
                    for(int i=0;i<str.length;i++)
                    {
                        if(Character.isLowerCase(str[i]) && ch!=str[i] && (Math.abs(ch-str[i])+cost)<=(x-r))
                        {
                            if((!hp.containsKey(str[i])) || (hp.containsKey(str[i]) && (hp.get(str[i])<hp.get(ch))))
                            {
                                cost+=Math.abs(ch-str[i]);
                                op++;
                                sb.append("1 "+(i+1)+" "+ch).append("\n");
                                str[i]=ch;
                            }
                        }
                    }
                }
                else
                {
                    for(int i=0;i<str.length;i++)
                    {
                        if(Character.isUpperCase(str[i]) && ch!=str[i] && (Math.abs(ch-str[i])+cost)<=(x-r))
                        {
                            if((!hp.containsKey(str[i])) || (hp.containsKey(str[i]) && (hp.get(str[i])<hp.get(ch))))
                            {
                                cost+=Math.abs(ch-str[i]);
                                op++;
                                sb.append("1 "+(i+1)+" "+ch).append("\n");
                                str[i]=ch;
                            }
                        }
                    }
                }
            }
            int ind=-1;
            int sum=0;
            for(int i=0;i<a;i++)
            {
                int temp=0;
                for(int j=0;j<m;j++)
                {
                    if(pi[i].indexOf(mel[j])!=-1)
                    {
                        temp+=mel1[j];
                    }
                }
                if(temp>sum && (cost+pi1[i])<=(x-r))
                {
                    sum=temp;
                    ind=i;
                }
            }
            int temp2=0;
            if(op<99999 && ind!=-1)
            {
                for(int i=0;i<n;i++)
                {
                    if((!hp.containsKey(str[i])) || ((hp.containsKey(str[i]) && (hp.get(str[i])<sum))) && (cost+pi1[ind]<=(x-r)))
                    {
                        op++;
                        cost+=pi1[ind];
                        sb.append("2 "+(i+1)+" "+(i+1)+" "+(ind+1)).append("\n");
                        temp2=i;
                        break;
                    }
                }
            }
        }
        else{
            for(Character ch: hp.keySet())
            {
                //System.out.println(ch);
                if(op>=99999)
                    break;
                if(Character.isLowerCase(ch))
                {
                    for(int i=0;i<str.length;i++)
                    {
                        if(Character.isLowerCase(str[i]) && ch!=str[i] && (Math.abs(ch-str[i])+cost)<=(x))
                        {
                            if((!hp.containsKey(str[i])) || (hp.containsKey(str[i]) && (hp.get(str[i])<hp.get(ch))))
                            {
                                cost+=Math.abs(ch-str[i]);
                                op++;
                                sb.append("1 "+(i+1)+" "+ch).append("\n");
                                str[i]=ch;
                            }
                        }
                    }
                }
                else
                {
                    for(int i=0;i<str.length;i++)
                    {
                        if(Character.isUpperCase(str[i]) && ch!=str[i] && (Math.abs(ch-str[i])+cost)<=(x))
                        {
                            if((!hp.containsKey(str[i])) || (hp.containsKey(str[i]) && (hp.get(str[i])<hp.get(ch))))
                            {
                                cost+=Math.abs(ch-str[i]);
                                op++;
                                sb.append("1 "+(i+1)+" "+ch).append("\n");
                                str[i]=ch;
                            }
                        }
                    }
                }
            }
            int ind=-1;
            int sum=0;
            for(int i=0;i<a;i++)
            {
                int temp=0;
                for(int j=0;j<m;j++)
                {
                    if(pi[i].indexOf(mel[j])!=-1)
                    {
                        temp+=mel1[j];
                    }
                }
                if(temp>sum && (cost+pi1[i])<=(x))
                {
                    sum=temp;
                    ind=i;
                }
            }
            int temp2=0;
            if(op<=99999 && ind!=-1)
            {
                for(int i=0;i<n;i++)
                {
                    if((!hp.containsKey(str[i])) || ((hp.containsKey(str[i]) && (hp.get(str[i])<sum))) && (cost+pi1[ind]<=(x)))
                    {
                        op++;
                        cost+=pi1[ind];
                        sb.append("2 "+(i+1)+" "+(i+1)+" "+(ind+1)).append("\n");
                        temp2=i;
                        break;
                    }
                }
            }
        }
        if(op<100000)
        {
            if((cost+r)<=x)
            {
                sb.append("3 1 "+n);
                cost+=r;
                op++;
            }
        }
        if(op==0)
            System.out.println("0");
        else
        {
            System.out.println(op);
            System.out.println(sb);
        }
    }
}