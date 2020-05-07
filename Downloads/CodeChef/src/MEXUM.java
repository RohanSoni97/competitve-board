import java.util.*;
import java.io.*;
import java.text.*;
class MEXUM{
    //SOLUTION BEGIN
    long MOD = 998244353;
    void pre() throws Exception{}
    void solve(int TC) throws Exception{
        int n = ni();
        long[] a = new long[n];
        for(int i = 0; i< n; i++)a[i] = nl();
        Arrays.sort(a);
        long ans = 0;
        long ways = 1;
        int prev = 0;int idx = 0;
        for(int mex = 1; mex <= n; mex++){
            while(prev+1 < mex){
                int cnt = 0;
                while(idx < n && a[idx] == prev+1){
                    idx++;
                    cnt++;
                }
                ways = mul(ways, add(pow(2, cnt), MOD-1));
                prev++;
            }
            int pos = idx;
            for(int p = idx; p < n && a[p] == mex; p++)pos++;
            ans = add(ans, mul(mex, ways, pow(2, n-pos)));
        }
        pn(ans);
    }
    long pow(long a, long p){
        long o = 1;
        for(; p>0; p>>=1){
            if((p&1)==1)o = mul(o, a);
            a = mul(a, a);
        }
        return o;
    }
    long add(long... a){
        long o = 0;
        for(long x:a)o = (o+MOD+x)%MOD;
        return o;
    }
    long mul(long... a){
        long p = 1;
        for(long x:a)p = (MOD+(p*x)%MOD)%MOD;
        return p;
    }
    //SOLUTION END
    void hold(boolean b)throws Exception{if(!b)throw new Exception("Hold right there, Sparky!");}
    DecimalFormat df = new DecimalFormat("0.00000000000");
    static boolean multipleTC = true;
    FastReader in;PrintWriter out;
    void run() throws Exception{
        in = new FastReader();
        out = new PrintWriter(System.out);
        //Solution Credits: Taranpreet Singh
        int T = (multipleTC)?ni():1;
        pre();for(int t = 1; t<= T; t++)solve(t);
        out.flush();
        out.close();
    }
    public static void main(String[] args) throws Exception{
        new MEXUM().run();
    }
    int bit(long n){return (n==0)?0:(1+bit(n&(n-1)));}
    void p(Object o){out.print(o);}
    void pn(Object o){out.println(o);}
    void pni(Object o){out.println(o);out.flush();}
    String n()throws Exception{return in.next();}
    String nln()throws Exception{return in.nextLine();}
    int ni()throws Exception{return Integer.parseInt(in.next());}
    long nl()throws Exception{return Long.parseLong(in.next());}
    double nd()throws Exception{return Double.parseDouble(in.next());}

    class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws Exception{
            br = new BufferedReader(new FileReader(s));
        }

        String next() throws Exception{
            while (st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch (IOException  e){
                    throw new Exception(e.toString());
                }
            }
            return st.nextToken();
        }

        String nextLine() throws Exception{
            String str = "";
            try{
                str = br.readLine();
            }catch (IOException e){
                throw new Exception(e.toString());
            }
            return str;
        }
    }
}