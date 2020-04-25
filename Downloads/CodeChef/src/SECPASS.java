import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SECPASS {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        long T = Long.parseLong(in.readLine());

        for (long t = 0; t < T; t++) {

            int N = Integer.parseInt(in.readLine());
            String string = in.readLine();
            char[] str = string.toCharArray();

            int[] ocurrPos = new int[N];
            int numOfOCurr = 0;

            for (int i = 0; i < N; i++ ) {
                if (str[i] == str[0]) {
                    ocurrPos[numOfOCurr] = i;
                    numOfOCurr ++;
                }
            }

            if (numOfOCurr == 1) {
                System.out.println(string);
                continue;
            }

            int pos = 0;
            boolean thereIsOneEq = true;
            while(thereIsOneEq && pos + 1 < N) {
                pos++;
                char cur = str[pos];
                for (int j = 0; j < numOfOCurr; j++) {
                    if ( ocurrPos[j] + pos < N && cur != str[ocurrPos[j] + pos]) {
                        thereIsOneEq = false;
                    }
                    if (ocurrPos[j] + pos >= N) {
                        thereIsOneEq = false;
                    }
                }

            }

            System.out.println( string.substring(0, pos) );

        }

    }

}
