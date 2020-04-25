import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in Actual solution is at the top
 *
 * @author @Ziklon
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        MaxRangeQueries solver = new MaxRangeQueries();
        solver.solve(1, in, out);
        out.close();
    }

    static class MaxRangeQueries {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            final int SIZE = 100000;
            int t = in.readInt();
            for (int i = 0; i < t; ++i) {
                int n = in.readInt(), k = in.readInt();

                int[] counter = new int[SIZE + 5];
                int[] values = new int[SIZE + 5];
                int[] xs = new int[n];
                int[] ys = new int[n];
                for (int j = 0; j < n; ++j) {
                    int x = in.readInt() - 1, y = in.readInt() - 1;
                    xs[j] = x;
                    ys[j] = y;
                    counter[x]++;
                    counter[y + 1]--;
                }

                int val = 0;
                for (int j = 0; j < counter.length; ++j) {
                    val += counter[j];
                    values[j] = val;
                }

                int[] counterK = calculateCounterK(values, k);
                int[] counterKPlus = calculateCounterK(values, k + 1);

                int ans = 0;
                for (int j = 0; j < n; ++j) {
                    int x = xs[j], y = ys[j];
                    int tmp = count(counterKPlus, x, y);
                    if (x > 0) tmp += count(counterK, 0, x - 1);
                    tmp += count(counterK, y + 1, SIZE + 3);
                    ans = Math.max(ans, tmp);
                }
                out.printLine(ans);
            }
        }

        int count(int[] prefix, int l, int r) {
            return prefix[r + 1] - prefix[l];
        }

        private int[] calculateCounterK(int[] values, int k) {
            int[] prefix = new int[values.length];
            for (int i = 0; i + 1 < values.length; ++i) {
                prefix[i + 1] = prefix[i] + (values[i] == k ? 1 : 0);
            }
            return prefix;
        }
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void close() {
            writer.close();
        }

        public void printLine(int i) {
            writer.println(i);
        }
    }
}
