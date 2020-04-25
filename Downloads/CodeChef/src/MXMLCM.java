import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MXMLCM {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test_case=Integer.parseInt(br.readLine());
        for(int j=0;j<test_case;j++) {
            args = br.readLine().split(" ");
            int N = Integer.parseInt(args[0]);
            int M = Integer.parseInt(args[1]);
            int arr[] = new int[N];
            args = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(args[i]);
            }
            long result = lcm_of_array_elements(arr,M);
            int count = -1;
            for (int i = 2; i < M; i++) {
                if (result % i != 0) {
                    count = i;
                }
            }
            if (count == -1)
                count = 1;
            System.out.println(count);
        }
    }
    public static long lcm_of_array_elements(int[] element_array,int m)
    {
        long lcm_of_array_elements = 1;
        int divisor = 2;

        while (true) {
            int counter = 0;
            boolean divisible = false;
            if(element_array.length<m)
                m=element_array.length;
            for (int i = 0; i < m; i++) {

                // lcm_of_array_elements (n1, n2, ... 0) = 0.
                // For negative number we convert into
                // positive and calculate lcm_of_array_elements.

                if (element_array[i] == 0) {
                    return 0;
                }
                else if (element_array[i] < 0) {
                    element_array[i] = element_array[i] * (-1);
                }
                if (element_array[i] == 1) {
                    counter++;
                }

                // Divide element_array by devisor if complete
                // division i.e. without remainder then replace
                // number with quotient; used for find next factor
                if (element_array[i] % divisor == 0) {
                    divisible = true;
                    element_array[i] = element_array[i] / divisor;
                }
            }

            // If divisor able to completely divide any number
            // from array multiply with lcm_of_array_elements
            // and store into lcm_of_array_elements and continue
            // to same divisor for next factor finding.
            // else increment divisor
            if (divisible) {
                lcm_of_array_elements = lcm_of_array_elements * divisor;
            }
            else {
                divisor++;
            }

            // Check if all element_array is 1 indicate
            // we found all factors and terminate while loop.
            if (counter == element_array.length) {
                return lcm_of_array_elements;
            }
        }
    }
}
