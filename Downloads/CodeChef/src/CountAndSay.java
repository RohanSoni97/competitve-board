import java.util.HashMap;
import java.util.Map;

public class CountAndSay {
    public static void main(String[] args) {
        String A = "1";
        int n = 4,k;
        int len=A.length();
        while (n > 0) {
            int start = 0;
            String temp = "";
            char c;
            for (int i = 0; i < len-1; i++) {

                int j = i + 1;
                if ((c = A.charAt(i)) != A.charAt(j)) {
                     k = i - start + 1;
                    temp = temp + k + c;
                    start = j;
                }
            }
            n--;
            k=len-start;
            temp=temp+k+A.charAt(len-1);
            A=temp;
            len=A.length();
        }
        System.out.println(A);
    }
}
