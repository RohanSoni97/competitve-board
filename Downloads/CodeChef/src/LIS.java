

public class LIS {
    public static void main(String[] args)  {

        int arr[]=new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        lis(arr);
    }

    private static void lis(int[] arr) {
        int aux[]=new int[2000];
        int max=-1;
        for(int i=arr.length-2;i>=0;i--)
        {
            int j=i+1;
         while (j<=arr.length-1)
         {
             if(arr[i]<arr[j])
             {
                 aux[arr[i]]=aux[arr[j]]+1;
                 if(max<aux[arr[i]])
                     max=aux[arr[i]];

             }
             else {
                 j++;
             }
         }
        }
        System.out.println(max+1);
    }
}
