import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;

class D4 {

    static int MAXN = 100000;
    public static void main(String args[]) throws Exception {
        int t = scn.nextInt();
        while (t-- > 0) {
            int n = scn.nextInt();
            int k = scn.nextInt();
            int[] start = new int[MAXN];
            int[] end = new int[MAXN];
            int[] arr = new int[MAXN];
            Pair[] q = new Pair[n];
            for(int i=0; i<n; i++){
                int l = scn.nextInt()-1;
                int r = scn.nextInt()-1;
                q[i] = new Pair(l,r);
                start[l]++;
                end[r]++;
            }
            int cur = 0;
            for(int i=0; i<MAXN; i++){
                if(start[i]>0){
                    cur+=start[i];
                }
                arr[i] += cur;
            }
            cur = 0;
            for(int i=0; i<MAXN; i++){
                arr[i] += cur;
                if(end[i]>0){
                    cur-=end[i];
                }
            }
//            System.out.println(Arrays.toString(arr));
            ArrayList<Integer> idx = new ArrayList<>();
            ArrayList<Integer> idx1 = new ArrayList<>();
            int count = 0;
            for(int i=0; i<MAXN; i++){
                if(arr[i] == k){
                    count++;
                    idx.add(i);
                }else if(arr[i] == k+1){
                    idx1.add(i);
                }
            }
            Collections.sort(idx);
            Collections.sort(idx1);
            int max = Integer.MIN_VALUE;
            for(int i=0; i<n; i++){
                int l = Collections.binarySearch(idx, q[i].x);
                int r = Collections.binarySearch(idx, q[i].y);
                int l1 = Collections.binarySearch(idx1, q[i].x);
                int r1 = Collections.binarySearch(idx1, q[i].y);
                if(l<0){
                    l = -(l+1);
                }
                if(r<0){
                    r = -(r+1);
                }else{
                    r++;
                }

                if(l1<0){
                    l1 = -(l1+1);
                }
                if(r1<0){
                    r1 = -(r1+1);
                }else{
                    r1++;
                }

                int j = r-l;
                int m = r1-l1;
                j = Math.max(0,j);
                m = Math.max(0,m);
//                System.out.println(j+" "+m+" "+(count-j+m));
                max = Math.max(count-j+m, max);
            }
            out.println(max);
        }
        out.close();
    }

    static class Pair implements Comparable<Pair> {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return this.x + " [" + this.y + "]";
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.x, o.x);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Pair) {
                Pair o = (Pair) obj;
                return this.y == o.y;
            }
            return false;
        }
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();

            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }

                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String nextLine() {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public int nextInt() {
            int c = read();

            while (isSpaceChar(c))
                c = read();

            int sgn = 1;

            if (c == '-') {
                sgn = -1;
                c = read();
            }

            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));

            return res * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;

            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
            return res * sgn;
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, nextInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));

            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }

    public static InputReader scn = new InputReader(System.in);
    public static PrintWriter out = new PrintWriter(System.out);
}