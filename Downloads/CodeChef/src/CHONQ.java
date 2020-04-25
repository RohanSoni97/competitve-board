import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CHONQ {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int test_case=Integer.parseInt(in.readLine());
        for (int j=0;j<test_case;j++) {
            args = in.readLine().split(" ");
            int N = Integer.parseInt(args[0]);
            int K = Integer.parseInt(args[1]);
            args = in.readLine().split(" ");
            int ar[] = new int[N];
            ar[N - 1] = Integer.parseInt(args[N - 1]) / (N - 1);
            if (ar[N - 1] <= K) {
                for (int i = N - 2; i >= 0; i--) {
                    ar[i] = Integer.parseInt(args[i]) / (i) + ar[i + 1];
                    if (ar[i] >= K) {
                        System.out.println(i);
                        break;
                    }
                }
            }
            else {
                System.out.println(N-1);
            }
        }
    }
}
