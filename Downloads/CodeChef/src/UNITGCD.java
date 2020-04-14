import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UNITGCD {
    static int sieve(boolean[] primes, int x)
    {
        primes[1] = true;

        // if a number is prime mark all its multiples
        // as non prime
        int count=0;
        for (int i=2; i*i <= x; i++)
        {

            if (primes[i] == false)
            {
                for (int j=2; j*i <= x; j++) {
                    primes[i * j] = true;
                    if(i==2)
                    count++;
                }
            }
        }
        return count+1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test_case=Integer.parseInt(br.readLine());
        for(int i=0;i<test_case;i++){
        int b = Integer.parseInt(br.readLine());
        boolean[] primes = new boolean[b + 1];
        System.out.println(sieve(primes, b));

        System.out.print(1 + " ");
        for (int j = 2; j <= b; j++) {
            if (!primes[j]) {
                System.out.print(j + " ");
            }

        }
        System.out.println();
        for (int j = 2; j <= b; j++) {
            if(primes[j]){
                if(j%2==0)
                    System.out.println(j+" ");
                else System.out.print(j+" ");
            }
        }
    }
    }
}
