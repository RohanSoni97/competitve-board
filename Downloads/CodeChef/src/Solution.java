import java.io.IOException;
import java.io.InputStream;
import java.util.*;


class Solution {
    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader(System.in);
        StringBuilder sb = new StringBuilder();
        int i,j;
        int t=in.nextInt();
        while(t-->0){
            int n=in.nextInt();
            int q=in.nextInt();
            long arr[]=new long[n];
            for(i=0;i<n;i++)
                arr[i]=in.nextInt();
            SegmentTree st=new SegmentTree(arr);
            while(q-->0){
                char ch=in.next().charAt(0);
                int a=in.nextInt();
                int b=in.nextInt();
                if(ch=='U') {
                    a--;
                    st.update1(a,n-1,b-arr[a]);
                    st.update2(0,a,b-arr[a]);
                    arr[a]=b;
                }
                else{
                    a--;
                    b--;
                    long sum1=0,sum2,tsum;
                    if(a!=0)
                        sum1=st.query1(a-1,a-1);
                    sum2=st.query1(b,b);
                    //System.out.println(sum1+" "+sum2);
                    tsum=sum2-sum1;
                    long max1=st.query1(b,n-1);
                    long max2=st.query2(0,a);
                    long sum11=st.query2(a,a);
                    //System.out.println(max1+" "+sum2+" "+max2+" "+sum11);
                    tsum+=max1-sum2+max2-sum11;
                    sb.append(tsum).append("\n");

                }
            }
        }
        System.out.print(sb);

    }
}

class SegmentTree {
    long tree1[],tree2[], lazy1[],lazy2[];
    int N;

    public SegmentTree(long arr[]) {
        N = 1;
        while (N < arr.length)
            N = N * 2;
        tree1 = new long[2 * N - 1];
        lazy1 = new long[2 * N - 1];
        tree2 = new long[2 * N - 1];
        lazy2 = new long[2 * N - 1];
        Arrays.fill(tree1,Long.MIN_VALUE/100);
        Arrays.fill(tree2,Long.MIN_VALUE/100);
        tree1[N-1]=arr[0];
        tree2[arr.length+N-2]=arr[arr.length-1];
        for (int i = 1; i < arr.length; i++) {
            tree1[i + N - 1] = arr[i]+tree1[i+N-2];
        }
        for(int i=arr.length-2;i>=0;i--){
            tree2[i + N - 1] = arr[i]+tree2[i+N];
        }
        for (int i = N - 2; i >= 0; i--) {
            tree1[i] = Math.max(tree1[2 * i + 1] , tree1[2 * i + 2]);
            tree2[i] = Math.max(tree2[2 * i + 1] , tree2[2 * i + 2]);
        }


    }

    public void push1(int i, int s, int e) {
        if (lazy1[i] != 0) {
            tree1[i] += lazy1[i];
            if (s != e) {
                lazy1[2 * i + 1] += lazy1[i];
                lazy1[2 * i + 2] += lazy1[i];
            }
            lazy1[i] = 0;
        }
    }
    public void push2(int i, int s, int e) {
        if (lazy2[i] != 0) {
            tree2[i] += lazy2[i];
            if (s != e) {
                lazy2[2 * i + 1] += lazy2[i];
                lazy2[2 * i + 2] += lazy2[i];
            }
            lazy2[i] = 0;
        }
    }

    public long query1(int l, int r) {
        return query1(0, 0, N - 1, Math.min(l, r), Math.max(l, r));
    }

    public long query1(int i, int s, int e, int l, int r) {
        push1(i, s, e);
        if (l > e || r < s || s > e)
            return Long.MIN_VALUE;
        if (s >= l && e <= r) {
            return tree1[i];
        }
        int mid = (s + e) / 2;
        return Math.max(query1(2 * i + 1, s, mid, l, r) , query1(2 * i + 2, mid + 1, e, l, r));
    }
    public long query2(int l, int r) {
        return query2(0, 0, N - 1, Math.min(l, r), Math.max(l, r));
    }

    public long query2(int i, int s, int e, int l, int r) {
        push2(i, s, e);
        if (l > e || r < s || s > e)
            return Long.MIN_VALUE;
        if (s >= l && e <= r) {
            return tree2[i];
        }
        int mid = (s + e) / 2;
        return Math.max(query2(2 * i + 1, s, mid, l, r) , query2(2 * i + 2, mid + 1, e, l, r));

    }

    public void update1(int l, int r, long v) {
        update1(0, 0, N - 1, Math.min(l, r), Math.max(l, r), v);
    }

    public void update1(int i, int s, int e, int l, int r, long v) {
        push1(i, s, e);
        if (l > e || r < s || s > e)
            return;
        if (s >= l && e <= r) {
            lazy1[i]+=  v;
            push1(i, s, e);
            return;
        }
        int mid = (s + e) / 2;
        update1(2 * i + 1, s, mid, l, r, v);
        update1(2 * i + 2, mid + 1, e, l, r, v);
        tree1[i] = Math.max(tree1[2 * i + 1] , tree1[2 * i + 2]);

    }

    public void update2(int l, int r, long v) {
        update2(0, 0, N - 1, Math.min(l, r), Math.max(l, r), v);
    }

    public void update2(int i, int s, int e, int l, int r, long v) {
        push2(i, s, e);
        if (l > e || r < s || s > e)
            return;
        if (s >= l && e <= r) {
            lazy2[i]+=  v;
            push2(i, s, e);
            return;
        }
        int mid = (s + e) / 2;
        update2(2 * i + 1, s, mid, l, r, v);
        update2(2 * i + 2, mid + 1, e, l, r, v);
        tree2[i] = Math.max(tree2[2 * i + 1] , tree2[2 * i + 2]);

    }
}
class FastReader {

    byte[] buf = new byte[2048];
    int index, total;
    InputStream in;

    FastReader(InputStream is) {
        in = is;
    }

    int scan() throws IOException {
        if (index >= total) {
            index = 0;
            total = in.read(buf);
            if (total <= 0) {
                return -1;
            }
        }
        return buf[index++];
    }

    String next() throws IOException {
        int c;
        for (c = scan(); c <= 32; c = scan()) ;
        StringBuilder sb = new StringBuilder();
        for (; c > 32; c = scan()) {
            sb.append((char) c);
        }
        return sb.toString();
    }

    int nextInt() throws IOException {
        int c, val = 0;
        for (c = scan(); c <= 32; c = scan()) ;
        boolean neg = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        for (; c >= '0' && c <= '9'; c = scan()) {
            val = (val << 3) + (val << 1) + (c & 15);
        }
        return neg ? -val : val;
    }

    long nextLong() throws IOException {
        int c;
        long val = 0;
        for (c = scan(); c <= 32; c = scan()) ;
        boolean neg = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        for (; c >= '0' && c <= '9'; c = scan()) {
            val = (val << 3) + (val << 1) + (c & 15);
        }
        return neg ? -val : val;
    }
}
