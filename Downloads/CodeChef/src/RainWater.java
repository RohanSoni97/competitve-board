import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RainWater {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        args=br.readLine().split(" ");
        int n=args.length;
        int arr[]=new int[n];
        for (int i=0;i<n;i++)
        {
            arr[i]=Integer.parseInt(args[i]);
        }
        int height=getWater(arr);
        System.out.println(height);
    }

    private static int getWater(int[] arr) {
        int n=arr.length;
        if(n<3)
            return 0;
        int total_water=0;
        int i=0,j=n-1;
            int l=arr[0],r=arr[n-1];
            while (i<=j)
            {
                l=Math.max(l,arr[i]);r=Math.max(r,arr[j]);
                if(l<=r)
                {
                    total_water+=(l-arr[i++]);
                }
                else if(r<=l)
                {
                    total_water+=(r-arr[j--]);
                }
            }
            return total_water;

    }
}
/*

 */