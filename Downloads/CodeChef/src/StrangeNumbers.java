import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

 class StrangeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test_case=Integer.parseInt(br.readLine());
        for(int i=0;i<test_case;i++) {
            args = br.readLine().split(" ");
            int X, K;
            X = Integer.parseInt(args[0]);
            K = Integer.parseInt(args[1]);
            if(X==1)
            {
                if(K==0)
                    System.out.println(1);
                else System.out.println(0);
            }
            else if(K<= primeFactors(X))
                System.out.println(1);
            else System.out.println(0);
        }
    }

    private static int primeFactors(int x) {
        int count = 0;
        while (x % 2 == 0) {
            x = x / 2;
            count += 1;
        }
        for (int i =3;i< (Math.sqrt(x))+1;i+= 2) {
            while (x % i == 0) {
                x = x / i;
                count += 1;
            }

        }
        if (x > 2)
        count += 1;
        return count;

    }
}
