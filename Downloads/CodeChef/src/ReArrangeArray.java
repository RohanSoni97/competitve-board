public class ReArrangeArray {
    public static void main(String[] args) {
        int arr[]={3,2,0,1};
        int [] result=reArrangeArray(arr);

    }

    private static int[] reArrangeArray(int[] arr) {
        int temp=0,temp_supp=0;
        for (int i=0;i<arr.length;i++)
        {
            if(i!=(temp=arr[i])){
                while (temp!=(temp_supp=arr[temp])){
                    arr[temp]=temp;
                    temp= temp_supp;
                }
            }
        }
        return arr;
    }
}
