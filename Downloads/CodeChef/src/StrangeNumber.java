import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class StrangeNumber {
    // applying sieve of eratosthenes
    static void sieve(boolean[] primes, int x)
    {
        primes[1] = true;

        // if a number is prime mark all its multiples
        // as non prime
        for (int i=2; i*i <= x; i++)
        {
            if (primes[i] == false)
            {
                for (int j=2; j*i <= x; j++)
                    primes[i*j] = true;
            }
        }
    }

    // function that returns numbers of number that have
// n divisors in range from a to b. x is sqrt(b) + 1.
    static int nDivisors(boolean[] primes, int x, int a, int b, int n,int K)
    {
        // result holds number of numbers having n divisors
        int result = 0;

        // vector to hold all the prime numbers between 1
        // ans sqrt(b)
        ArrayList<Integer> v=new ArrayList<Integer>();
        for (int i = 2; i <= x; i++)
            if (primes[i] == false)
                v.add(i);

        // Traversing all numbers in given range
        for (int i=a; i<=b; i++)
        {
            // initialising temp as i
            int temp = i;

            // total holds the number of divisors of i
            int total = 1;
            int j = 0,prime_count=0;

            // we need to use that prime numbers that
            // are less than equal to sqrt(temp)
            for (int k = v.get(j); k*k <= temp; k = v.get(++j))
            {
                // holds the exponent of k in prime
                // factorization of i
                int count = 0;

                // repeatedly divide temp by k till it is
                // divisible and accordingly increase count
                while (temp%k == 0)
                {
                    count++;
                    temp = temp/k;
                }

                // using the formula no.of divisors =
                // (e1+1)*(e2+1)....
                total = total*(count+1);
                prime_count++;

            }

            // if temp is not equal to 1 then there is
            // prime number in prime factorization of i
            // greater than sqrt(i)
            if (temp != 1)
                total = total*2;

            // if i is a ndvisor number increase result
            if (total == n && prime_count==K) {
                result=1;
                break;
            }
        }
        return result;
    }

    // Returns count of numbers in [a..b] having
// n divisors.
    static int countNDivisors(int a, int b, int n,int K,boolean[] primes,int x)
    {
        return nDivisors(primes, x, a, b, n,K);
    }

    // driver code
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test_case=Integer.parseInt(br.readLine());
        int  b = 1000000000;
        int x = (int)Math.sqrt(b) + 1;
        boolean[] primes=new boolean[x+1];
        sieve(primes, x);
        for(int i=0;i<test_case;i++) {
            args = br.readLine().split(" ");
            int X, K;
            X = Integer.parseInt(args[0]);
            K = Integer.parseInt(args[1]);
            int a = 1;
            if (countNDivisors(a, b, X, K,primes,x) == 1)
                System.out.println("1");
            else System.out.println("0");
        }
    }
}